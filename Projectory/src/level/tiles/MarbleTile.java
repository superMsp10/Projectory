package level.tiles; 

import game.graphics.Display;
import game.graphics.skins.Sprite;

public class MarbleTile extends Tile {

	public MarbleTile(Sprite sprite,double d,boolean sliding,int tileNum) {
		super(sprite,d,tileNum);
		this.sliding = sliding;
		 
	}
	
	public void render(int x, int y,Display screen){
		screen.renderTile(this, x<<3, y<<3);
	}

}
