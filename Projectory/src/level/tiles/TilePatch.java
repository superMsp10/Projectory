package level.tiles;

import java.util.Random;

import level.levels.Level;

public class TilePatch {
	public Tile[] tiles;
	Random random = new Random();
	int randoMax, rootX, rootY;
	Level level;
	Tile tile;

	public TilePatch(Tile tile, int tileNum, int randoMax, Level level) {
		tiles = new Tile[tileNum];
		this.level = level;
		this.tile = tile;
		this.randoMax = randoMax;

	}

	public void generate(int rootX, int rootY) {
		for (int i = 0; i < tiles.length; i++) {
			int OffsetX = (random.nextInt(i + randoMax));
			int OffsetY = (random.nextInt(i + randoMax));
			int absX = (rootX + OffsetX - 2);
			int absY = (rootY + OffsetY - 2);
			if (absX >= level.width || absY >= level.height || absX < 0 || absY < 0) continue;
			if (random.nextInt(randoMax + 1) == 1) {
				level.pixels[absX + absY * level.width] = tile.tileNum;
			}
		}
	}
}
