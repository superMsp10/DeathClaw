package Game.code.graphics;

import java.util.Random;

import Game.level.tile.Tile;

public class Screen {
	public int width, height;

	public int[] pixels;
	public int[] tiles = new int[64 * 64];

	public final int mapSize = 64;
	public final int mmapSize = mapSize - 1;
	public int xOffSet, yOffSet;

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

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (fixed) {
			yp -= yOffSet;
			xp -= xOffSet;
		}
		for(int y =0 ; y <sprite.height();y++){
			int ya = y + yp;
			for(int x =0 ; x <sprite.width();x++){
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height)
					continue;
				pixels[xa + ya * width] = sprite.pixels[x+y*sprite.width()];
			}
		}
	}

	public void renderspriteSheet(int xp, int yp, Spritesheet sheet, boolean fixed) {
		if (fixed) {
			yp -= yOffSet;
			xp -= xOffSet;
		}
		for(int y =0 ; y <sheet.HEIGHT;y++){
			int ya = y + yp;
			for(int x =0 ; x <sheet.WIDTH;x++){
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height)
					continue;
				pixels[xa + ya * width] = sheet.pixels[x+y*sheet.WIDTH];
				


			}
		}
	}
	public void renderTile(int xp, int yp, Tile tile) {
		yp -= yOffSet;
		xp -= xOffSet;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;

			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;

				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				if (ya < 0)
					ya = 0;
				int col = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				if (col != 0xffEACED9) {
					pixels[xa + ya * width] = col;
					
				}
			}
		}

	}

	public void renderProjectile(int xp, int yp, Sprite sprite) {
		yp -= yOffSet;
		xp -= xOffSet;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;

			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;

				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				if (ya < 0)
					ya = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != 0xffEACED9) {
					pixels[xa + ya * width] = col;
				}
			}
		}

	}

	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
		yp -= yOffSet;
		xp -= xOffSet;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3) {
				ys = 31 - y;
			}

			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				int xs = x;

				if (flip == 1 || flip == 3) {
					xs = 31 - x;
				}

				if (xa < -32 || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;

				int col = sprite.pixels[xs + ys * 32];
				if (col != 0xffEACED9)
					pixels[xa + ya * width] = col;
			}
		}

	}

	public void setOffSet(int xOffSet, int yOffSet) {
		this.xOffSet = xOffSet;
		this.yOffSet = yOffSet;

	}

	
}
