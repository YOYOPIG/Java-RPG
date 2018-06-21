package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.xml.stream.events.Namespace;

import audio.AudioPlayer;
import character.Candle;
import character.Door;
import character.Ghost;
import character.Lattern;
import character.NPC;
import character.NPC1;
import character.Table;
import character.TreasureBox;
import game.entities.Player;
import gfx.Colours;
import gfx.Font;
import gfx.Screen;
import gfx.SpriteSheet;
import level.Level;
import level.Level1;
import level.LevelDark;
import level.StartLevel;
import level.LevelFloor;
import ui.Dialog;
import ui.Hint;
import ui.MainUI;

public class Game extends Canvas implements Runnable {
	
	//player tile
	public int playerXTile=0;
	public int playerYTile=0;
	public static Game game;

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH / 12 * 8;
	public static final int SCALE = 8;
	public static final String NAME = "Game";

	private JFrame frame;

	public boolean running = false;
	public int tickCount = 0;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private int[] colours = new int[6 * 6 * 6];

	private Screen screen;
	public InputHandler input;

	// levels
	public Level levelFloor;
	public Level level1;
	public Level levelDark;

	public Level startLevel;
	public Font font;

	public Player player;

	// gameObject
	private NPC1 npc1;
	private TreasureBox treasureBoxPotion;
	private TreasureBox treasureBoxGhost;
	private Table table;
	private Door doorR1ToHallway;
	private Candle candle;
	private Lattern lattern;
	// UI
	public static Dialog dialog;
	public static Hint hint;
	public static MainUI ui;

	// AudioPlayer
	private AudioPlayer bgmPlayer;

	// boolean for menu
	boolean startIsSelected = false;
	boolean endIsSelected = false;
	int colourup = Colours.get(-1, -1, -1, 222), colourdown = Colours.get(-1, -1, -1, 222);
	boolean gameStarted = false;

	// boolean to test game whether stop
	boolean gameOver = false;
	boolean gameOverMusicPlaying = false;

