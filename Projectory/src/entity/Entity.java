package entity;

import game.graphics.Display;

import java.awt.Rectangle;

import level.levels.Level;

public abstract class Entity {

	public double x,width,height;
	public double y;
	protected boolean removed;
	protected Level level;
	protected Rectangle boundingBox;

	public void init(Level level) {
		this.level = level;
	}

	public void render(Display screen) {

	}

	public void update() {

	}
	
	
	public void Ecollision(Entity e){
		
	}

	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public double getX() {

		return x;
	}

	public double getY() {

		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Rectangle getBoundingBox(){
		return boundingBox;
	}
	
	
	

}
