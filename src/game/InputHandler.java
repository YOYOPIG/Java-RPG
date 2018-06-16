package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import audio.AudioPlayer;

/**
 * The InputHandler class implements the KeyListener class. This class can
 * handle w,a,s,d inputs to the game.
 * 
 * @version 1.0
 * @since 2018-05-26
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
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			footstepSFX1.play();
			footstepSFX1.loop();
			up.setPressed(pressStatus);
		}
		if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
			footstepSFX2.play();
			footstepSFX2.loop();
			left.setPressed(pressStatus);
		}
		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			footstepSFX3.play();
			footstepSFX3.loop();
			down.setPressed(pressStatus);
		}
		if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
			footstepSFX4.play();
			footstepSFX4.loop();
			right.setPressed(pressStatus);
		}
		if (keyCode == KeyEvent.VK_E) {
			interact.setPressed(pressStatus);
		}
	}
}
