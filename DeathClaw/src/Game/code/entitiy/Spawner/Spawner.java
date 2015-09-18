package Game.code.entitiy.Spawner;

import Game.code.entitiy.Entity;
import Game.level.Level;

public class Spawner extends Entity {

	
	public Spawner(int x, int y, int amount, Level level) {
		init(level);
		
		this.x = x;
		this.y = y;


	}
}
