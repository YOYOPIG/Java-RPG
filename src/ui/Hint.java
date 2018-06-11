/** 
 * This class adds the hint pop up layer into the game.
 * To show a certain message, please use the showHint() method, using a string(ur message)
 * as argument.
 * @version 1.2
 * @since   2018-06-11
 */

package ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import game.Game;

public class Hint {
	private JLabel textbox; //the text to be shown
	
	public Hint()
	{
		System.out.println("Error! Please send a JLayeredPane to the Hint class.");
	}
	
	public Hint(JLayeredPane layerPane)
	{
		//initialize the text box to show
		textbox = new JLabel("E : Interact",JLabel.LEFT);
		textbox.setFont(new java.awt.Font("TimesRoman", java.awt.Font.PLAIN, 30));
		textbox.setVerticalAlignment(JLabel.CENTER);
		textbox.setHorizontalAlignment(JLabel.CENTER);
		//textbox.setBackground(new Color(0, 0, 0, 0));
		textbox.setForeground(Color.white);
		//textbox.setOpaque(false);
		// set position and dimension
		textbox.setBounds(530, Game.HEIGHT + 566, 250, 50);
		textbox.setVisible(true);
		layerPane.add(textbox, new Integer(2));
		hideHint();
	}
	
	// show
	public void showHint(String msg)
	{
		textbox.setVisible(true);
		textbox.setText(msg);
	}
		
	// hide
	public void hideHint()
	{
		textbox.setVisible(false);
	}
		
}
