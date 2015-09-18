package Game.code.entitiy.Mob;

import Game.code.Display;
import Game.code.entitiy.projectile.Projectile;
import Game.code.entitiy.projectile.WizardProjectile;
import Game.code.graphics.Screen;
import Game.code.graphics.Sprite;
import Game.code.inputs.Keyboard;
import Game.code.inputs.Mouse;

public class Player extends Mob {
	private Keyboard input;
	private Sprite sprite;
	private int anime = 0;
	private int rof = 0;

	public Player(Keyboard input, int x, int y) {
		this.input = input;
		this.x = x;
		this.y = y;

	}

	public Player(Keyboard input) {
		this.input = input;

	}

	public void clear() {
		for (int i = 0; i < level.getProjectile().size(); i++) {
			Projectile p = level.getProjectile().get(i);
			if (p.isRemoved()) {
				level.getProjectile().remove(i);
			}

		}

	}

	public void update() {
		System.out.println(Mouse.mouseB);
		if (rof > 0)
			rof--;

		if (anime < 7500)
			anime++;
		else
			anime = 0;
		int xa = 0;
		int ya = 0;

		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;

		if (ya != 0 || xa != 0) {
			move(xa, ya);
			moving = true;
		} else {
			moving = false;
		}

		updateShooting();
		clear();
	}

	public void updateShooting() {
		
		if (Mouse.mouseB == 1 && rof <= 0) {
			double dx = Mouse.mouseX() - Display.getWindowWidth() / 2;
			double dy = Mouse.mouseY() - Display.getWindowHeight() / 2;

			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			rof = WizardProjectile.rof;

		}

	}

	public void render(Screen screen) {
		int flip = 0;

		if (dir == 1) {
			flip = 1;
			sprite = Sprite.playerSide;

			if (moving) {
				if (anime % 20 > 10)
					sprite = Sprite.playerSide1;
				else {
					sprite = Sprite.playerSide2;
				}
			}
		}

		if (dir == 0) {
			sprite = Sprite.playerUp;

			if (moving) {
				if (anime % 20 > 10)
					sprite = Sprite.playerUp1;
				else {
					sprite = Sprite.playerUp2;
				}
			}
		}

		if (dir == 3) {
			sprite = Sprite.playerSide;
			

			if (moving) {
				if (anime % 20 > 10)
					sprite = Sprite.playerSide1;
				else {
					sprite = Sprite.playerSide2;
				}
			}
		}

		if (dir == 2) {
			sprite = Sprite.playerBack;
			if (moving) {
				if (anime % 20 > 10)
					sprite = Sprite.playerBack1;
				else {
					sprite = Sprite.playerBack2;
				}
			}
		}

		screen.renderPlayer(x - 16, y - 16, sprite, flip);

	}

}
