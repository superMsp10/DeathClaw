package Game.code.graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private int width, height;
	private Spritesheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, Spritesheet.tiles);
	public static Sprite flower = new Sprite(16, 3, 1, Spritesheet.tiles);
	public static Sprite rock = new Sprite(16, 4, 1, Spritesheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 200);
	//Projectiles

	public static Sprite fireBlaze = new Sprite(16, 0, 0, Spritesheet.MageProjectiles);

	//Spawn stuffs
	public static Sprite spawnGrass = new Sprite(16, 0, 0, Spritesheet.spawnTile);
	public static Sprite spawnWoodFloor = new Sprite(16, 2, 0, Spritesheet.spawnTile);
	public static Sprite spawnBush = new Sprite(16, 0, 1, Spritesheet.spawnTile);
	public static Sprite spawnWater = new Sprite(16, 1, 1, Spritesheet.spawnTile);
	public static Sprite spawnWall = new Sprite(16, 1, 0, Spritesheet.spawnTile);
	public static Sprite spawnBwall = new Sprite(16, 2, 1, Spritesheet.spawnTile);

	//player stuffs
	public static Sprite playerSide = new Sprite(32, 1, 0, Spritesheet.player);
	public static Sprite playerBack = new Sprite(32, 2, 0, Spritesheet.player);
	public static Sprite playerUp = new Sprite(32, 0, 0, Spritesheet.player);

	public static Sprite playerSide1 = new Sprite(32, 1, 1, Spritesheet.player);
	public static Sprite playerBack1 = new Sprite(32, 2, 1, Spritesheet.player);
	public static Sprite playerUp1 = new Sprite(32, 2, 1, Spritesheet.player);

	public static Sprite playerSide2 = new Sprite(32, 1, 2, Spritesheet.player);
	public static Sprite playerBack2 = new Sprite(32, 2, 2, Spritesheet.player);
	public static Sprite playerUp2 = new Sprite(32, 2, 2, Spritesheet.player);
	
	//particles
	public static Sprite particle1 = new Sprite(2,0xFC8200);
	
	public Sprite(int size, int colour) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	public Sprite(int width, int height, int colour) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColour(colour);

	}

	public Sprite(int size, int x, int y, Spritesheet sheet) {
		SIZE = size;
		this.sheet = sheet;
		this.width = size;
		this.height = size;
		this.x = x * size;
		this.y = y * size;

		pixels = new int[SIZE * SIZE];

		load();
	}

	private void setColour(int colour) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = colour;
		}

	}

	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}

		}

	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}
}