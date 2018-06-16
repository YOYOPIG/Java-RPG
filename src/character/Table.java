package character;

import audio.AudioPlayer;
import game.Game;
import level.Level;

public class Table extends NPCWithItem{
	
	public Table(Level gameLevel, int itemID) {
		super(gameLevel,itemID);
		// add sound
		sound = new AudioPlayer("res/Audios/open_box.wav");
		msg.add("A rotten table with a potion on it.");
		msg.add("Item acquired!!");
	}
	
	public void setDialog() {
		msg.clear();
		msg.add("A rotten table with a potion on it.");
	}

}
