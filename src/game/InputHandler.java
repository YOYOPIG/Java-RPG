package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import audio.AudioPlayer;
import game.entities.Player;

/**
 * The InputHandler class implements the KeyListener class. This class can
 * handle w,a,s,d inputs to the game.
 * 
 * @version 1.5
 * @since 2018-06-16
 */

public class InputHandler implements KeyListener {

	/**
	 * The Constructor simply connects this class to the main game, making the class
	 * able to handle user input in the game.
	 * 
	 * @param game
	 *            The main game
	 */

	// audio player for this player
	private AudioPlayer footstepSFX1;
	private AudioPlayer footstepSFX2;
	private AudioPlayer footstepSFX3;
	private AudioPlayer footstepSFX4;

	public InputHandler(Game game) {
		game.addKeyListener(this);

		footstepSFX1 = new AudioPlayer("./res/footstep.wav");
		footstepSFX2 = new AudioPlayer("./res/footstep.wav");
		footstepSFX3 = new AudioPlayer("./res/footstep.wav");
		footstepSFX4 = new AudioPlayer("./res/footstep.wav");

	}

	public Key up = new Key();
	public Key left = new Key();
	public Key down = new Key();
	public Key right = new Key();
	public Key interact = new Key();
	
	//keys to use item
	public Key item1 = new Key();
	public Key item2 = new Key();
	public Key item3 = new Key();
	public Key item4 = new Key();
	public Key item5 = new Key();
	public Key item6 = new Key();
	
	
	//add new key to select menu 
	public Key selectUp = new Key();
	public Key selectDown = new Key();
	public Key enter = new Key();
	
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
		// System.out.println(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
		if (footstepSFX1 != null) {
			footstepSFX1.stop();
		}
		if (footstepSFX2 != null) {
			footstepSFX2.stop();
		}
		if (footstepSFX3 != null) {
			footstepSFX3.stop();
		}
		if (footstepSFX4 != null) {
			footstepSFX4.stop();
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	/**
	 * This method sets each keys' status(pressed or not)
	 */
	public void toggleKey(int keyCode, boolean pressStatus) {
		if (keyCode == KeyEvent.VK_W) {
			footstepSFX1.play();
			footstepSFX1.loop();
			up.setPressed(pressStatus);
		}
		if (keyCode == KeyEvent.VK_A) {
			footstepSFX2.play();
			footstepSFX2.loop();
			left.setPressed(pressStatus);
		}
		if (keyCode == KeyEvent.VK_S) {
			footstepSFX3.play();
			footstepSFX3.loop();
			down.setPressed(pressStatus);
		}
		if (keyCode == KeyEvent.VK_D) {
			footstepSFX4.play();
			footstepSFX4.loop();
			right.setPressed(pressStatus);
		}
		if (keyCode == KeyEvent.VK_E) {
			interact.setPressed(pressStatus);
		}
		
		if (keyCode == KeyEvent.VK_UP) {
			selectUp.setPressed(pressStatus);
		}
		
		if (keyCode == KeyEvent.VK_DOWN) {
			selectDown.setPressed(pressStatus);
		}
		
		if (keyCode == KeyEvent.VK_ENTER) {
			enter.setPressed(pressStatus);
		}
		
		if (keyCode == KeyEvent.VK_1) {
			item1.setPressed(pressStatus);
		}
		
		if (keyCode == KeyEvent.VK_2) {
			item2.setPressed(pressStatus);
		}
		
		if (keyCode == KeyEvent.VK_3) {
			item3.setPressed(pressStatus);
			System.out.println(Player.itemID/4);
		}
		
		if (keyCode == KeyEvent.VK_4) {
			item4.setPressed(pressStatus);
		}
		
		if (keyCode == KeyEvent.VK_5) {
			item5.setPressed(pressStatus);
		}
		
		if (keyCode == KeyEvent.VK_6) {
			item6.setPressed(pressStatus);
		}
	}
}
