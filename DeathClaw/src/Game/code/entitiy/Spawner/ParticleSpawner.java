package Game.code.entitiy.Spawner;

import Game.code.entitiy.particles.Particles;
import Game.level.Level;

public class ParticleSpawner extends Spawner {
	

	public ParticleSpawner(int x, int y, int amount, int life, Level level) {
		super(x, y, amount, level);
	
		for (int i = 0; i < amount; i++) {
			level.add(new Particles(x, y, life));

		}
	}

}
