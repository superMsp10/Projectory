package game.graphics.bars;

import game.graphics.Display;
import game.graphics.skins.Sprite;

public class Statbar {
	public Sprite sprite;
	public double stat;
	public int x,y;
	public boolean[] unit = new boolean[100];
	public Statbar(int x, int y, Sprite sprite) {
		this.sprite = sprite;
		this.y = y;
		this.x = x;
	}
	public void render(Display screen){
		
	}
	public void update(double stat, double maxStat){
		
	}
}
