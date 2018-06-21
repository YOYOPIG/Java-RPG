package level.tiles;

import gfx.Colours;
import gfx.Screen;
import level.Level;

public abstract class Tile {

	
	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicTile(0, 0, 0, Colours.get(-1, -1, -1, -1));
	public static final Tile STONE = new BasicSolidTile(1, 1, 0,Colours.get(-1, 333, -1, -1));
	public static final Tile GRASS = new BasicTile(2, 2, 0, Colours.get(-1,	131, 141, -1));
	public static final Tile FLOOR = new BasicTile(3, 3, 0, Colours.get(111,111,321,-1));
	public static final Tile NPC11 = new BasicSolidTile(4, 8, 28, Colours.get(-1, 111, 145, 543));
	public static final Tile NPC12 = new BasicSolidTile(5, 9, 28, Colours.get(-1, 111, 145, 543));
	public static final Tile NPC21 = new BasicSolidTile(6, 8, 29, Colours.get(-1, 111, 145, 543));
	public static final Tile NPC22 = new BasicSolidTile(7, 9, 29, Colours.get(-1, 111, 145, 543));
	// 2
	/*
	public static final Tile ChestPotion11 = new BasicSolidTile(8, 0, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion12 = new BasicSolidTile(9, 1, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion21 = new BasicSolidTile(10, 0, 25, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion22 = new BasicSolidTile(11, 1, 25, Colours.get(-1, 111, 440, 032));
	*/
	// 2
	public static final Tile ChestPotion11 = new BasicSolidTile(8, 0, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion12 = new BasicSolidTile(9, 1, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion21 = new BasicSolidTile(10, 0, 25, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestPotion22 = new BasicSolidTile(11, 1, 25, Colours.get(-1, 111, 440, 032));
	
	
	// 4
	public static final Tile DoorBetweenR1AndHallway11 = new BasicSolidTile(16, 4, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR1AndHallway12 = new BasicSolidTile(17, 5, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR1AndHallway21 = new BasicSolidTile(18, 4, 25, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR1AndHallway22 = new BasicSolidTile(19, 5, 25, Colours.get(-1, 111, 332, 321));
	
	
	public static final Tile ChestOpen11 = new BasicSolidTile(100, 2, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestOpen12 = new BasicSolidTile(101, 3, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestOpen21 = new BasicSolidTile(102, 2, 25, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestOpen22 = new BasicSolidTile(103, 3, 25, Colours.get(-1, 111, 440, 032));
	
	// 5
	public static final Tile Ghost11 = new BasicSolidTile(20, 0, 26, Colours.get(-1, 500, 555, 000));
	public static final Tile Ghost12 = new BasicSolidTile(21, 1, 26, Colours.get(-1, 500, 555, 000));
	public static final Tile Ghost21 = new BasicSolidTile(22, 0, 27, Colours.get(-1, 500, 555, 000));
	public static final Tile Ghost22 = new BasicSolidTile(23, 1, 27, Colours.get(-1, 500, 555, 000));
	
	// 6
	public static final Tile ChestGhost11 = new BasicSolidTile(24, 0, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestGhost12 = new BasicSolidTile(25, 1, 24, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestGhost21 = new BasicSolidTile(26, 0, 25, Colours.get(-1, 111, 440, 032));
	public static final Tile ChestGhost22 = new BasicSolidTile(27, 1, 25, Colours.get(-1, 111, 440, 032));
		
	// 7
	public static final Tile Table11 = new BasicSolidTile(28, 2, 26, Colours.get(-1, 214, 210, 321));
	public static final Tile Table12 = new BasicSolidTile(29, 3, 26, Colours.get(-1, 214, 210, 321));
	public static final Tile Table21 = new BasicSolidTile(30, 2, 27, Colours.get(-1, 214, 210, 321));
	public static final Tile Table22 = new BasicSolidTile(31, 3, 27, Colours.get(-1, 214, 210, 321));
	
	// 8 (dark gray,gray,white)
	public static final Tile Table31 = new BasicSolidTile(32, 4, 26, Colours.get(-1, 214, 210, 321));
	public static final Tile Table32 = new BasicSolidTile(33, 5, 26, Colours.get(-1, 214, 210, 321));
	public static final Tile Table41 = new BasicSolidTile(34, 4, 27, Colours.get(-1, 214, 210, 321));
	public static final Tile Table42 = new BasicSolidTile(35, 5, 27, Colours.get(-1, 214, 210, 312));
	
	// 9
	public static final Tile TableWithoutItem11 = new BasicSolidTile(36, 6, 26, Colours.get(-1, 214, 210, 321));
	public static final Tile TableWithoutItem12 = new BasicSolidTile(37, 7, 26, Colours.get(-1, 214, 210, 321));
	public static final Tile TableWithoutItem21 = new BasicSolidTile(38, 6, 27, Colours.get(-1, 214, 210, 321));
	public static final Tile TableWithoutItem22 = new BasicSolidTile(39, 7, 27, Colours.get(-1, 214, 210, 321));
	// 10
	public static final Tile TableWithoutItem31 = new BasicSolidTile(40, 8, 26, Colours.get(-1, 214, 210, 321));
	public static final Tile TableWithoutItem32 = new BasicSolidTile(41, 9, 26, Colours.get(-1, 214, 210, 321));
	public static final Tile TableWithoutItem41 = new BasicSolidTile(42, 8, 27, Colours.get(-1, 214, 210, 321));
	public static final Tile TableWithoutItem42 = new BasicSolidTile(43, 9, 27, Colours.get(-1, 214, 210, 321));
	
	//11
	public static final Tile DoorBetweenR2AndHallway11 = new BasicSolidTile(44, 4, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR2AndHallway12 = new BasicSolidTile(45, 5, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR2AndHallway21 = new BasicSolidTile(46, 4, 25, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR2AndHallway22 = new BasicSolidTile(47, 5, 25, Colours.get(-1, 111, 332, 321));
	
	//12
	public static final Tile DoorBetweenR3AndHallway11 = new BasicSolidTile(48, 4, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR3AndHallway12 = new BasicSolidTile(49, 5, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR3AndHallway21 = new BasicSolidTile(50, 4, 25, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorBetweenR3AndHallway22 = new BasicSolidTile(51, 5, 25, Colours.get(-1, 111, 332, 321));
	
	//13
	public static final Tile DoorExit11 = new BasicSolidTile(52, 4, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorExit12 = new BasicSolidTile(53, 5, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorExit21 = new BasicSolidTile(54, 4, 25, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorExit22 = new BasicSolidTile(55, 5, 25, Colours.get(-1, 111, 332, 321));
	
	//14
	public static final Tile DoorOpen11 = new BasicTile(56, 6, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorOpen12 = new BasicTile(57, 7, 24, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorOpen21 = new BasicTile(58, 6, 25, Colours.get(-1, 111, 332, 321));
	public static final Tile DoorOpen22 = new BasicTile(59, 7, 25, Colours.get(-1, 111, 332, 321));
	

	// 15 
	public static final Tile candle11 = new BasicSolidTile(60, 8, 24, Colours.get(-1, 111, 542, 555));
	public static final Tile candle12 = new BasicSolidTile(61, 9, 24, Colours.get(-1, 111, 542, 555));
	public static final Tile candle21 = new BasicSolidTile(62, 8, 25, Colours.get(-1, 111, 542, 555));
	public static final Tile candle22 = new BasicSolidTile(63, 9, 25, Colours.get(-1, 111, 542, 555));
	
	// 16 (dark gray,gray,white)
	public static final Tile specialCandle11 = new BasicSolidTile(64, 8, 24, Colours.get(-1, 555, 542, 555));
	public static final Tile specialCandle12 = new BasicSolidTile(65, 8, 24, Colours.get(-1, 555, 542, 555));
	public static final Tile specialCandle21 = new BasicSolidTile(66, 8, 24, Colours.get(-1, 555, 542, 555));
	public static final Tile specialCandle22 = new BasicSolidTile(67, 8, 24, Colours.get(-1, 555, 542, 555));
	
	// 17 (dark gray,gray,white)
	public static final Tile lattern11 = new BasicSolidTile(68, 10, 26, Colours.get(-1, 542, 430, 500));
	public static final Tile lattern12 = new BasicSolidTile(69, 11, 26, Colours.get(-1, 542, 430, 500));
	public static final Tile lattern21 = new BasicSolidTile(70, 10, 27, Colours.get(-1, 542, 430, 500));
	public static final Tile lattern22 = new BasicSolidTile(71, 11, 27, Colours.get(-1, 542, 430, 500));

	//18
	public static final Tile Paint11 = new BasicSolidTile(72, 10, 28, Colours.get(-1, 542, 430, 500));
	public static final Tile Paint12 = new BasicSolidTile(73, 11, 29, Colours.get(-1, 542, 430, 500));
	public static final Tile Paint21 = new BasicSolidTile(74, 10, 28, Colours.get(-1, 542, 430, 500));
	public static final Tile Paint22 = new BasicSolidTile(75, 11, 29, Colours.get(-1, 542, 430, 500));

	//19
	public static final Tile DeadBody11 = new BasicSolidTile(76, 12, 28, Colours.get(-1, 542, 500, 543));
	public static final Tile DeadBody12 = new BasicSolidTile(77, 13, 28, Colours.get(-1, 542, 500, 543));
	public static final Tile DeadBody21 = new BasicSolidTile(78, 12, 29, Colours.get(-1, 542, 500, 543));
	public static final Tile DeadBody22 = new BasicSolidTile(79, 13, 29, Colours.get(-1, 542, 500, 543));
	
	//20
	public static final Tile DeadBody31 = new BasicSolidTile(80, 14, 28, Colours.get(-1, 000, 500, 543));
	public static final Tile DeadBody32 = new BasicSolidTile(81, 15, 28, Colours.get(-1, 000, 500, 543));
	public static final Tile DeadBody41 = new BasicSolidTile(82, 14, 29, Colours.get(-1, 000, 500, 543));
	public static final Tile DeadBody42 = new BasicSolidTile(83, 15, 29, Colours.get(-1, 000, 500, 543));
	
	
	//Dark tile
	public static final Tile Dark = new BasicTile(99, 0, 2, Colours.get(000, 000, 000, 000));
	
	
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
