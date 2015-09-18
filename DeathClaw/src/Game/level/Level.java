package Game.level;

import java.util.ArrayList;
import java.util.List;

import Game.code.entitiy.Entity;
import Game.code.entitiy.particles.Particles;
import Game.code.entitiy.projectile.Projectile;
import Game.code.graphics.Screen;
import Game.level.tile.Tile;

public class Level {
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particles> particles = new ArrayList<Particles>();

	public static Level spawn = new SpawnLevel("/levels/spawn.png");
	public static Level level1 = new SpawnLevel("/levels/level1.png");
	
	public Level(int width, int height) {
		this.height = height;
		this.width = width;
		tilesInt = new int[width * height];

		generateLevel();

	}

	public Level(String path) {

		loadLevel(path);
		generateLevel();

	}

	public void add(Entity e) {
		e.init(this);
		if (e instanceof Particles)

			particles.add((Particles) e);
		else if (e instanceof Projectile) {

			projectiles.add((Projectile) e);
		} else
			entities.add(e);

	}

	public List<Projectile> getProjectile() {
		return projectiles;

	}

	protected void loadLevel(String path) {

	}

	protected void generateLevel() {

	}

	
	private void remove() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved())
				entities.remove(i);

		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved())
				projectiles.remove(i);
		}

		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved())
				particles.remove(i);
		}
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();

		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}

		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		remove();
	}

	public boolean tileCollision(int x, int y, int size, int xOffSet, int yOffSet) {
		boolean solid = false;

		for (int c = 0; c < 4; c++) {

			int xt = (x - c % 2 * size + xOffSet) >> 4;
			int yt = (y - c / 2 * size + yOffSet) >> 4;
			if (getTile(xt, yt).solid()) {
				solid = true;
			}
		}

		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {

		screen.setOffSet(xScroll, yScroll);

		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;

		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).Render(x, y, screen);

			}

		}

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}

		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
	}

	public Tile getTile(int x, int y) {

		if (y < 0 || x < 0 || y >= height || x >= width) {
			return Tile.tileVoid;
		}

		if (tiles[x + y * width] == Tile.col_floor) {
			return Tile.spawnWoodFloor;
		}

		if (tiles[x + y * width] == Tile.col_bush) {
			return Tile.spawnBush;
		}

		if (tiles[x + y * width] == Tile.col_wall) {
			return Tile.spawnwall;
		}

		if (tiles[x + y * width] == Tile.col_water) {
			return Tile.spawnWater;
		}

		if (tiles[x + y * width] == Tile.col_bwall) {
			return Tile.spawnBwall;

		}
		if (tiles[x + y * width] == Tile.col_grass) {
			return Tile.spawnGrass;
		}

		return Tile.tileVoid;
	}

}
