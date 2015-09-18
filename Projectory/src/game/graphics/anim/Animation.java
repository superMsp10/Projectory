package game.graphics.anim;

import game.graphics.skins.Sprite;
import game.graphics.skins.SpriteSheet;

public class Animation {
	public Sprite[] animSprite;
	protected int animWidth;

	public Animation(SpriteSheet sheet, int spriteSize, int xStart, int yStart, int animWidth, int animHeight) {
		this.animWidth = animWidth;
		animSprite = new Sprite[animWidth * animHeight];
		for (int y = 0; y < animHeight; y++) {
			for (int x = 0; x < animWidth; x++) {
				if (x < 0 || y < 0 || x >= animWidth || y >= animHeight) continue;
				int xx = x + xStart;
				int yy = y + yStart;
				animSprite[x + y * animWidth] = new Sprite(sheet, xx, yy, spriteSize);

			}
		}
	}

	public Animation(SpriteSheet sheet, int spriteW, int spriteH, int xStart, int yStart, int animWidth, int animHeight) {
		this.animWidth = animWidth;
		animSprite = new Sprite[animWidth * animHeight];
		for (int y = 0; y < animHeight; y++) {
			for (int x = 0; x < animWidth; x++) {
				if (x < 0 || y < 0 || x >= animWidth || y >= animHeight) continue;
				int xx = x + xStart;
				int yy = y + yStart;
				animSprite[x + y * animWidth] = new Sprite(sheet, xx, yy, spriteW, spriteH);

			}
		}
	}

	public Sprite getSprite(int x, int y) {
		if (x < 0 || y < 0 || x + y * animWidth >= animSprite.length)
			return Sprite.NULLSPRITE;
		else
			return animSprite[x + y * animWidth];

	}

	public Sprite getSprite(int i) {
		if (i < 0 || i >= animSprite.length)
			return Sprite.NULLSPRITE;
		else
			return animSprite[i];

	}
}
