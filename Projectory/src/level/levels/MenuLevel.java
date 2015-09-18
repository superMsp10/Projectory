package level.levels;

import game.Main;
import game.graphics.skins.Sprite;
import game.inputs.Mouse;

public class MenuLevel extends Level {
	protected Sprite background;

	public MenuLevel(int Width, int Height, Mouse mouse) {
		super(Width, Height, false);
	}

	public void render(int xOffSet, int yOffSet) {
		if (background != null) Main.SCREEN.renderSprite(background, 0, 0, true);
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(Main.SCREEN);
		}
	}

	public void setBackGround(Sprite sprite) {
		background = sprite;
	}
}
