package Game.code.entitiy.projectile;

import Game.code.entitiy.Entity;
import Game.code.graphics.Sprite;

public abstract class Projectile extends Entity {
	protected final int xOrigin, yOrigin;
	protected final double angle;
	protected double x,y,distance;	
	protected Sprite sprite;
	protected double nx, ny;
	protected double speed,range, dmg;

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	protected void move() {

	}
	
	
}
