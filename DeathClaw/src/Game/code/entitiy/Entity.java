package Game.code.entitiy;

import java.util.Random;

import Game.code.graphics.Screen;
import Game.level.Level;

public abstract class Entity {

	public int x, y;
	protected boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update() {

	}

	public void render(Screen screen) {
		

	}
	
	public void init(Level level){
		this.level=level;
		
	}

	public void remove() {
		removed = true;

	}

	public boolean isRemoved() {
		return removed;
	}
}
