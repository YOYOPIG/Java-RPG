package character;

import com.sun.jmx.snmp.SnmpMsg;

public class Sign extends NPC{

	public Sign(int ID, int p) {
		super(ID, p);
		msg.add("The candle in the sight shall be lit once more.");
	}

	@Override
	public void setDialog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNormalDialog() {
		msg.clear();
		msg.add("The candle in the sight shall be lit once more.");
	}

}
