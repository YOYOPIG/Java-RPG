package character;

import java.util.ArrayList;

import audio.AudioPlayer;
import game.Game;
import level.Level;
import level.Level1;

public abstract class NPCWithItem extends NPC{
	
	protected ArrayList<String> msg = new ArrayList<String>();
	protected Level currentLevel;
	protected boolean isProcessed;
	protected AudioPlayer sound;
	
	public NPCWithItem(Level level,int ID) {
		super(ID);
		currentLevel = level;
		isProcessed = false;
	}
	
	public void talkTo(int position) {
		if(msg.isEmpty())
		{
			// we don't want to show nothing
			Game.dialog.hideDialog();
			// set new dialog
			setDialog();
			// global talking is false
			isTalking=false;
		}
		else
		{
			if(!isProcessed)
			{
				// item is fetched
				isProcessed=true;
				// get item ID and put item into inventory
				Game.ui.acquireItem(ID);
				sound.play();
			}
			isTalking = true;
			// rendering opened pic
			// 3 is table with potion
			if(ID==3) 
				currentLevel.renderingOpen(position,ID,3);	
			else
				currentLevel.renderingOpen(position,ID);
			// display msg
			Game.dialog.showDialog(msg.remove(0));
		}
	}

	public abstract void setDialog();
}
