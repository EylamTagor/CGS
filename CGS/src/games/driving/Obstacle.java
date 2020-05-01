package games.driving;

import processing.core.PApplet;

/**
 * Represents an obstacle meant to be avoided by the player's car in the Driving
 * game.
 */
public class Obstacle {
	private int lane, cue;

	private float x, y, width, height;

	/**
	 * Creates a new Obstacle object
	 * 
	 * @param lane the lane (0-3) in which the obstacle is located
	 * @param cue  the cue (0-3) indicating when the obstacle is to appear onscreen
	 *             in relation to other obstacles.
	 */
	public Obstacle(int lane, int cue) {
		this.lane = lane;
		this.cue = cue;
		x = 750 + 250 * cue;
		y = 150 + lane * 100;
		width = 50;
		height = 50;
	}

	/**
	 * Draws the obstacle on a PApplet
	 * 
	 * @param p the PApplet onto which the obstacle is to be drawn
	 */
	public void draw(PApplet p) {
		p.strokeWeight(0);
		p.fill(0);
		p.image(p.loadImage("images\\obstacle.png"), x, y, width, height);
	}

	/**
	 * @return the x-coordinate of the obstacle
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the lane in which the obstacle is located
	 */
	public int getLane() {
		return lane;
	}

	/**
	 * @return the obstacle's cue indicating when to appear in relation to other
	 *         obstacles
	 */
	public int getCue() {
		return cue;
	}

	/**
	 * Moves the obstacle horizontally towards the player's car (left)
	 * 
	 * @param amount the amount to be moved, in pixels
	 */
	public void move(double amount) {
		x -= amount;
	}

	/**
	 * Sets the width of the obstacle
	 * 
	 * @param width the new width value
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * Sets the height of the obstacle
	 * 
	 * @param height the new height value
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * @param x the x-coordinate of the line
	 * @return true if the line (y = x) intersects with this obstacle
	 */
	public boolean isPointInside(float x) {
		return x > this.x && x < this.x + width;
	}
}
