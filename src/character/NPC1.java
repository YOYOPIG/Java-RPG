package character;

import level.Level;

public class NPC1 extends NPCWithItem{
	
	public NPC1(Level gameLevel,int itemID)
	{
		super(gameLevel,itemID);
		msg.add("Hello, PLAYER");
	}
	
	public void missionCompleted() {
		System.out.println("Here");
	}
	
	@ Override
	public void setDialog() {
		msg.clear();
	}
	
	
}
