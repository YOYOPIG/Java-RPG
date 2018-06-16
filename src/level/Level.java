package level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import game.entities.Entity;
import gfx.Screen;
import level.tiles.Tile;

public abstract class Level {
	
	public static int height;
	public static int width;
	protected byte[] tiles;
	public List<Entity> entities = new ArrayList<Entity>();
	private String imagePath;
	private BufferedImage image;
	
	public Level(int height, int width)
	{
			tiles = new byte[height * width];
			this.height = 64;//height;
			this.width = 64;//width;
			this.generateLevel();
	}
	
	public Level(String imagePath) {
		if(imagePath != null) {
			this.imagePath = imagePath;
			this.loadLevelFromFile();
		}
	}
	
	private void loadLevelFromFile() {
		try {
			this.image = ImageIO.read(Level.class.getResource(this.imagePath));
			this.width = image.getWidth();
			this.height = image.getHeight();
			tiles = new byte[width * height];
			this.loadTiles();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadTiles() {
		int[] tileColours = this.image.getRGB(0, 0, width, height, null, 0, width);
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tileCheck: for(Tile t: Tile.tiles) {
					if(t != null && t.getLevelColour() == tileColours[x + y * width]) {
						this.tiles[x + y * width] = t.getID();
						break tileCheck;
					}
				}
			}
		}
	}
	//store image
	private void saveLevelToTiles() {
		try {
			ImageIO.write(image, "png", new File(Level.class.getResource(this.imagePath).getFile()));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//update tile
	public void alterTile(int x, int y, Tile newTile) {
		this.tiles[x + y * width] = newTile.getID();
		image.setRGB(x, y, newTile.getLevelColour());
	}
	
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
		
	}


	public abstract void generateLevel();

	public Tile getTile(int x, int y)
	{
		if(x<0||x>=width||y<0||y>=height)	return Tile.VOID;		
		return Tile.tiles[tiles[x+y*width]];
	}

	public void tick() {
		for(Entity e: entities) {
			e.tick();
		}
	}
	
	public void renderEntities(Screen screen) {
		for(Entity e: entities) {
			e.render(screen);
		}
	}
	
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
	
	public byte[] getByteTiles() {
		return tiles;
	}
	
	public abstract void renderingOpen(int position,int ID);
}
