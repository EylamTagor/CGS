

import processing.core.PApplet;

public class Obstacle {
	private int lane, cue;

	private float x, y, width, height;

	public Obstacle(int lane, int cue) {
		this.lane = lane;
		this.cue = cue;
		x = 750 + 250 * cue;
		y = 150 + lane * 100;
		width = 50;
		height = 50;
	}

	public void draw(PApplet p) {
		p.strokeWeight(0);
		p.fill(0);
		p.image(p.loadImage("images\\obstacle.png"), x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public int getLane() {
		return lane;
	}

	public int getCue() {
		return cue;
	}

	public void move(double amount) {
		x -= amount;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isPointInside(float x) {
		return x > this.x && x < this.x + width;
	}
}
