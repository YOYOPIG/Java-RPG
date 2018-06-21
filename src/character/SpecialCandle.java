package character;

import level.Level;

public class SpecialCandle extends NPCWithItem{
	public SpecialCandle(Level gameLevel, int itemID,int p) {
		super(gameLevel, itemID, p);
		msg.add("A normal candle.");
	}

	@Override
	public void setDialog() {
	
		
	}

	@Override
	public void setNormalDialog() {
		msg.clear();
		msg.add("A normal candle.");
	}
}
