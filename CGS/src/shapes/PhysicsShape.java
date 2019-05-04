package shapes;

import ayush.shapes.*;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import ayush.shapes.Circle;
import ayush.shapes.TwoDShapes;
import processing.core.PApplet;

public class PhysicsShape {

	private TwoDShapes s; // If your library has 2 levels of inheritance, could change this to be 1 level
							// down (A 2D Shape rather than a Shape)
	private float vx, vy;

	public PhysicsShape(TwoDShapes s) {
		this.s = s;
	}

	public void draw(PApplet drawer, Rectangle window) { // -------STEP 2------- (after this, see if your shape is
															// visible)
		// Add code to call draw on your Shape s. Probably like this:
		s.draw(drawer);

		act(window);
	}

	// Call this method at the end of your draw() method in DrawingSurface to make
	// your PhysicsShapes move.
	public void act(Rectangle window) { // -------STEP 3-------

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

	public void move(float x, float y) {
		s.move(s.getX() + x, s.getY() + y);
	}

	public void setVelocity(float vx, float vy) {
		this.vx = vx;
		this.vy = vy;
	}

	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}

	public boolean isPointInside(float x, float y) {
		if (this.s instanceof Circle) {
			return ((Circle) s).isPointIn(x, y);
		} else {
			return false;
		}
	}

	public float getX() {
		return s.getTopLeftX();
	}

	public float getY() {
		return s.getTopLeftY();
	}

	public float getWidth() {
		return s.getWidth();
	}

	public float getHeight() {
		return s.getHeight();
	}

	public void setColor(Color newcol) {
		s.setFillColor(newcol);
	}

	public boolean overlaps(Rectangle r) {

		if (this.s instanceof Rectangle) {
			return s.getX() < r.getX() + r.getWidth() && s.getX() + s.getWidth() > r.getX()
					&& s.getY() < r.getY() + r.getHeight() && s.getY() + s.getHeight() > r.getY();

		} else {
			return false;
		}
	}
}
