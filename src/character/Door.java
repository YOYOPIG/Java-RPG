package character;

import level.Level;

public class Door extends NPCWithItem{

	public Door(Level level, int ID, int p) {
		super(level, ID, p);
		
	}

	@Override
	public void setDialog() {
		
	}

	@Override
	public void setNormalDialog() {
		msg.clear();
		msg.add("Seems like locked.");
	}

}
