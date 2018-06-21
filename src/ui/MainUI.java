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
	private JLabel key;
	private JLabel potion;
	private JLabel light;
	private JLabel bluePotion;
	private JLabel key2;
	private JLabel itemDescription;
	private JLabel jumpscare;
	private JLayeredPane pane;
	
	public MainUI()
	{
		System.out.println("Error! Please send a JLayeredPane to the Dialog class.");
	}
	
	public MainUI(JLayeredPane FL)
	{
		//initialize
		//hp = new JLabel();
		inventory = new JLabel();
		key = new JLabel();
		potion = new JLabel();
		light = new JLabel();
		bluePotion = new JLabel();
		key2 = new JLabel();
		itemDescription = new JLabel();
		jumpscare = new JLabel();
		
		// set position and dimension
		//hp.setBounds(25, 25, 236, 70);
		inventory.setBounds(Game.WIDTH+260, Game.HEIGHT + 560, 496, 167);
		key.setBounds(Game.WIDTH+285, Game.HEIGHT + 635, 65, 65);
		potion.setBounds(Game.WIDTH+365, Game.HEIGHT + 635, 65, 65);
		light.setBounds(Game.WIDTH+440, Game.HEIGHT + 635, 65, 65);
		bluePotion.setBounds(Game.WIDTH+512, Game.HEIGHT + 635, 65, 65);
		key2.setBounds(Game.WIDTH+590, Game.HEIGHT + 635, 65, 65);
		//itemDescription.setBounds(Game.WIDTH+320, Game.HEIGHT + 150, 386*2, 378*2);
		itemDescription.setBounds(Game.WIDTH+220, Game.HEIGHT, 579, 567);
		jumpscare.setBounds(Game.WIDTH, Game.HEIGHT, 900, 601);
		
		//add image
		ImageIcon icon = new ImageIcon("res/hp3.png");
		icon = new ImageIcon(icon.getImage().getScaledInstance(236, 70, BufferedImage.SCALE_SMOOTH));
		//hp.setIcon(icon);
		ImageIcon icon2 = new ImageIcon("res/inventory2.png");
		icon2 = new ImageIcon(icon2.getImage().getScaledInstance(496, 167, BufferedImage.SCALE_SMOOTH));
		inventory.setIcon(icon2);
		key.setIcon(new ImageIcon("res/key.png"));
		potion.setIcon(new ImageIcon("res/potion.png"));
		light.setIcon(new ImageIcon("res/light.png"));
		bluePotion.setIcon(new ImageIcon("res/blue_potion.png"));
		itemDescription.setIcon(new ImageIcon("res/keyUI.png"));
		key2.setIcon(new ImageIcon("res/key2.png"));
		jumpscare.setIcon(new ImageIcon("res/jump scare.jpg"));
		
		//add to frame
		//FL.add(hp, new Integer(1));
		FL.add(inventory, new Integer(1));
		FL.add(key, new Integer(2));
		FL.add(potion, new Integer(2));
		FL.add(light, new Integer(2));
		FL.add(bluePotion, new Integer(2));
		FL.add(key2, new Integer(2));
		FL.add(itemDescription, new Integer(2));
		FL.add(jumpscare, new Integer(3));
		key.setVisible(false);
		potion.setVisible(false);
		light.setVisible(false);
		bluePotion.setVisible(false);
		//key2.setVisible(false);
		itemDescription.setVisible(false);
		jumpscare.setVisible(false);
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
	
	public void acquireItem(int itemID)
	{
		switch (itemID) {
		case 1:
			key.setVisible(true);
			break;
		case 2:
			potion.setVisible(true);
			break;
		case 7:
			light.setVisible(true);
			break;
		case 4:
			bluePotion.setVisible(true);
			break;

		default:
			break;
		}
	}
	
	public void showItemDescription(int itemID)
	{
		if(itemDescription.isVisible())
			itemDescription.setVisible(false);
		else 
		{
			switch (itemID) {
			case 1:
				itemDescription.setIcon(new ImageIcon("res/keyUI2.png"));
				itemDescription.setVisible(true);
				break;
			case 2:
				itemDescription.setIcon(new ImageIcon("res/potionUI2.png"));
				itemDescription.setVisible(true);
				break;
			case 3:
				itemDescription.setIcon(new ImageIcon("res/lanternUI.png"));
				itemDescription.setVisible(true);
				break;
			case 4:
				itemDescription.setIcon(new ImageIcon("res/blueUI2.png"));
				itemDescription.setVisible(true);
				break;
			case 5:
				itemDescription.setIcon(new ImageIcon("res/key2UI.png"));
				itemDescription.setVisible(true);
				break;

			default:
				break;
			}
		}
	}
	
	public void jumpScare()
	{
		jumpscare.setVisible(true);
	}
	
	public boolean getKeyVisibility() {
		return key.isVisible();
	}
	public boolean getPotionVisibility() {
		return potion.isVisible();
	}
	public boolean getLightVisibility() {
		return light.isVisible();
	}
	public boolean getBluePotionVisibility() {
		return bluePotion.isVisible();
	}
	public boolean getMasterKeyVisibility() {
		return key2.isVisible();
	}

}
