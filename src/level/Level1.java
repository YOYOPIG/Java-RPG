package level;

import game.Game;
import level.tiles.Tile;

public class Level1 extends Level {
	
	
	public Level1(int height, int width) {
		super(height, width);
	}

	public void generateLevel() {
		for(int i=0;i<64*64;i++) {
			tiles[i]=Tile.VOID.getID();
		}
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
		tiles[600] = Tile.ChestPotion11.getID();
		tiles[601] = Tile.ChestPotion12.getID();
		tiles[600+width] =  Tile.ChestPotion21.getID();
		tiles[601+width] = Tile.ChestPotion22.getID();

		// rendering door
		tiles[8+28*width] =Tile.DoorBetweenR1AndHallway11.getID();
		tiles[9+28*width] =Tile.DoorBetweenR1AndHallway12.getID();
		tiles[8+29*width] =Tile.DoorBetweenR1AndHallway21.getID();
		tiles[9+29*width] =Tile.DoorBetweenR1AndHallway22.getID();
		
//		tiles[15+36*width] = Tile.DoorBetweenR2AndHallway11.getID();
//		tiles[16+36*width] = Tile.DoorBetweenR2AndHallway12.getID();
//		tiles[15+37*width] = Tile.DoorBetweenR2AndHallway21.getID();
//		tiles[16+37*width] = Tile.DoorBetweenR2AndHallway22.getID();

		
//		tiles[30+32*width] = Tile.DoorBetweenR3AndHallway11.getID();
//		tiles[31+32*width] = Tile.DoorBetweenR3AndHallway12.getID();
//		tiles[30+33*width] = Tile.DoorBetweenR3AndHallway21.getID();
//		tiles[31+33*width] = Tile.DoorBetweenR3AndHallway22.getID();
		



//		tiles[30+32*width] = Tile.DoorBetweenR3AndHallway11.getID();
//		tiles[31+32*width] = Tile.DoorBetweenR3AndHallway12.getID();
//		tiles[30+33*width] = Tile.DoorBetweenR3AndHallway21.getID();
//		tiles[31+33*width] = Tile.DoorBetweenR3AndHallway22.getID();

		// rendering DoorEcit on room 3
		tiles[53+10*width] = Tile.DoorExit11.getID();
		tiles[54+10*width] = Tile.DoorExit12.getID();
		tiles[53+11*width] = Tile.DoorExit21.getID();
		tiles[54+11*width] = Tile.DoorExit22.getID();
		
//		// rendering Paint beside DoorExit
//		tiles[40+12*width] = Tile.Paint11.getID();
//		tiles[41+12*width] = Tile.Paint12.getID();
//		tiles[40+13*width] = Tile.Paint21.getID();
//		tiles[41+13*width] = Tile.Paint22.getID();
//		
		
		// rendering the table 
		tiles[3+3*width] = Tile.Table11.getID();
		tiles[4+3*width] = Tile.Table12.getID();
		tiles[3+4*width] = Tile.Table21.getID();
		tiles[4+4*width] = Tile.Table22.getID();
		tiles[5+3*width] = Tile.Table31.getID();
		tiles[6+3*width] = Tile.Table32.getID();
		tiles[5+4*width] = Tile.Table41.getID();
		tiles[6+4*width] = Tile.Table42.getID();
		
		// rendering lattern 43 24
		tiles[43+24*width] = Tile.lattern11.getID();
		tiles[44+24*width] = Tile.lattern12.getID();
		tiles[43+25*width] =  Tile.lattern21.getID();
		tiles[44+25*width] = Tile.lattern22.getID();
		
		//rendering deadbody 
		tiles[20+40*width] = Tile.DeadBody11.getID();
		tiles[21+40*width] = Tile.DeadBody12.getID();
		tiles[20+41*width] = Tile.DeadBody21.getID();
		tiles[21+41*width] = Tile.DeadBody22.getID();
		tiles[22+40*width] = Tile.DeadBody31.getID();
		tiles[23+40*width] = Tile.DeadBody32.getID();
		tiles[22+41*width] = Tile.DeadBody41.getID();
		tiles[23+41*width] = Tile.DeadBody42.getID();
		
		
		// rendering candles
		// top side
		for(int i=32 ; i< 56 ; i+=2 ) {
			if(i==40) {
				// rendering Paint beside DoorExit
				tiles[40+12*width] = Tile.Paint11.getID();
				tiles[41+12*width] = Tile.Paint12.getID();
				tiles[40+13*width] = Tile.Paint21.getID();
				tiles[41+13*width] = Tile.Paint22.getID();
				continue;
			}
			else if(i==50 || i== 52) continue; // don't rendering candle to make a room for player to go to the exit
			tiles[i+12*width] = Tile.candle11.getID();
			tiles[i+1+12*width] = Tile.candle12.getID();
			tiles[i+13*width] = Tile.candle21.getID();
			tiles[i+1+13*width] = Tile.candle22.getID();
		}
		
		// right side
		for(int i=12 ; i < 36 ; i+=2 ) {
			tiles[54+i*width] = Tile.candle11.getID();
			tiles[55+i*width] = Tile.candle12.getID();
			tiles[54+(i+1)*width] = Tile.candle21.getID();
			tiles[55+(i+1)*width] = Tile.candle22.getID();
		}
		
		// down side
		for(int i=54 ; i> 32 ; i-=2 ) {
			tiles[i+34*width] = Tile.candle11.getID();
			tiles[i+1+34*width] = Tile.candle12.getID();
			tiles[i+35*width] = Tile.candle21.getID();
			tiles[i+1+35*width] = Tile.candle22.getID();
		}
		
		// left side
		for(int i=34 ; i > 12 ; i-=2 ) {
			if(i==32) continue;
			tiles[32+i*width] = Tile.candle11.getID();
			tiles[33+i*width] = Tile.candle12.getID();
			tiles[32+(i+1)*width] = Tile.candle21.getID();
			tiles[33+(i+1)*width] = Tile.candle22.getID();
		}
		
		
	}
	@ Override
	public void renderingOpen(int position,int ID) {
		if(ID==0 || ID==1) { // npc and chest
			tiles[position] = Tile.Ghost11.getID();
			tiles[position+1] = Tile.Ghost12.getID();
			tiles[position+width] = Tile.Ghost21.getID();
			tiles[position+1+width] = Tile.Ghost22.getID();
		}
		else if(ID == 5) { // door open
			tiles[position] = Tile.DoorOpen11.getID();
			tiles[position+1] = Tile.DoorOpen12.getID();
			tiles[position+width] = Tile.DoorOpen21.getID();
			tiles[position+1+width] = Tile.DoorOpen22.getID();
		}
		else if(ID==7) { // take up the lattern
			tiles[position] = Tile.FLOOR.getID();
			tiles[position+1] = Tile.FLOOR.getID();
			tiles[position+width] = Tile.FLOOR.getID();
			tiles[position+1+width] = Tile.FLOOR.getID();
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