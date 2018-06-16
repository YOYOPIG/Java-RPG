package character;

import game.Game;
import level.Level;
import level.Level1;
import level.tiles.*;


public class TreasureBox extends NPC{
	
	Level currentLevel;
	private boolean isOpened;  
	public TreasureBox(Level gameLevel) {
		
		super(1);
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
			isTalking = true;
			// rendering opened pic
			currentLevel.renderingOpen(position);
			if(isOpened) {
				msg.add(msg.get(0));
			}
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

