package game.graphics.bars;

import game.graphics.Display;
import game.graphics.skins.Sprite;

public class HealthBar extends Statbar {

	public HealthBar(int x, int y, Sprite sprite) {
		super(x, y, sprite);

	}

	public void render(Display screen) {
		for (int pix = 0; pix < unit.length; pix++) {
			if (unit[pix])screen.renderSprite(sprite, (x + pix) * sprite.Width, y * sprite.Height, false);

		}
	}

	public void update(double stat, double maxStat) {
		this.stat = (stat / maxStat) * 100;
		for (int pix = 0; pix < unit.length; pix++) {
			if (pix <= this.stat)
				unit[pix] = true;
			else
				unit[pix] = false;
		}

	}
}