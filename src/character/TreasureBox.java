package character;

import game.Game;
import level.Level;
import level.Level1;
import level.tiles.*;


public class TreasureBox extends NPC{
	
	Level currentLevel;
	
	public TreasureBox(Level gameLevel) {
		
		super(1);
		msg.add("Items acquired!!");
		msg.add("ENDOFLINE");
		// take real level1 as parameter 
		currentLevel = gameLevel;
		
	}
	
	public void talkTo() {
		
		if(msg.get(0).equals("ENDOFLINE"))
		{
			Game.dialog.hideDialog();
			isTalking=false;
			// set new dialog
			setDialog();
		}
		else
		{
			isTalking = true;
			// rendering opened pic
			currentLevel.renderingOpen(400);
			Game.dialog.showDialog(msg.remove(0));
		}
	}
	
	public void setDialog() {
		msg.clear();
		msg.add("This is empty!");
		msg.add("ENDOFLINE");
	}
}

