package games.flight;

import ayush.shapes.Rectangle;
import processing.core.PApplet;

/**
 * Represents a flying piece of text that is an answer to the corresponding
 * Flight game's question.
 */
public class Answer {
	private String text;

	/**
	 * @return the answer as text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the anwer's text
	 * 
	 * @param the new text value
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the x-coordinate of the answer
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate of the answer
	 * 
	 * @param x the new x-value
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y-coordinate of the answer
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the y-coordinate of the answer
	 * 
	 * @param y the new y-value
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the size of the answer
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size of the text
	 * 
	 * @param s the new size value
	 */
	public void setSize(int s) {
		size = s;
	}

	private float x, y;
	private int size;

	/**
	 * Creates a new Answer object with the following parameters
	 * 
	 * @param text the answer as text
	 * @param x    the x-coordinate of the answer
	 * @param y    the y-coordinate of the answer
	 * @param size the size of the text
	 */
	public Answer(String text, float x, float y, int size) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.size = size;
	}

	/**
	 * Draws the answer on a PApplet
	 * 
	 * @param papp the PApplet onto which the answer will be drawn
	 */
	public void draw(PApplet papp) {
		papp.pushStyle();
		papp.fill(0);
		papp.textSize(size);

		papp.text(text, x, y + size);
		papp.popStyle();
	}

	/**
	 * Moves the answer left horizontally (towards the player's bird)
	 */
	public void moveLeft() {
		x -= 5;
	}

	/**
	 * @return a Rectangle object that encompasses the answer, having the same
	 *         dimensions as the answer
	 */
	public Rectangle getRectangle() {
		double width = 0;
		for (int i = 0; i < text.length(); i++) {
			width += size / 2.0;
		}
		return new Rectangle(x, y, (int) width, size);
	}
}
