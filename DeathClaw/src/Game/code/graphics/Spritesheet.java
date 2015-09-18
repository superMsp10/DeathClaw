package Game.code.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Spritesheet {

	private String path;
	public final int SIZE;
	public final int WIDTH;
	public final int HEIGHT;
	public int[] pixels;

	public static Spritesheet tiles = new Spritesheet("/textures/spritesheet.png", 256);
	public static Spritesheet spawnTile = new Spritesheet("/textures/SpawnSheet.png", 48);
	public static Spritesheet MageProjectiles = new Spritesheet("/textures/projectiles/Mageprojectiles.png", 48);

	public static Spritesheet player = new Spritesheet("/textures/Mob/PlayerSprite.png", 96);
	public static Spritesheet player_down = new Spritesheet(player,0,0,1,3,32);

	public Spritesheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		this.WIDTH = size;
		this.HEIGHT = size;
		pixels = new int[SIZE * SIZE];
		load();

	}

	public Spritesheet(Spritesheet sheet, int x, int y, int width, int height, int spriteSize) {
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		
		int w = width * spriteSize;
		int h = height * spriteSize;
		WIDTH = w;
		HEIGHT = h;

		if (width == height) {
			this.SIZE = width;
		} else {
			this.SIZE = -1;
		}
				
		
		pixels = new int[w * h];
		for (int y0 = 0; y0 < h; y0++) {
			int yp = yy + y0;
			for (int x0 = 0; x0 < w; x0++) {
				int xp = xx + x0;
				pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.WIDTH];
				
			}
		}

	}

	public Spritesheet(String path, int width, int height) {
		this.path = path;
		this.SIZE = -1;
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int[width * height];
		load();

	}

	private void load() {

		try {
			BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
