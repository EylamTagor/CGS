package psychosearch;

import java.awt.Color;

import processing.core.PApplet;

public class Rectangle {
	private float x,y,width,height;

	public Rectangle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	public void draw(PApplet papp, Color fcol) {
		papp.fill(fcol.getRed(), fcol.getGreen(), fcol.getBlue());
		papp.rect(x,y,width,height);
	}
	
}
