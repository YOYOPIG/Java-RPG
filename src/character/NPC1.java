package character;

public class NPC1 extends NPC{
	
	public NPC1()
	{
		super(0);
		msg.add("Hello, PLAYER");
	}
	
	public void missionCompleted() {
		System.out.println("Here");
	}
	
	
}
