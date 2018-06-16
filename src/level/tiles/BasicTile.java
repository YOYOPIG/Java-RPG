package level.tiles;

import gfx.Screen;
import level.Level;

public class BasicTile extends Tile{

	protected int tileID;
	protected int tileColour;
	
	public BasicTile(int id, int x, int y, int tileColour) {
		super(id, false, false);
		this.tileID = x + y*32;
		this.tileColour = tileColour;
		this.solid = false;
	}
	
	public BasicTile(int id, int x, int y, int tileColour, int levelColour) {
		super(id, false, false, levelColour);
		this.tileID = x + y*32;
		this.tileColour = tileColour;
	}


	public void render(Screen screen, Level level, int x, int y) {
		screen.render(x, y, tileID, tileColour, 0x00, 1);
	}

}
