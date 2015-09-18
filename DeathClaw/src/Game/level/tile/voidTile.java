package Game.level.tile;

import Game.code.graphics.Screen;
import Game.code.graphics.Sprite;

public class voidTile extends Tile {

	public voidTile(Sprite sprite) {
		super(sprite);
		
	}

	public void Render(int x, int y, Screen screen) {
		
		screen.renderTile(x<<4, y<<4, this);
	}
}
