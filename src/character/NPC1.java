package character;

import com.sun.jmx.snmp.SnmpMsg;

import audio.AudioPlayer;
import level.Level;
import sun.applet.resources.MsgAppletViewer;

public class NPC1 extends NPCWithItem{
	
	public NPC1(Level gameLevel,int itemID,int p)
	{
		super(gameLevel,itemID,p);
		sound = new AudioPlayer("res/Audios/open_box.wav");
		msg.add("Hello, PLAYER");
		msg.add("I am thirsty.");
		msg.add("Could you please find me something to drink?");
		
	}
	
	public void missionCompleted() {
		setDialog();
		talkTo(7);
	}
	
	@ Override
	public void setDialog() {
		msg.clear();
		msg.add("I felt much better now, thx.");
		msg.add("I have been stayed here for a long period time.");
		msg.add("This key is all I have found so far.Here, take it.");
		msg.add("Item acquired!");
		msg.add("Hope you can find the way out for us.Now leave.");
	}

	@Override
	public void setNormalDialog() {
		msg.clear();
		msg.add("Hello, PLAYER");
		if(!isProcessed) {
			msg.add("I am thirsty.");
			msg.add("Could you please find me something to drink?");
		}
	}
	
	
}
