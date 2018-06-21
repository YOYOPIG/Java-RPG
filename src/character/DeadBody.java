package character;

import game.Game;
import level.Level;

public class DeadBody extends NPCWithItem{

	private boolean isKilled;
	
	public DeadBody(Level level, int ID, int p) {
		super(level, ID, p);
		setNormalDialog();
		isKilled = false;
	}
	
	public void missionCompleted() {
		setDialog();
		isKilled = true;
		talkTo(7);
	}

	@Override
	public void setDialog() {
		msg.clear();
		msg.add("What...is th... this...?");
		msg.add("I...");
		msg.add("I'm dying...");
	}

	@Override
	public void setNormalDialog() {
		msg.clear();
		if(!isProcessed&&!isKilled) {
			msg.add("H....He....lp....");
			msg.add("Could you... give me a hand?");
			msg.add("Yes... Come closer...");
			msg.add("JUMPSCARE");
		}
		else
		{	
			if(!Game.ui.getMasterKeyVisibility())
			{
				msg.add("A dead body. It seems like there's something in his pocket");
				msg.add("Item Aquired! You get the master key!");
			}
			msg.add("A dead body. Seems to be murdered brutally. Who did this?");
		}
	}

}
