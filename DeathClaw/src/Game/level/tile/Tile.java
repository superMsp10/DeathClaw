package Game.level.tile;

import Game.code.graphics.Screen;
import Game.code.graphics.Sprite;
import Game.level.tile.SpawnLevel.SpawnGrassTile;
import Game.level.tile.SpawnLevel.SpawnWallTile;
import Game.level.tile.SpawnLevel.SpawnWaterTile;
import Game.level.tile.SpawnLevel.SpawnWfloorTile;
import Game.level.tile.SpawnLevel.spawnBushTile;


public class Tile {

	public int x, y;
	public Sprite sprite;
	

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new flowerTile(Sprite.flower);
	public static Tile rock = new rockTile(Sprite.rock);
	//spawn stuff
	public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawnGrass);
	public static Tile spawnBush = new spawnBushTile(Sprite.spawnBush);
	public static Tile spawnWater = new SpawnWaterTile(Sprite.spawnWater);
	public static Tile spawnWoodFloor = new SpawnWfloorTile(Sprite.spawnWoodFloor);
	public static Tile spawnBwall = new SpawnWallTile(Sprite.spawnBwall);
	public static Tile spawnwall = new SpawnWallTile(Sprite.spawnWall);
	
	public static final int col_grass = 0xFF00FF00;
	public static final int col_wall = 0xFFB4B4B4;
	public static final int col_bwall = 0xFF555555;
	public static final int col_water = 0xFF0000FF;
	public static final int col_bush = 0xFF006414;
	public static final int col_floor = 0xFFA03C00;


	
	
	public static Tile tileVoid = new voidTile(Sprite.voidSprite);

	
	public Tile(Sprite sprite){
		this.sprite = sprite;
		
	}
	
	public void Render(int x,int y,Screen screen){
		
		
	}
	
	public boolean solid(){
		
		return false;
	}
}
