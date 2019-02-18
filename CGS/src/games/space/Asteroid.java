package games.space;

import general.Question;
import processing.core.PApplet;

public class Asteroid {
	private Question question;
	private int ans;
	private boolean top;

	private float x, y, width, height;

	public Asteroid(Question question, int ans, float x, float y) {
		this.question = question;
		this.ans = ans;
		this.x = x;
		this.y = y;
		width = 125;
		height = 75;
		top = y < 350;
	}

	public void draw(PApplet p) {
		p.strokeWeight(0);
		p.fill(175);
//		p.ellipse(x, y, width, height);
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

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public boolean isTop() {
		return top;
	}

	public void moveTo(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isEllipseInside(float x, float y, float width, float height) {
		return x > this.x - this.width / 2 && x < this.x + this.width / 2 && y > this.y - this.height / 2
				&& y < this.y + this.height / 2;
	}
}
