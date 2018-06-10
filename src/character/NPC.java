package character;

public abstract class NPC {
	public int ID;
	protected String[] msg;
	protected int talkctr;
	
	public NPC(int ID,String[] m,int talkctr) {
		this.ID=ID;
		msg=m;
		this.talkctr=talkctr;
	}
	
	public abstract void talkTo() ;
		
	
}