	public Game() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		frame = new JFrame(NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		// frame.setLayout(null);
		frame.add(this, BorderLayout.CENTER);
		// frame.add(this);
		frame.pack();
		// Container contentPane = frame.getContentPane();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		// init dialog
		dialog = new Dialog(frame.getLayeredPane());
		hint = new Hint(frame.getLayeredPane());
		ui = new MainUI(frame.getLayeredPane());
		// Font.render("E Interact", screen, 100, 100, Colours.get(-1, -1, -1, 555));
		// frame.add(dialog.panel,BorderLayout.SOUTH);
		// contentPane.add(dialog.panel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	public void init() {

		int index = 0;
		for (int r = 0; r < 6; r++) {
			for (int g = 0; g < 6; g++) {
				for (int b = 0; b < 6; b++) {
					int rr = (r * 255 / 5);
					int gg = (g * 255 / 5);
					int bb = (b * 255 / 5);

					colours[index++] = rr << 16 | gg << 8 | bb;
				}
			}
		}

		screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite_sheet.png"));
		input = new InputHandler(this);

		// Want to render Font as Menu

		// level initialization
		levelFloor = new LevelFloor(64, 64);
		level1 = new Level1(64, 64);
		
		//**********************************************
		levelDark = new LevelDark(64, 64);
		//**********************************************
		
		// passing current level to treasureBox
		// 0 stands for no-item box
		player = new Player(level1, 0, 0, input);
		treasureBoxGhost = new TreasureBox(level1, 0,400);
		npc1 = new NPC1(level1,1,455);
		// a table with purple potion on it
		table=new Table(level1,2,3+3*Level.width);
		treasureBoxPotion = new TreasureBox(level1, 4 ,600);
		doorR1ToHallway = new Door(level1, 5, 1800);
		candle = new Candle();
		lattern  = new Lattern(level1,7,1579);
		// each audioplayer object plays a song

		// Play Bgm by new AudioPlay
		bgmPlayer = new AudioPlayer("./res/bgm.wav");
		bgmPlayer.play();
		// u call loop ,u loop it
		bgmPlayer.loop();

	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 30D;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		init();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				render();

			}
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				frames = 0;
				ticks = 0;
			}

		}
	}

	// input handling the dialog
	public void tick() {
		tickCount++;

		/* hide and show the hint */
		if (Player.itemID >= 4) {
			hint.showHint("[E] INTERACT");
		} else {
			hint.hideHint();
		}
		
		// if collide with something
		if(Player.itemID >= 4) {
			int NPCID = Player.itemID / 4;
			// press 4 and 
			if(input.item4.getKeyDown() && ui.getBluePotionVisibility() && NPCID==1)
				npc1.missionCompleted();
			else if(input.item2.getKeyDown() && ui.getPotionVisibility() && NPCID==1) {
				level1.renderingOpen( npc1.getPosition(),npc1.getID());
				gameOver=true;
			}
			else if(input.item1.getKeyDown() && ui.getKeyVisibility() && NPCID==4) {
				level1.renderingOpen(doorR1ToHallway.getPosition(), doorR1ToHallway.getID());
			}
			
		}
		else //if no collide, we can see item description
		{
			if(input.item1.getKeyDown()&& ui.getKeyVisibility())
				ui.showItemDescription(1);
			else if(input.item2.getKeyDown()&& ui.getPotionVisibility())
				ui.showItemDescription(2);
			else if(input.item4.getKeyDown()&& ui.getBluePotionVisibility())
				ui.showItemDescription(4);
		}

		// to interact use input.interact.getPressed() to return if E is pressed.
		if (input.interact.getKeyDown() && Player.itemID >= 4) {
			int NPCID = Player.itemID / 4;
			if (NPCID == 1) {
				npc1.talkTo();
			} else if (NPCID == 2 || NPCID == 25) {
				treasureBoxPotion.talkTo(600);
			}  else if (NPCID == 6) {
				treasureBoxGhost.talkTo(400);
				gameOver = true;
			} else if (NPCID == 7 || NPCID == 8 || NPCID == 9 || NPCID == 10) {
				table.talkTo(3);
			} else if(NPCID==4 || NPCID==14) {
				doorR1ToHallway.talkTo();
			} else if(NPCID==15) {
				candle.talkTo();
			} else if(NPCID==17) {
				lattern.talkTo(lattern.getPosition());
			}
		}
		levelFloor.tick();
		level1.tick();

		//**********************************************
		levelDark.tick();
		//**********************************************
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		double xOffset = player.x - (screen.width / 2);
		double yOffset = player.y - (screen.height / 2);

		//System.out.println("player x:"+player.x+" play y:"+player.y);
		playerXTile=player.x/8+1;
		playerYTile=player.y/8+1;
		//System.out.println("player x tile:"+playerXTile+" play y tile:"+playerYTile);
		
		levelFloor.renderTiles(screen, xOffset, yOffset);
		levelFloor.renderEntities(screen);
		level1.renderTiles(screen, xOffset, yOffset);
		level1.renderEntities(screen);
		

		//**********************************************
		levelDark.renderTiles(screen, xOffset, yOffset);
		levelDark.renderEntities(screen);
		//**********************************************

		startMenu();

		// Render Game Over!!
		if (gameOver) {
			bgmPlayer.stop();
			if (!gameOverMusicPlaying) {
				AudioPlayer gameOverMusic = new AudioPlayer("./res/gameOver.wav");
				gameOverMusic.play();
				gameOverMusic.loop();
				gameOverMusicPlaying=true;
			}
			Font.render("Game Over!", screen, WIDTH / 2 - "Game Over!".length() * 8 / 2 + (int) xOffset,
					20 + (int) yOffset, Colours.get(333, -1, -1, 555));
			Font.render("You Die!", screen, WIDTH / 2 - "You Die!".length() * 8 / 2 + (int) xOffset,
					20 + (int) yOffset + 8, Colours.get(333, -1, -1, 500));
		}

		for (int y = 0; y < screen.height; y++) {
			for (int x = 0; x < screen.width; x++) {
				int colourCode = screen.pixels[x + y * screen.width];
				if (colourCode < 255)
					pixels[x + y * WIDTH] = colours[colourCode];
			}
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	private void startMenu() {
		if (!gameStarted) {
			if (input.selectUp.getKeyDown()) {
				startIsSelected = true;
				endIsSelected = false;
			}
			if (input.selectDown.getKeyDown()) {
				endIsSelected = true;
				startIsSelected = false;
			}
			if (startIsSelected) {
				colourup = Colours.get(-1, -1, -1, 555);
			}

			else
				colourup = Colours.get(-1, -1, -1, 444);
			if (endIsSelected) {
				colourdown = Colours.get(-1, -1, -1, 555);
			} else
				colourdown = Colours.get(-1, -1, -1, 444);

			if (startIsSelected && input.enter.getKeyDown()) {
				// start game
				gameStarted = true;
				level1.addEntity(player);
			} else if (endIsSelected && input.enter.getKeyDown()) {
				// do end application
				
				System.out.println("close application");
			}

			if (!gameStarted) {
				Font.render("Start", screen, WIDTH / 2 - "Start".length() * 8 / 2, HEIGHT / 2, colourup);
				Font.render("End", screen, WIDTH / 2 - "End".length() * 8 / 2, HEIGHT / 2 + 8, colourdown);
			} else {
				Font.render("", screen, WIDTH / 2 - "Start".length() * 8 / 2, HEIGHT / 2, colourup);
				Font.render("", screen, WIDTH / 2 - "End".length() * 8 / 2, HEIGHT / 2 + 8, colourdown);
			}
		}
	}

	public static void main(String[] args) {
		game = new Game();
		game.start();
		
	}

}
