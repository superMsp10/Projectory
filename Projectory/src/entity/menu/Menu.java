package entity.menu;

import level.levels.Level;
import entity.Entity;

public class Menu extends Entity {
	protected boolean fixed;

	public Menu(int x, int y, boolean fixed,Level level) {
		this.fixed = fixed;
		this.level = level;
		this.x = x;
		this.y = y;
	}
}
