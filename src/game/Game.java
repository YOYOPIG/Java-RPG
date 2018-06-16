package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import audio.MusicPlayer;
import character.Ghost;
import character.TreasureBox;
import game.entities.Player;
import gfx.Font;
import gfx.Screen;
import gfx.SpriteSheet;
import level.Level;
import level.Level1;
import level.LevelFloor;
import ui.Dialog;
import ui.Hint;
import ui.MainUI;


public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH / 12 * 8;
	public static final int SCALE = 8;
	public static final String NAME = "Game";

	private JFrame frame;

	public boolean running = false;
	public int tickCount = 0;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private int[] colours=new int[6*6*6];
	
	
	private Screen screen;
	public InputHandler input;
	
	//levels
	public Level levelFloor;
	public Level level1;
	
	public Font font;
	public Player player;
	
	// 
	private Ghost ghost;
	private TreasureBox treasureBoxPotion;
	private TreasureBox treasureBoxKey;
	// UI
	public static Dialog dialog;
	public static Hint hint;
	public MainUI ui;

	public Game() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		frame = new JFrame(NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		//frame.setLayout(null);
		frame.add(this, BorderLayout.CENTER);
		//frame.add(this);
		frame.pack();
		//Container contentPane = frame.getContentPane();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		// init dialog
		dialog=new Dialog(frame.getLayeredPane());
		hint=new Hint(frame.getLayeredPane());
		ui = new MainUI(frame.getLayeredPane());
		//Font.render("E Interact", screen, 100, 100, Colours.get(-1, -1, -1, 555));
		//frame.add(dialog.panel,BorderLayout.SOUTH);
		//contentPane.add(dialog.panel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		ghost = new Ghost();
		
	}

	public void init(){

		int index=0;
		for(int r=0;r<6;r++) {
			for(int g=0;g<6;g++) {
				for(int b=0;b<6;b++) {
					int rr=(r*255/5);
					int gg=(g*255/5);
					int bb=(b*255/5);
					
					colours[index++]=rr<<16|gg<<8|bb;
				}
			}
		}
		
		screen= new Screen(WIDTH,HEIGHT,new SpriteSheet("/sprite_sheet.png"));
		input = new InputHandler(this);
		
		//level initialization
		levelFloor = new LevelFloor(64, 64);
		level1=new Level1(64, 64);
		// passing current level to treasureBox
		treasureBoxPotion=new TreasureBox(level1);
		treasureBoxKey=new TreasureBox(level1);
		player = new Player(level1, 0, 0, input);
		level1.addEntity(player);
		
		//player BGM  but only play once, going to fix it to looping
		MusicPlayer musicPlayer = new MusicPlayer("bgm.wav");
		musicPlayer.run();
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
		if(Player.itemID >=4 ) {
			hint.showHint("[E] INTERACT");
		}
		else {
			hint.hideHint();
		}
		
		//to interact use input.interact.getPressed() to return if E is pressed.
		if(input.interact.getKeyDown() && Player.itemID >= 4 ) {
			int NPCID = Player.itemID/4;
			if(NPCID == 1) {
				ghost.talkTo();
			}
			else if(NPCID == 2) {
				treasureBoxPotion.talkTo(400);
			}
			else if(NPCID == 3) {
				treasureBoxKey.talkTo(600);
			}
		}
		levelFloor.tick();
		level1.tick();
}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		double xOffset = player.x - (screen.width/2);
		double yOffset = player.y - (screen.height/2);
		
		
		levelFloor.renderTiles(screen, xOffset, yOffset);
		levelFloor.renderEntities(screen);
		level1.renderTiles(screen, xOffset, yOffset);
		level1.renderEntities(screen);
		
		
	
//		for(int x = 0; x < levelFloor.width; x++) {
//			int colour = Colours.get(-1, -1, -1, 000);
//			if(x % 10 == 0 && x != 0)	colour = Colours.get(-1, -1, -1, 500);
//		}

		for(int y=0;y<screen.height;y++) {
			for(int x=0;x<screen.width;x++) {
				int colourCode=screen.pixels[x+y*screen.width];
				if(colourCode<255)pixels[x+y*WIDTH]=colours[colourCode];
			}
		}
		
		Graphics g=bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game().start();
	}

}
