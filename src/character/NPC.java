package character;

import java.util.ArrayList;

import game.Game;
import level.Level;
import level.Level1;


public abstract class NPC {
	protected int ID;
	protected ArrayList<String> msg = new ArrayList<String>(); ;
	public static boolean isTalking;
	
	public NPC(int ID) {
		this.ID=ID;
	}
	
	public void talkTo() {
		
		if(msg.isEmpty())
		{
			Game.dialog.hideDialog();
			isTalking=false;
		}
		else
		{
			isTalking = true;
			Game.dialog.showDialog(msg.remove(0));
		
		}
	};
		
}
