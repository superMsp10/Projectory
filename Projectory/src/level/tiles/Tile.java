package level.tiles;


import game.graphics.Display;
import game.graphics.skins.Sprite;

public abstract class Tile {

	public Sprite sprite;
	public boolean solid;
	public double resistence;
	public boolean sliding = false;
	public int tileNum;
	//Tiles
	public static Tile NULLTILE = new NullTile(Sprite.NULLSPRITE, 400,-1);
	public static Tile FLOORMARBLE = new MarbleTile(Sprite.MARBLE, 30,true,5);
	public static Tile TaintedMARBLE = new MarbleTile(Sprite.TiantedMARBLE, 50,true,4);
	public static Tile wetMARBLE = new MarbleTile(Sprite.wetMARBLE,20,true,3);
	public static Tile boosterMarble = new boosterMarbleTile(Sprite.boosterMarkMARBLE, 90,2);
	public static Tile BARRACADE = new BARRACADE(Sprite.BARRACADE,70,1);

	public Tile(Sprite sprite, double d,int tileNum) {
		this.sprite = sprite;
		this.tileNum=tileNum;
		resistence = d;
	}

	public void render(int x, int y, Display screen) {

	}

	public void update() {

	}

	public boolean solid() {
		return solid;
	}

}
