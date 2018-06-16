package level;

import level.tiles.Tile;

public class StartLevel extends Level{

	public StartLevel(int height, int width) {
		super(height, width);
	}

	public void generateLevel() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
						tiles[j + i * width] = Tile.STONE.getID();
			}
		}
	}

	public void renderingOpen(int position, int ID) {
		
	}

	public void renderingOpen(int position, int ID, int widthCount) {
		
	}

}
