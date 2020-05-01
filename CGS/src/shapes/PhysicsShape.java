package shapes;

import java.awt.Color;

import ayush.shapes.Circle;
import ayush.shapes.Rectangle;
import ayush.shapes.TwoDShapes;
import processing.core.PApplet;

/**
 * Represents either a circle or rectangle with a built-in physics engine,
 * acting as a wrapper class for TwoDShape.
 */
public class PhysicsShape {

	private TwoDShapes s;
	private float vx, vy;

	/**
	 * Creates a new PhysicsShape object with the following parameter
	 * 
	 * @param s the shape (circle or rectangle) this object will wrap around
	 */
	public PhysicsShape(TwoDShapes s) {
		this.s = s;
	}

	/**
	 * Draws this shape on a PApplet
	 * 
	 * @param drawer the PApplet onto which the shape will be drawn
	 * @param window the window the program is running in
	 */
	public void draw(PApplet drawer, Rectangle window) {
		s.draw(drawer);

		act(window);
	}

	/**
	 * Utilizes friction, gravity, and velocity to apply physics to the shape's
	 * movement
	 * 
	 * @param window the window the program is running in
	 */
	public void act(Rectangle window) {

		if ((s.getY() < window.getHeight())) {
			move(vx, vy);

		}
		float x = s.getTopLeftX() + s.getWidth();
		float y = window.getWidth();
		if (x > y) {
			vx = Math.abs(vx);
			vx = vx * -1f;
		}

		if (s.getTopLeftX() < 0) {
			vx = Math.abs(vx);
			vx = vx * 1f;
		}

		float x2 = s.getTopLeftY() + 2 * s.getHeight();
		float y2 = window.getHeight();
		if (x2 > y2) {
			vy = Math.abs(vy);
			vy = vy * -1f;
		}

		if (s.getTopLeftY() < 0) {
			vy = Math.abs(vy);
			vy = vy * 1f;
		}

		// friction
		vx *= .95;
		vy *= .98;
	}

	/**
	 * Moves the shape to a new coordinate
	 * 
	 * @param x the x-value of the new coordinate
	 * @param y the y-value of the new coordinate
	 */
	public void move(float x, float y) {
		s.move(s.getX() + x, s.getY() + y);
	}

	/**
	 * Sets the shape's velocity in two dimensions
	 * 
	 * @param vx the horizontal velocity
	 * @param vy the vertical velocity
	 */
	public void setVelocity(float vx, float vy) {
		this.vx = vx;
		this.vy = vy;
	}

	/**
	 * Increases velocity
	 * 
	 * @param ax the amount to increase horizontal velocity
	 * @param ay the amount to increase vertical velocity
	 */
	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}

	/**
	 * @param x the x-coordinate of the point
	 * @param y the x-coordinate of the point
	 * @return true if the point (x, y) is inside the shape, otherwise false.
	 */
	public boolean isPointInside(float x, float y) {
		if (this.s instanceof Circle) {
			return ((Circle) s).isPointIn(x, y);
		} else {
			return false;
		}
	}

	/**
	 * @return the x-coordinate of the shape
	 */
	public float getX() {
		return s.getTopLeftX();
	}

	/**
	 * @return the y-coordinate of the shape
	 */
	public float getY() {
		return s.getTopLeftY();
	}

	/**
	 * @return the width of the shape
	 */
	public float getWidth() {
		return s.getWidth();
	}

	/**
	 * @return the height of the shape
	 */
	public float getHeight() {
		return s.getHeight();
	}

	/**
	 * Sets the shape's color given a Color object
	 * 
	 * @param newcol the new Color of the shape
	 */
	public void setColor(Color newcol) {
		s.setFillColor(newcol);
	}

	/**
	 * @param r the Rectangle to check overlapping with
	 * @return true if there is at least one point that is inside both r and this
	 *         shape.
	 */
	public boolean overlaps(Rectangle r) {

		if (this.s instanceof Rectangle) {
			return s.getX() < r.getX() + r.getWidth() && s.getX() + s.getWidth() > r.getX()
					&& s.getY() < r.getY() + r.getHeight() && s.getY() + s.getHeight() > r.getY();

		} else {
			return false;
		}
	}
}
