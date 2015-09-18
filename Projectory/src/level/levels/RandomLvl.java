package level.levels;

import java.util.Random;

import level.tiles.Tile;
import level.tiles.TilePatch;

public class RandomLvl extends Level {
	private int chance = 0;
	private int chance1 = 0;
	private int chance2 = 0;
	public TilePatch wetMarblePatch, barracadePatch, taintedMarblePatch;
	private int tileNum;
	public static Random random = new Random();

	public RandomLvl(int Width, int Height) {
		super(Width, Height, true);
		barracadePatch = new TilePatch(Tile.BARRACADE, 10, 1, this);
		wetMarblePatch = new TilePatch(Tile.wetMARBLE, 10, 1, this);
		taintedMarblePatch = new TilePatch(Tile.TaintedMARBLE, 10, 1, this);
		generateLevel();
	}

	public void generateLevel() {
		for (int tileY = 0; tileY < height; tileY++) {
			for (int tileX = 0; tileX < width; tileX++) {
				if (pixels[tileY + tileX * width] != 0) continue;
				chance1 = random.nextInt(10);
				chance = random.nextInt(10);
				chance2 = random.nextInt(10);
				tileNum = Tile.FLOORMARBLE.tileNum;
				if (chance == 1 && chance1 == 1 && chance2 == 1)
					barracadePatch.generate(tileX, tileY);
				else if (chance == 2 && chance1 == 1 && chance2 == 1)
					wetMarblePatch.generate(tileX, tileY);
				else if (chance == 3 && chance1 == 1 && chance2 == 1 || chance == 4 && chance1 == 1 && chance2 == 1) taintedMarblePatch.generate(tileX, tileY);
				pixels[tileY + tileX * width] = tileNum;
			}
		}
	}
}
