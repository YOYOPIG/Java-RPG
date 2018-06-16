package level;

import level.tiles.Tile;

public class Level1 extends Level {

	public Level1(int height, int width) {
		super(height, width);
	}

	public void generateLevel() {
		// rendering walls
		for (int i = 0; i < 30; i++) {
			if(i == 8 || i == 9)	continue;
			tiles[i + 28 * width] = Tile.STONE.getID();
			tiles[i + 29 * width] = Tile.STONE.getID();
		}
		for (int i = 31; i < 55; i++) {
			tiles[i + 11 * width] = Tile.STONE.getID();
			tiles[i + 10 * width] = Tile.STONE.getID();
		}
		for (int i = 0; i < 55; i++) {
			if(i == 15 || i == 16)	continue;
			tiles[i + 36 * width] = Tile.STONE.getID();
			tiles[i + 37 * width] = Tile.STONE.getID();
		}
		for (int i = 0; i < height; i++) {
			if(i == 32 || i == 33)	continue;
			tiles[31 + i * width] = Tile.STONE.getID();
			tiles[30 + i * width] = Tile.STONE.getID();
		}
		for (int i = 10; i < 38; i++) {
			tiles[55 + i * width] = Tile.STONE.getID();
			tiles[56 + i * width] = Tile.STONE.getID();
		}
		

		tiles[7+7*width]=Tile.NPC11.getID();
		tiles[8+7*width]=Tile.NPC12.getID();
		tiles[7+8*width]=Tile.NPC21.getID();
		tiles[8+8*width]=Tile.NPC22.getID();
		
		// rendering ghost box
		tiles[400] = Tile.ChestGhost11.getID();
		tiles[401] = Tile.ChestGhost12.getID();
		tiles[400+width] = Tile.ChestGhost21.getID();
		tiles[401+width] = Tile.ChestGhost22.getID();
		// rendering key box
		tiles[600] = Tile.ChestKey11.getID();
		tiles[601] = Tile.ChestKey12.getID();
		tiles[600+width] = Tile.ChestKey21.getID();
		tiles[601+width] = Tile.ChestKey22.getID();

		// rendering potion box
		tiles[800] = Tile.ChestPotion11.getID();
		tiles[801] = Tile.ChestPotion12.getID();
		tiles[800+width] = Tile.ChestPotion21.getID();
		tiles[801+width] = Tile.ChestPotion22.getID();
		// rendering door
//		tiles[8+28*width] =Tile.DoorBetweenR1AndHallway11.getID();
//		tiles[9+28*width] =Tile.DoorBetweenR1AndHallway12.getID();
//		tiles[8+29*width] =Tile.DoorBetweenR1AndHallway21.getID();
//		tiles[9+29*width] =Tile.DoorBetweenR1AndHallway22.getID();
		
		tiles[15+36*width] = Tile.DoorBetweenR2AndHallway11.getID();
		tiles[16+36*width] = Tile.DoorBetweenR2AndHallway12.getID();
		tiles[15+37*width] = Tile.DoorBetweenR2AndHallway21.getID();
		tiles[16+37*width] = Tile.DoorBetweenR2AndHallway22.getID();
		
		tiles[30+32*width] = Tile.DoorBetweenR3AndHallway11.getID();
		tiles[31+32*width] = Tile.DoorBetweenR3AndHallway12.getID();
		tiles[30+33*width] = Tile.DoorBetweenR3AndHallway21.getID();
		tiles[31+33*width] = Tile.DoorBetweenR3AndHallway22.getID();
		
		tiles[53+12*width] = Tile.DoorExit11.getID();
		tiles[54+12*width] = Tile.DoorExit12.getID();
		tiles[53+13*width] = Tile.DoorExit21.getID();
		tiles[54+13*width] = Tile.DoorExit22.getID();
		
		tiles[8+28*width] = Tile.DoorOpen11.getID();
		tiles[9+28*width] = Tile.DoorOpen12.getID();
		tiles[8+29*width] = Tile.DoorOpen21.getID();
		tiles[9+29*width] = Tile.DoorOpen22.getID();
		
		// rendering the table 
		tiles[3+3*width] = Tile.Table11.getID();
		tiles[4+3*width] = Tile.Table12.getID();
		tiles[3+4*width] = Tile.Table21.getID();
		tiles[4+4*width] = Tile.Table22.getID();
		tiles[5+3*width] = Tile.Table31.getID();
		tiles[6+3*width] = Tile.Table32.getID();
		tiles[5+4*width] = Tile.Table41.getID();
		tiles[6+4*width] = Tile.Table42.getID();
		
		
	}
	@ Override
	public void renderingOpen(int position,int ID) {
		if(ID==0) {
			tiles[position] = Tile.Ghost11.getID();
			tiles[position+1] = Tile.Ghost12.getID();
			tiles[position+width] = Tile.Ghost21.getID();
			tiles[position+1+width] = Tile.Ghost22.getID();
		}
		else{
			tiles[position] = Tile.ChestOpen11.getID();
			tiles[position+1] = Tile.ChestOpen12.getID();
			tiles[position+width] = Tile.ChestOpen21.getID();
			tiles[position+1+width] = Tile.ChestOpen22.getID();
		}
	}
	
	@ Override
	public void renderingOpen(int position,int ID,int widthCount) {
		if(ID==2) {
			tiles[position+widthCount*width] = Tile.TableWithoutItem11.getID();
			tiles[position+1+widthCount*width] = Tile.TableWithoutItem12.getID();
			tiles[position+(widthCount+1)*width] = Tile.TableWithoutItem21.getID();
			tiles[position+1+(widthCount+1)*width] = Tile.TableWithoutItem22.getID();
			tiles[position+2+widthCount*width] = Tile.TableWithoutItem31.getID();
			tiles[position+3+widthCount*width] = Tile.TableWithoutItem32.getID();
			tiles[position+2+(widthCount+1)*width] = Tile.TableWithoutItem41.getID();
			tiles[position+3+(widthCount+1)*width] = Tile.TableWithoutItem42.getID();
		}
	}
	

}