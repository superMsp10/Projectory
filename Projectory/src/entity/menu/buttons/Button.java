package entity.menu.buttons;

import java.awt.Point;
import java.awt.Rectangle;

import entity.Entity;
import entity.menu.Menu;
import game.graphics.Display;
import game.graphics.anim.Animation;
import game.graphics.skins.Sprite;
import game.inputs.Mouse;

public class Button extends Entity {
	protected Sprite sprite;
	protected boolean fixed;
	protected Mouse mouse;
	protected String name;
	protected Animation anim;
	protected int defSprite;
	protected Menu parentMenu;

	public Button(Animation anim, int x, int y, boolean fixed, Mouse mouse,Menu menu, String name) {
		defSprite = 0;
		sprite = anim.getSprite(defSprite);
		this.x = x;
		this.y = y;
		this.anim = anim;
		this.width = sprite.Width;
		this.height = sprite.Height;
		this.fixed = fixed;
		this.mouse = mouse;
		this.name = name;
		parentMenu = menu;
		boundingBox = new Rectangle((int) x * 4, (int) y * 4, (int) width * 4, (int) height * 4);
	}

	protected void onClick() {
		System.out.println("clicked::  " + name);
	}

	protected void onHover() {
		System.out.println("hovered:  " + name);
	}

	public void render(Display screen) {
		screen.renderSprite(sprite, (int) x, (int) y, fixed);
	}

	public void update() {
		Mousecollision();
	}

	protected void Mousecollision() {

		Point p = new Point(mouse.mouseX(), mouse.mouseY());
		if (boundingBox.contains(p)) {
			onHover();
			if (mouse.mouseB() == 1) onClick();
		} else {
			sprite = anim.getSprite(defSprite);
		}
	}

	public void changeSprite(Sprite sprite) {
		sprite = anim.getSprite(0);
		this.width = sprite.Width;
		this.height = sprite.Height;
	}

	public void setDefSprite(int d) {
		defSprite = d;
	}
}
