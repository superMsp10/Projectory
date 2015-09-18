package entity.menu.buttons;

import entity.menu.Menu;
import game.Main;
import game.graphics.Display;
import game.graphics.anim.Animation;
import game.inputs.Mouse;
import level.levels.RandomLvl;
import level.tiles.Tile;
import level.tiles.TilePatch;

public class Startbutton extends Button {
	protected static Animation mouseAnim = new Animation(Main.MainMenus, 60, 10, 5, 0, 4, 1);
	int xx = 4;

	public Startbutton(int x, int y, boolean fixed, Mouse mouse, Menu menu, String name) {
		super(mouseAnim, x, y, fixed, mouse, menu, name);
	}

	public void onClick() {
		RandomLvl levl = new RandomLvl(1000, 1000);
		Main.setLevel(levl);
		levl.add(Main.player1);
		TilePatch wetPatch = new TilePatch(Tile.wetMARBLE, 10, 1, levl);
		wetPatch.generate(50, 50);
		Main.player1.setX(50 * 8);
		Main.player1.setY(50 * 8);
		parentMenu.remove();

	}

	public void onHover() {
		if (level.time % 15 == 0) {
			if (xx == 1) {
				sprite = anim.getSprite(2, 0);
				xx = 4;
			} else if (xx == 2) {
				sprite = anim.getSprite(1, 0);
			} else if (xx == 3) {
				sprite = anim.getSprite(3, 0);
			}
			xx--;
		}
	}

	public void render(Display screen) {
		screen.renderSprite(sprite, (int) x, (int) y, fixed);
	}

}
