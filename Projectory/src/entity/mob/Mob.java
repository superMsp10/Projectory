package entity.mob;

import level.tiles.Tile;
import entity.Entity;
import game.graphics.Display;
import game.graphics.skins.Sprite;

public abstract class Mob extends Entity {
	protected boolean move = false;
	public Sprite sprite;
	protected int dir;
	protected boolean moving = false;
	protected double speed, momenteumX, momenteumY;
	protected int weight;
	protected int xa = 0;
	protected int ya = 0;
	protected int slideX, slideY;
	protected int momenteumTime = 0;
	protected double resistance = 0;
	protected boolean left = false;
	protected boolean up = false;
	protected boolean right = false;
	protected boolean down = false;
	protected int accel = 0;
	protected int sleepTime = 0;
	protected int stamina;
	protected int maxStamina;
	protected int staminaReg;
	protected int staminaTime;
	protected int HP = 0;
	protected int MaxHP = 0;
	protected int healthTime;
	protected int regHP;
	protected Tile tileOn;

	public void render(Display screen) {

	}

	protected void updateStamina() {
		if (stamina + staminaReg < maxStamina && level.time - staminaTime > (weight + (momenteumX + momenteumY))) {
			if (!moving) {
				stamina += staminaReg;
			} else if (moving) {
				stamina -= tileOn.resistence + weight + accel;
			}
			staminaTime = (int) level.time;
		}

	}

	protected void updateHealth() {
		if (level.time - healthTime > (60 + weight)) {
			if (stamina <= 0) {
				HP -= accel + Math.abs(stamina);
			} else if (HP + regHP < MaxHP) {
				HP += regHP;
			}
			healthTime = (int) level.time;
		}

	}

	protected void slide(int volX, int volY) {
		move(volX, volY);
	}

	protected void movement() {
		speed = 0.5;
		if (left) momenteumX -= speed;

		if (right) momenteumX += speed;

		int xx = (int) momenteumX;
		int yy = (int) momenteumY;
		move(xx, yy);

		move((int) momenteumX, (int) momenteumY);
		updateStamina();

	}

	protected void move(int xa, int ya) {

		if (xa > 0) dir = 3;
		if (ya > 0) dir = 2;
		if (xa < 0) dir = 1;
		if (ya < 0) dir = 0;

		int xx = (int) (xa + x);
		int yy = (int) (ya + y);

		if (move && !collision(xx, yy)) {
			y += ya;
			x += xa;
		}
	}

	public boolean collision(double x, double y) {
		boolean solid = false;

		int xx = (int) x;
		int yy = (int) y;
		if (level.getTile(xx >> 3, yy >> 3).solid() == true) solid = true;

		return solid;
	}
}
