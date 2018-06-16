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
		// rendering potion box
		tiles[400] = Tile.ChestPotion11.getID();
		tiles[401] = Tile.ChestPotion12.getID();
		tiles[400+width] = Tile.ChestPotion21.getID();
		tiles[401+width] = Tile.ChestPotion22.getID();
		// rendering key box
		tiles[600] = Tile.ChestKey11.getID();
		tiles[601] = Tile.ChestKey12.getID();
		tiles[600+width] = Tile.ChestKey21.getID();
		tiles[601+width] = Tile.ChestKey22.getID();
		// rendering door
		tiles[300] =Tile.door11.getID();
		tiles[301] =Tile.door12.getID();
		tiles[300+width] =Tile.door21.getID();
		tiles[301+width] =Tile.door22.getID();
		
		
	}
	
	public void renderingOpen(int position) {
		tiles[position] = Tile.ChestOpen11.getID();
		tiles[position+1] = Tile.ChestOpen12.getID();
		tiles[position+width] = Tile.ChestOpen21.getID();
		tiles[position+1+width] = Tile.ChestOpen22.getID();
	}
	

}