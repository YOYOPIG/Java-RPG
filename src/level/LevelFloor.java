package level;

import level.tiles.Tile;

public class LevelFloor extends Level {

	public LevelFloor(int height, int width) {
		super(height, width);
	}

	public void generateLevel() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
						tiles[j + i * width] = Tile.FLOOR.getID();
			}
		}
	}

	@Override
	public void renderingOpen(int position,int ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderingOpen(int position, int ID, int widthCount) {
		// TODO Auto-generated method stub
		
	}

	
}
