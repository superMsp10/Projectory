package level.tiles;

import game.graphics.Display;
import game.graphics.skins.Sprite;

public class boosterMarbleTile extends Tile {

	public boosterMarbleTile(Sprite sprite, double d, int tileNum) {
		super(sprite, d, tileNum);

	}

	public void render(int x, int y, Display screen) {
		screen.renderTile(this, x << 3, y << 3);
	}

}
