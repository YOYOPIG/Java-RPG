package character;

import audio.AudioPlayer;
import level.Level;

public class Lattern extends NPCWithItem{

	public Lattern(Level level, int ID, int p) {
		super(level, ID, p);
		sound = new AudioPlayer("res/Audios/open_box.wav");
		msg.add("An antique,lit lattern with the fire seeming never burnt out.");
		msg.add("Item acquired!");
	}

	@Override
	public void setDialog() {
		msg.clear();
		msg.add("An antique,lit lattern with the fire seeming never burnt out.");
	}

	@Override
	public void setNormalDialog() {
	}

}
