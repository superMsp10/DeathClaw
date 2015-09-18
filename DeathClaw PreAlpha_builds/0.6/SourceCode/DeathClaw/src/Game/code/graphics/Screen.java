package Game.code.graphics;

import java.util.Random;

public class Screen {
	private int width, height;
	public int[] pixels;
	public int[] tiles = new int[64 * 64];
	public final int mapSize=64;
	public final int mmapSize=mapSize-1;

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < mapSize * mapSize; i++) {

			tiles[i] = random.nextInt(0xffffff);
		}

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}

	}

	public void render(int xOffSet ,int yOffSet) {
		for (int y = 0; y < height; y++) {
			int yy = y;
			//if (yy < 0 || yy >= height)break;
			
			for (int x = 0; x < width; x++) {
				int xx = x - 16;
				//if (xx < 0 || xx >= width)break;
				
				int tileIndex = ((xx + xOffSet >> 4) & mmapSize) + ((yy+yOffSet >> 4) & mmapSize) * mapSize;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}

	}
}
