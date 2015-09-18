package level.levels;

import java.util.ArrayList;
import java.util.List;

import level.tiles.Tile;
import entity.Entity;
import game.Main;

public abstract class Level {
	public String path;
	public int[] pixels;
	public int width, height;
	protected List<Entity> entities = new ArrayList<Entity>();
	public long time = 0;
	public boolean hasTiles = false;

	public Level(String path) {
		this.path = path;
		loadlevel();
	}

	public Level(int Width, int Height, boolean tiled) {
		height = Height;
		width = Width;
		hasTiles = tiled;
		if (hasTiles) {
			pixels = new int[width * height];
		}
	}

	public void render(int xOffSet, int yOffSet) {
		Main.SCREEN.setOffSet(xOffSet, yOffSet);
		if (hasTiles) {
			int yy = yOffSet >> 3;
			int xx = xOffSet >> 3;
			int y0 = (yOffSet + Main.HEIGHT + 8) >> 3;
			int x0 = (xOffSet + Main.WIDTH + 8) >> 3;
			for (int y = yy; y < y0; y++) {
				for (int x = xx; x < x0; x++) {
					getTile(x, y).render(x, y, Main.SCREEN);
				}
			}
		}

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(Main.SCREEN);
		}
	}

	public void update() {
		time++;
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}

	public void add(Entity e) {
		e.init(this);
		entities.add(e);
	}

	public void remove() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}

	}

	private void loadlevel() {

	}


	public void generateLevel() {

	}

	public Tile getTile(int x, int y) {
		if (y >= height || y < 0 || x >= height || x < 0) return Tile.NULLTILE;
		if (pixels[x + y * width] == Tile.FLOORMARBLE.tileNum)
			return Tile.FLOORMARBLE;
		else if (pixels[x + y * width] == Tile.TaintedMARBLE.tileNum)
			return Tile.TaintedMARBLE;
		else if (pixels[x + y * width] == Tile.boosterMarble.tileNum)
			return Tile.boosterMarble;
		else if (pixels[x + y * width] == Tile.BARRACADE.tileNum)
			return Tile.BARRACADE;
		else if (pixels[x + y * width] == Tile.wetMARBLE.tileNum) return Tile.wetMARBLE;
		return Tile.NULLTILE;

	}
}
