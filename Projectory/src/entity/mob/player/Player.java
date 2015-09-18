package entity.mob.player;

import level.tiles.Tile;
import entity.mob.Mob;
import game.Main;
import game.graphics.Display;
import game.graphics.anim.Animation;
import game.graphics.bars.HealthBar;
import game.graphics.skins.Sprite;
import game.inputs.Keyboard;

public class Player extends Mob {
	private Keyboard input;
	public int col;
	HealthBar stmina = new HealthBar(15, 160, Sprite.Stamina);
	HealthBar Health = new HealthBar(15, 157, Sprite.Health);
	public static Animation playerDir = new Animation(Main.PLAYER, 16, 0, 0, 4, 1);

	public Player(Keyboard input, int x, int y, int accel, int col) {
		this.col = col;
		this.input = input;
		this.x = x;
		this.y = y;
		weight = 4;
		width = 10;
		height = 10;
		sprite = playerDir.getSprite(0, 0);
		this.accel = accel;
		maxStamina = 5000;
		stamina = 2500;
		staminaReg = 5;
		HP = 300;
		MaxHP = 500;
		regHP = 5;
		tileOn = Tile.NULLTILE;
	}

	public void render(Display screen) {
		screen.renderPlayer((int) x - 8, (int) y - 8, this, 0);
		stmina.render(screen);
		Health.render(screen);
	}

	public void update() {
		if (stamina <= 0)
			move = false;
		else {
			move = true;
			if (input.up) {
				up=true;
			}
			if (input.down) {
				down=true;
			}
			if (input.left) {
				left=true;
			}
			if (input.right) {
				right=true;
			}
			if (!up && !down && !left && !right) {
				moving = false;
			} else {
				sprite = playerDir.getSprite(dir, 0);

				movement();
				up=false;
				down=false;
				right=false;
				left=false;
			}
		}
		updateHealth();
		stmina.update(stamina, maxStamina);
		Health.update(HP, MaxHP);

	}

}