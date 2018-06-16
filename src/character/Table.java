package character;

import audio.AudioPlayer;
import game.Game;
import level.Level;

public class Table extends NPCWithItem{
	
	public Table(Level gameLevel, int itemID,int p) {
		super(gameLevel,itemID,p);
		// add sound
		sound = new AudioPlayer("res/Audios/open_box.wav");
		msg.add("A rotten table with a potion on it.");
		msg.add("Item acquired!");
	}
	
	public void setDialog() {
		msg.clear();
		msg.add("A rotten table with a potion on it.");
	}

	@Override
	public void setNormalDialog() {
		// TODO Auto-generated method stub
		
	}

}
