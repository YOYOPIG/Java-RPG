package character;

import level.Level;

public class Door extends NPCWithItem{

	public Door(Level level, int ID, int p) {
		super(level, ID, p);
		
	}
	
	public void missionCompleted() {
		setDialog();
		talkTo(7);
	}

	@Override
	public void setDialog() {
		msg.clear();
		msg.add("It seems opened.");
	}

	@Override
	public void setNormalDialog() {
		msg.clear();
		msg.add("Seems like locked.");
	}

}
