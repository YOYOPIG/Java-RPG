package level;

import level.tiles.Tile;

public class Level1 extends Level {

	public Level1(int height, int width) {
		super(height, width);
	}

	public void generateLevel() {
		tiles[2]=Tile.NPC11.getID();
		tiles[3]=Tile.NPC12.getID();
		tiles[2+width]=Tile.NPC21.getID();
		tiles[3+width]=Tile.NPC22.getID();
		
		tiles[400] = Tile.Chest11.getID();
		tiles[401] = Tile.Chest12.getID();
		tiles[400+width] = Tile.Chest21.getID();
		tiles[401+width] = Tile.Chest22.getID();
		
	}
	
	public void renderingOpen(int position) {
		tiles[position] = Tile.ChestOpen11.getID();
		tiles[position+1] = Tile.ChestOpen12.getID();
		tiles[position+width] = Tile.ChestOpen21.getID();
		tiles[position+1+width] = Tile.ChestOpen22.getID();
	}

}