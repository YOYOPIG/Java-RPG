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
		
		if(msg.get(0).equals("ENDOFLINE"))
		{
			Game.dialog.hideDialog();
			isTalking=false;
			// push back the first dialog
			msg.add(msg.get(0));
			msg.remove(0);
		}
		else
		{
			isTalking = true;
			// push back the first dialog
			msg.add(msg.get(0));
			Game.dialog.showDialog(msg.remove(0));
		
		}
	};
		
}
