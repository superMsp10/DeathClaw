package Game.level.tile.SpawnLevel;

import Game.code.graphics.Screen;
import Game.code.graphics.Sprite;
import Game.level.tile.Tile;

public class spawnBushTile extends Tile {

	public spawnBushTile(Sprite sprite) {
		super(sprite);
		
		
	}

	public void Render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid(){
		return true;
		
}

}