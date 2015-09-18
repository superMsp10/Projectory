package game.graphics;

import entity.mob.player.Player;
import game.Main;
import game.graphics.skins.Sprite;

import java.util.Random;

import level.tiles.Tile;

public class Display {
	public int[] pixels;
	public Random random;
	public int xOffSet;
	public int yOffSet;

	public Display() {
		pixels = new int[Main.WIDTH * Main.HEIGHT];
		random = new Random();
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 100000;
		}

	}

	public void testRender() {

		for (int y = 0; y < Main.HEIGHT; y++) {
			for (int x = 0; x < Main.WIDTH; x++) {
				pixels[x + y * Main.WIDTH] = random.nextInt();
			}

		}

	}

	

	public void renderPlayer(int xp, int yp, Player player, int flip) {
		xp -= xOffSet;
		yp -= yOffSet;
		for (int y = 0; y < player.sprite.Height; y++) {
			int yy = yp + y;
			if (yy >= Main.HEIGHT || yy < 0) continue;

			for (int x = 0; x < player.sprite.Width; x++) {
				int xx = xp + x;
				if (xx >= Main.WIDTH || xx < 0) continue;
				int col = player.sprite.pixels[x + y * player.sprite.Size];
				if (col == 0xFFFEEDBA) continue;
				if (col == 0xFFFFFFFF) col = player.col;
				pixels[xx + yy * Main.WIDTH] = col;
			}

		}
	}

	public void renderSprite(Sprite sprite, int xstart, int ystart, boolean fixed) {
		if (fixed) {
			xstart -= xOffSet;
			ystart -= yOffSet;
		}
		for (int y = 0; y < sprite.Height; y++) {
			int yy = ystart + y;
			if (yy >= Main.HEIGHT || yy < 0) continue;

			for (int x = 0; x < sprite.Width; x++) {
				int xx = xstart + x;
				if (xx >= Main.WIDTH || xx < 0) continue;
				pixels[xx + yy * Main.WIDTH] = sprite.pixels[x + y * sprite.Size];
			}

		}
	}

	public void renderTile(Tile tile, int xstart, int ystart) {
		xstart -= xOffSet;
		ystart -= yOffSet;
		for (int y = 0; y < tile.sprite.Height; y++) {
			int yy = ystart + y;

			for (int x = 0; x < tile.sprite.Width; x++) {
				int xx = xstart + x;
				if (xx < -tile.sprite.Size || xx >= Main.WIDTH || yy < -tile.sprite.Size || yy >= Main.HEIGHT) break;
				if (xx < 0) xx = 0;
				if (yy < 0) yy = 0;
				pixels[xx + yy * Main.WIDTH] = tile.sprite.pixels[x + y * tile.sprite.Size];
			}

		}
	}

	public void renderProjectile(int xp, int yp, Sprite sprite) {

	}

	public void setOffSet(int x, int y) {
		xOffSet = x;
		yOffSet = y;

	}

}
