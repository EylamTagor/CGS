package games.driving;

import other.Question;
import processing.core.PApplet;

/**
 * Represents a fuel tank with an answer, to be hit by the player's car in the
 * Driving game.
 */
public class FuelTank {
	private Question question;
	private int ans, lane, cue;

	private float x, y, width, height;

	/**
	 * Creates a new FuelTank object with the following parameters, width of 150
	 * pixels and height of 50 pixels
	 * 
	 * @param question the Question to be answered by this FuelTank's instance of
	 *                 Driving
	 * @param ans      the answer of this fuel tank
	 * @param lane     the lane (0-3) in which the fuel tank is located
	 * @param cue      the order (0-3) in which this fuel tank is approached by the
	 *                 player's car in relation to other fuel tanks
	 */
	public FuelTank(Question question, int ans, int lane, int cue) {
		this.question = question;
		this.ans = ans;
		this.lane = lane;
		this.cue = cue;
		x = 750 + 250 * cue;
		y = 150 + lane * 100;
		width = 150;
		height = 50;
	}

	/**
	 * Draws this fuel tank on a PApplet
	 * 
	 * @param p the PApplet onto which the fuel tank will be drawn
	 */
	public void draw(PApplet p) {
		p.strokeWeight(0);
		p.fill(155, 0, 155);
		p.image(p.loadImage("images\\fuel.png"), x, y, width, height);

		p.fill(255);
		p.textAlign(PApplet.LEFT);

		if (ans == 0)
			p.text(question.getCorrect(), x + 25, y + 40);
		if (ans == 1)
			p.text(question.getWrong1(), x + 25, y + 40);
		if (ans == 2)
			p.text(question.getWrong2(), x + 25, y + 40);
		if (ans == 3)
			p.text(question.getWrong3(), x + 25, y + 40);
	}

	/**
	 * @return the x-coordinate of the fuel tank
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the lane in which the fuel tank is located
	 */
	public int getLane() {
		return lane;
	}

	/**
	 * @return the fuel tank's cue to appear onscreen
	 */
	public int getCue() {
		return cue;
	}

	/**
	 * Moves the fuel tank horizontally towards the car (left)
	 * 
	 * @param amount the amount to move the fuel tank
	 */
	public void move(double amount) {
		x -= amount;
	}

	/**
	 * Sets the width of the fuel tank
	 * 
	 * @param width the new width value
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * Sets the height of the fuel tank
	 * 
	 * @param height the new height value
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * @param x the x-value of the line
	 * @return true if the line y = x intersects with the fuel tank
	 */
	public boolean isPointInside(float x) {
		return x > this.x && x < this.x + width;
	}
}
