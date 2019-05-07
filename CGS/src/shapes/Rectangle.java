package shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * Represents a graphical rectangle with calculations and functionalities
 * related to rectangles.
 */
public class Rectangle {
	private float x, y, width, height;

	/**
	 * Creates a new Rectangle object with teh following parameters
	 * 
	 * @param x      the x-coordinate of the rectangle
	 * @param y      the y-coordinate of the rectangle
	 * @param width  the width of the rectangle
	 * @param height the height of the rectangle
	 */
	public Rectangle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * @return the x-coordinate of the rectangle
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate of the rectangle
	 * 
	 * @param x the new x-value
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y-coordinate of the rectangle
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the y-coordinate of the rectangle
	 * 
	 * @param y the new y-value
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the width of the rectangle
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * Sets the width of the rectangle
	 * 
	 * @param width the new width value
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the height of the rectangle
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Sets the height of the rectangle
	 * 
	 * @param height the new height value
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * Draws the rectangle on a PApplet
	 * 
	 * @param papp the PApplet onto which the rectangle will be drawn
	 * @param fcol the fill color of the rectangle
	 */
	public void draw(PApplet papp, Color fcol) {
		papp.fill(fcol.getRed(), fcol.getGreen(), fcol.getBlue());
		papp.rect(x, y, width, height);
	}

}
