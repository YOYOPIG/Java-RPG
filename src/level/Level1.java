package level;

import level.tiles.Tile;

public class Level1 extends Level {

	public Level1(int height, int width) {
		super(height, width);
	}

	public void generateLevel() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tiles[2]=Tile.NPC11.getID();
				tiles[3]=Tile.NPC12.getID();
				tiles[2+width]=Tile.NPC21.getID();
				tiles[3+width]=Tile.NPC22.getID();
			}
		}
	}
}