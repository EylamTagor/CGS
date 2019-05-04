package games.driving;

import processing.core.PApplet;
import running.Question;

public class FuelTank {
	private Question question;
	private int ans, lane, cue;

	private float x, y, width, height;

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
