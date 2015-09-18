package game.graphics.skins;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int Size;
	public final int[] pixels;

	public SpriteSheet(String path, int size) {
		Size = size;
		this.path = path;
		pixels = new int[size * size];
		load();
	}

	private void load() {

		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
