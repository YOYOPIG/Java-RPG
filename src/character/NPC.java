package character;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import audio.AudioPlayer;
import game.Game;



public abstract class NPC {
	
	protected int ID;
	protected ArrayList<String> msg = new ArrayList<String>(); ;
	public static boolean isTalking;
	protected AudioPlayer sound;
	private int position;
	
	public NPC(int ID,int p) {
		this.ID=ID;
		position=p;
	}
	
	public void talkTo() {
		
		if(msg.isEmpty())
		{
			Game.dialog.hideDialog();
			isTalking=false;
			setNormalDialog();
			System.out.println("here!!");
		}
		else
		{
			System.out.println("here for first!");
			isTalking = true;
			Game.dialog.showDialog(msg.remove(0));
			if( !msg.isEmpty() && msg.get(0).equals("Item acquired!"))
				sound.play();
		}
	};
	
	public int getID() {
		return ID;
	}
	
	public int getPosition() {
		return position;
	}
	
	public abstract void setDialog();
	public abstract void setNormalDialog();

}
