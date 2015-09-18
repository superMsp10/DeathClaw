package Game.level.tile;

import Game.code.graphics.Screen;
import Game.code.graphics.Sprite;

public class rockTile extends Tile {

	public rockTile(Sprite sprite) {
		super(sprite);
	}
	
	public void Render(int x, int y, Screen screen) {
		screen.renderTile(x<<4 , y<<4, this);
	}
public boolean solid(){
		
		return true;
	}

}
