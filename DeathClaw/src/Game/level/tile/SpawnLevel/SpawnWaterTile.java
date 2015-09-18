package Game.level.tile.SpawnLevel;

import Game.code.graphics.Screen;
import Game.code.graphics.Sprite;
import Game.level.tile.Tile;

public class SpawnWaterTile extends Tile {
	public SpawnWaterTile(Sprite sprite) {
		super(sprite);
		
	}

	public void Render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
