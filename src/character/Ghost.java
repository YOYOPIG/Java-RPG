package character;

import game.Game;
import ui.Dialog;

public class Ghost {
	public int ID;
	private String[] msg = new String[10];
	private int talkctr;
	
	public Ghost()
	{
		talkctr = 0;
		ID = 0;
		msg[0] = "Hello, PLAYER";
		msg[1] = "Welcome to THE GAME";
		msg[2] = "Press E to keep talking";
		msg[3] = "But I have nothing to say now";
		msg[4] = "Bye, have a great time!";
		msg[5] = "ENDOFLINE";
	}
	
	public void talkTo()
	{
		if(msg[talkctr].equals("ENDOFLINE"))
		{
			talkctr = 0;
			Game.dialog.hideDialog();
		}
		else
		{
			Game.dialog.showDialog(msg[talkctr]);
			talkctr++;
		}
	}
}
