package Game.level;

public class TileCor {

	private int  x, y;
	private final int Tile_Size = 16;
	
	public TileCor(int x, int y){
		this.x = x * Tile_Size;
		this.y = y * Tile_Size;
	}
	
	public int x(){
		return x;
	}
	
	public int y(){
		return y;
	}
	
	public int []xy(){
		int[] r = new int[2];
		r [0] = x;
		r [1] = y;
		return r;
		
	}
}
