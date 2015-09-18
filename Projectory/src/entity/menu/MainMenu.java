package entity.menu;

import entity.menu.buttons.Startbutton;
import game.Main;
import game.graphics.skins.Sprite;
import game.inputs.Mouse;
import game.sounds.Sound;
import level.levels.MenuLevel;

public class MainMenu extends Menu {

	protected final Sprite anim;
	protected final Sound sound;
	private Mouse mouse;
	public Startbutton startGame;

	public MainMenu(Sprite anim, Sound sound, Mouse mouse, MenuLevel level) {
		super(-Main.WIDTH / 2, -Main.HEIGHT / 2, true, level);
		this.anim = anim;
		this.sound = sound;
		this.mouse = mouse;
		startGame = new Startbutton(Main.WIDTH - 70, 60, true, this.mouse, this, "startGame");
		startGame.init(level);
		level.add(startGame);
		level.setBackGround(anim);
		sound.play();
	}

	public void update() {

	}

	public void remove() {
		removed = true;
		sound.clip.stop();
		startGame.remove();
	}

}
