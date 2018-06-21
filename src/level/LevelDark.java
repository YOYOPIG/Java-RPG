package level;

import game.Game;
import gfx.Screen;
import level.tiles.Tile;

public class LevelDark extends Level{
	
	private int xtile=-1;
	private int ytile=-1;
	
	public LevelDark(int height, int width) {
		super(height, width);
	}

	@Override
	public void generateLevel() {
		for(int i=0;i<64*64;i++) {
			tiles[i]=Tile.Dark.getID();
		}
		xtile=Game.game.playerXTile;
		ytile=Game.game.playerYTile;
		//System.out.println("player x tile:"+Game.game.playerXTile+" play y tile:"+Game.game.playerYTile);
		if(xtile<=3)
		{
			xtile=3;
		}
		if(ytile<=3)
		{
			ytile=3;
		}
		if(xtile>=62)
		{
			xtile=62;
		}
		if(ytile>=62)
		{
			ytile=62;
		}
		for (int i = -3; i < 3; i++) {
			for(int j = -3; j < 3; j++) {
				tiles[(xtile+i)+(ytile+j)*width]=Tile.VOID.getID();
			}
		}
	
	}

	@Override
	public void renderingOpen(int position, int ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderingOpen(int position, int ID, int widthCount) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void renderTiles(Screen screen, double xOffset, double yOffset){
		if(xOffset<=0)	xOffset = 0;
		if(xOffset>((width<<3) - screen.width))	xOffset = ((width<<3) - screen.width);
		if(yOffset<=0)	yOffset = 0;
		if(yOffset>((height<<3) - screen.height))	yOffset = ((height<<3) - screen.height);
		
		screen.setOffset(xOffset, yOffset);
		
		for(int y=0; y<height; y++)
		{
			for(int x=0; x<width; x++)
			{
				getTile(x,y).render(screen, this, x<<3, y<<3);
			}
		}
		generateLevel();
	}

}
