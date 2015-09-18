package Game.code.entitiy.projectile;

import Game.code.entitiy.Spawner.ParticleSpawner;
import Game.code.graphics.Screen;
import Game.code.graphics.Sprite;

public class WizardProjectile extends Projectile {
	public static final int rof = 10;

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 360;
		dmg = 5;
		speed = 1;
		sprite = Sprite.fireBlaze;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);

	}

	public void update() {

		if (level.tileCollision(((int) (x + nx)), ((int) (y + ny)), 16, 8, 8)) {
			level.add(new ParticleSpawner((int) x, (int) y, 500, 300, level));
			remove();
		}
		move();

	}

	public int Dist() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return (int) dist;

	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 5, (int) y, sprite);

	}

	public void move() {

		x += nx;
		y += ny;

		if (Dist() > range) {
			removed = true;
		}
	}

}
