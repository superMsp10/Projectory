package level.tiles;

import game.graphics.Display;
import game.graphics.skins.Sprite;

public class BARRACADE extends Tile {

	public BARRACADE(Sprite sprite, double d,int tileNum) {
		super(sprite,d,tileNum);
		solid = true;
	}
	public void render(int x, int y, Display screen) {
		screen.renderTile(this, x << 3, y << 3);
	}

}
