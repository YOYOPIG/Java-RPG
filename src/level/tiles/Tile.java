package level.tiles;

import gfx.Colours;
import gfx.Screen;
import level.Level;

public abstract class Tile {

	
	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colours.get(-1, -1, -1, -1), 0xFF000000);
	public static final Tile STONE = new BasicSolidTile(1, 1, 0,Colours.get(-1, 333, -1, -1), 0xFF555555);
	public static final Tile GRASS = new BasicTile(2, 2, 0, Colours.get(-1,	131, 141, -1), 0xFF00FF00);
	public static final Tile FLOOR = new BasicTile(3, 3, 0, Colours.get(100,26,310,210));
	public static final Tile NPC11 = new BasicSolidTile(4, 8, 28, Colours.get(-1, 111, 145, 543));
	public static final Tile NPC12 = new BasicSolidTile(5, 9, 28, Colours.get(-1, 111, 145, 543));
	public static final Tile NPC21 = new BasicSolidTile(6, 8, 29, Colours.get(-1, 111, 145, 543));
	public static final Tile NPC22 = new BasicSolidTile(7, 9, 29, Colours.get(-1, 111, 145, 543));
	public static final Tile ChestPotion11 = new BasicSolidTile(8, 0, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion12 = new BasicSolidTile(9, 1, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion21 = new BasicSolidTile(10, 0, 25, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion22 = new BasicSolidTile(11, 1, 25, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestKey11 = new BasicSolidTile(12, 0, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestKey12 = new BasicSolidTile(13, 1, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestKey21 = new BasicSolidTile(14, 0, 25, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestKey22 = new BasicSolidTile(15, 1, 25, Colours.get(-1, 111, 440, 032));
	
	public static final Tile door11 = new BasicSolidTile(16, 6, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile door12 = new BasicSolidTile(17, 7, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile door21 = new BasicSolidTile(18, 6, 25, Colours.get(-1, 111, 332, 321));
	public static final Tile door22 = new BasicSolidTile(19, 7, 25, Colours.get(-1, 111, 332, 321));
	
	
	public static final Tile ChestOpen11 = new BasicSolidTile(100, 2, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestOpen12 = new BasicSolidTile(101, 3, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestOpen21 = new BasicSolidTile(102, 2, 25, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestOpen22 = new BasicSolidTile(103, 3, 25, Colours.get(-1, 111, 440, 032));
	
	protected byte id;
	protected boolean solid;
	protected boolean emitter;
	private int levelColour;
	
	public Tile(int id, boolean isSolid, boolean isEmitter) {
		this.id = (byte)id;
		if(tiles[id] != null)	throw new RuntimeException("Duplicate tile id on" + id);
		this.solid = isSolid;
		this.emitter = isEmitter;
		tiles[id] = this;
	}
	
	public Tile(int id, boolean isSolid, boolean isEmitter, int levelColour) {
		this.id = (byte)id;
		if(tiles[id] != null)	throw new RuntimeException("Duplicate tile id on" + id);
		this.solid = isSolid;
		this.emitter = isEmitter;
		this.levelColour = levelColour;
		tiles[id] = this;
	}
	
	public byte getID() {
		return id;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public boolean isEmitter() {
		return emitter;
	}
	
	public int getLevelColour() {
		return levelColour;
	}

	public abstract void render(Screen screen, Level level, int x, int y);
}
