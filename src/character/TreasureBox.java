package character;

import audio.AudioPlayer;
import game.Game;
import level.Level;
import level.Level1;
import level.tiles.*;
import ui.MainUI;


public class TreasureBox extends NPC{
	
	Level currentLevel;
	private AudioPlayer sound;
	private boolean isOpened;
	private int ID;
	public TreasureBox(Level gameLevel, int itemID) {
		
		super(1);
		sound = new AudioPlayer("res/Audios/open_box.wav");
		ID = itemID;
		msg.add("Items acquired!!");
		msg.add("ENDOFLINE");
		// take real level1 as parameter 
		currentLevel = gameLevel;
		isOpened=false;
	}
	
	public void talkTo(int position) {
		
		if(msg.get(0).equals("ENDOFLINE"))
		{
			if(!isOpened) {
				isOpened=true;
				Game.ui.acquireItem(ID);
				// set new dialog
				setDialog();
			}
			Game.dialog.hideDialog();
			isTalking=false;
			if(isOpened) 
				msg.add(msg.get(0));
			// if the first element endfiline, remove it
			msg.remove(0);
		}
		else
		{
			if(!isOpened)
			{
				sound.play();
			}
			isTalking = true;
			// rendering opened pic
			currentLevel.renderingOpen(position,ID);
			msg.add(msg.get(0));
			Game.dialog.showDialog(msg.remove(0));
		}
	}
	
	public void setDialog() {
		// clear dialog list
		msg.clear();
		msg.add("This is empty!");
		msg.add("ENDOFLINE");
	}
	
}

