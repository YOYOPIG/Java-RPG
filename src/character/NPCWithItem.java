package character;

import java.util.ArrayList;

import audio.AudioPlayer;
import game.Game;
import level.Level;
import level.Level1;

public abstract class NPCWithItem extends NPC{
	
	protected Level currentLevel;
	protected boolean isProcessed;
	
	public NPCWithItem(Level level,int ID,int p) {
		super(ID,p);
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
			}
			
			if(msg.get(0).equals("Item acquired!"))
				sound.play();
			
			isTalking = true;
			// rendering opened pic
			// 3 is table with potion
			if(ID==2) 
				currentLevel.renderingOpen(position,ID,3);	
			else if(getID()!=1)
				currentLevel.renderingOpen(position,ID);
			// display msg
			Game.dialog.showDialog(msg.remove(0));
		}
	}

	public abstract void setDialog();
}
