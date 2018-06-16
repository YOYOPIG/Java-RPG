package character;

import java.util.ArrayList;

import audio.AudioPlayer;
import game.Game;



public abstract class NPC {
	
	protected int ID;
	protected ArrayList<String> msg = new ArrayList<String>(); ;
	public static boolean isTalking;
	protected AudioPlayer sound;
	
	public NPC(int ID) {
		this.ID=ID;
	}
	
	public void talkTo() {
		
		if(msg.isEmpty())
		{
			Game.dialog.hideDialog();
			isTalking=false;
			setDialog();
		}
		else
		{
			isTalking = true;
			Game.dialog.showDialog(msg.remove(0));
		}
	};
	
	public abstract void setDialog();

}
