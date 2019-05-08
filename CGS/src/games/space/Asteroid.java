package games.space;

import other.Question;
import processing.core.PApplet;

/**
 * Represents an Asteroid containing an answer to the corresponding Space game's
 * question, to be touched by the player's astronaut.
 */
public class Asteroid {
	private Question question;
	private int ans;
	private boolean top;

	private float x, y, width, height;

	/**
	 * Creates a new Asteroid object with the following parameters, a width of 125
	 * pixels, and a height of 75 pixels.
	 * 
	 * @param question the Question of the corresponding Space game
	 * @param ans      the answer to Question that this Asteroid holds
	 * @param x        the x-coordinate of the asteroid
	 * @param y        the y-coordinate of the asteroid
	 */
	public Asteroid(Question question, int ans, float x, float y) {
		this.question = question;
		this.ans = ans;
		this.x = x;
		this.y = y;
		width = 125;
		height = 75;
		top = y < 350;
	}

	/**
	 * Draws this asteroid on a PApplet
	 * 
	 * @param p the PApplet onto which this asteroid will be drawn
	 */
	public void draw(PApplet p) {
		p.strokeWeight(0);
		p.fill(175);
		p.image(p.loadImage("images\\asteroid.png"), x - width / 2, y - height / 2, width, height);

		p.fill(255);

		if (ans == 0)
			p.text(question.getCorrect(), x, y);
		if (ans == 1)
			p.text(question.getWrong1(), x, y);
		if (ans == 2)
			p.text(question.getWrong2(), x, y);
		if (ans == 3)
			p.text(question.getWrong3(), x, y);
	}

	/**
	 * @return the x-coordinate of the asteroid
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the y-coordinate of the asteroid
	 */
	public float getY() {
		return y;
	}

	/**
	 * @return the width of the asteroid
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @return the height of the asteroid
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @return true if the asteroid's initial position is at the top half of the
	 *         screen, false if it is at the bottom half
	 */
	public boolean isTop() {
		return top;
	}

	/**
	 * Moves the asteroid to a new coordinate (x, y)
	 * 
	 * @param x the x-value of the new coordinate
	 * @param y the y-value of the coordinate
	 */
	public void moveTo(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets the width of the asteroid
	 * 
	 * @param width the new width value
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * Sets the height of the asteroid
	 * 
	 * @param height the new height value
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * @param x      the x-coordinate of the ellipse
	 * @param y      the y-coordinate of the ellipse
	 * @param width  the width of the ellipse
	 * @param height the height of the ellipse
	 * @return true if an ellipse at point (x, y) with dimensions width and height
	 *         respectively has at least one common point with this asteroid.
	 */
	public boolean isEllipseInside(float x, float y, float width, float height) {
		return x > this.x - this.width / 2 && x < this.x + this.width / 2 && y > this.y - this.height / 2
				&& y < this.y + this.height / 2;
	}
}
