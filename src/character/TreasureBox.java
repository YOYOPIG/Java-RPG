package character;

import audio.AudioPlayer;
import game.Game;
import level.Level;
import level.Level1;
import level.tiles.*;
import ui.MainUI;


public class TreasureBox extends NPCWithItem{
	
	public TreasureBox(Level gameLevel, int itemID) {
		super(gameLevel,itemID);
		sound = new AudioPlayer("res/Audios/open_box.wav");
		msg.add("Items acquired!!");
	}

	@Override
	public void setDialog() {
		msg.clear();
		msg.add("This is empty!!!");
	}
	

	
}

