/** 
 * This class adds the UI to the game.
 * Please send the JLayeredPane of the game frame as an parameter
 * To change HP value, simply call the changeHP function with new HP value as parameter
 * @version 1.0
 * @since   2018-06-11
 */
package ui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import game.Game;

public class MainUI {
	private JLabel hp;
	private JLabel inventory;
	private JLayeredPane pane;
	
	public MainUI()
	{
		System.out.println("Error! Please send a JLayeredPane to the Dialog class.");
	}
	
	public MainUI(JLayeredPane FL)
	{
		//initialize
		hp = new JLabel();
		inventory = new JLabel();
		// set position and dimension
		hp.setBounds(25, 25, 236, 70);
		inventory.setBounds(Game.WIDTH+260, Game.HEIGHT + 560, 496, 167);
		//add image
		ImageIcon icon = new ImageIcon("res/hp3.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(236, 70, BufferedImage.SCALE_SMOOTH));
		hp.setIcon(icon);
		ImageIcon icon2 = new ImageIcon("res/inventory.png");
		icon2 = new ImageIcon(icon2.getImage().getScaledInstance(496, 167, BufferedImage.SCALE_SMOOTH));
		inventory.setIcon(icon2);
		FL.add(hp, new Integer(1));
		FL.add(inventory, new Integer(1));
	}
	
	public void changeHP(int value)
	{
		if(value==1)
		{
			ImageIcon icon = new ImageIcon("res/hp1.png");
			icon = new ImageIcon(icon.getImage().getScaledInstance(236, 70, BufferedImage.SCALE_SMOOTH));
			hp.setIcon(icon);
		}
		else if(value==2)
		{
			ImageIcon icon = new ImageIcon("res/hp2.png");
			icon = new ImageIcon(icon.getImage().getScaledInstance(236, 70, BufferedImage.SCALE_SMOOTH));
			hp.setIcon(icon);
		}
		else if(value==3)
		{
			ImageIcon icon = new ImageIcon("res/hp3.png");
			icon = new ImageIcon(icon.getImage().getScaledInstance(236, 70, BufferedImage.SCALE_SMOOTH));
			hp.setIcon(icon);
		}
	}

}
