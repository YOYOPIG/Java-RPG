package character;

public class Candle extends NPC{
	public Candle() {
		super(6,6);
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
