package general;

import java.awt.Color;

import buttons.AyushTextButton;
import buttons.ImageButton;
import processing.core.PApplet;
import processing.core.PFont;

public class Intro extends PApplet {

	//
	private final String font;
	private ImageButton next, next2;
	private AyushTextButton[] options;
	private int slide;

	public Intro() {
		font = "Verdana";
		slide = 1;
		options = new AyushTextButton[11];
		options[0] = new AyushTextButton(30, 70, 200, 75, 65, 110, Color.BLACK, Color.WHITE, "Topic 1", 30);
		options[1] = new AyushTextButton(300, 70, 200, 75, 335, 110, Color.BLACK, Color.WHITE, "Topic 2", 30);
		options[2] = new AyushTextButton(570, 70, 200, 75, 605, 110, Color.BLACK, Color.WHITE, "Topic 3", 30);
		options[3] = new AyushTextButton(30, 230, 200, 75, 65, 270, Color.BLACK, Color.WHITE, "Topic 4", 30);
		options[4] = new AyushTextButton(300, 230, 200, 75, 335, 270, Color.BLACK, Color.WHITE, "Topic 5", 30);
		options[5] = new AyushTextButton(570, 230, 200, 75, 605, 270, Color.BLACK, Color.WHITE, "Topic 6", 30);
		options[6] = new AyushTextButton(30, 390, 200, 75, 65, 430, Color.BLACK, Color.WHITE, "Topic 7", 30);
		options[7] = new AyushTextButton(300, 390, 200, 75, 335, 430, Color.BLACK, Color.WHITE, "Topic 8", 30);
		options[8] = new AyushTextButton(570, 390, 200, 75, 605, 430, Color.BLACK, Color.WHITE, "Topic 9", 30);
		options[9] = new AyushTextButton(30, 550, 200, 75, 65, 590, Color.BLACK, Color.WHITE, "Topic 10", 30);
		options[10] = new AyushTextButton(300, 550, 200, 75, 335, 590, Color.BLACK, Color.WHITE, "Topic 11", 30);

	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		next = new ImageButton(loadImage("images\\intro\\next.png"), 300, 450, 200, 200);
		next2 = new ImageButton(loadImage("images\\intro\\next.png"), 580, 500, 150, 150);

	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		if (slide == 1) {
			background(255);
			fill(255, 0, 0);
			textFont(createFont(font, 100));
			text("Welcome to", 100, 130);
			text("FBLA Tester", 90, 280);
			next.draw(this);
		} else if (slide == 2) {
			background(255);
			text("cutscene", 100, 130);
			next.draw(this);
		} else if (slide == 3) {
			background(255);
			textSize(33);
			fill(255, 0, 0);
			text("Choose the topics you want to study(at least 5)", 10, 50);
			options[0].draw(this);
			options[1].draw(this);
			options[2].draw(this);
			options[3].draw(this);
			options[4].draw(this);
			options[5].draw(this);
			options[6].draw(this);
			options[7].draw(this);
			options[8].draw(this);
			options[9].draw(this);
			options[10].draw(this);

			next2.draw(this);

		} else if (slide == 4) {
			background(255);
		}

	}

	public void mouseClicked() {

		int x = mouseX;
		int y = mouseY;

		Color col1 = new Color(0, 0, 255);
		Color col2 = new Color(0, 255, 255);

		if (slide == 1) {
			if (mouseButton == LEFT) {
				if (next.isPointInButton(mouseX, mouseY)) {
					slide++;
				}
			}

		} else if (slide == 2) {
			if (mouseButton == LEFT) {
				if (next.isPointInButton(mouseX, mouseY)) {
					slide++;
				}
			}
		} else if (slide == 3) {
			if (mouseButton == LEFT) {

				if (next2.isPointInButton(x, y)) {
					slide++;
				}

				for (int i = 0; i < 11; i++) {
					if (options[i].isPointInButton(x, y)) {
						if (options[i].getBColor().equals(col1)) {
							options[i].setBColor(col2);
						} else {
							options[i].setBColor(col1);

						}
					}
				}
			}
		}

	}

	public void mouseMoved() {

		int x = mouseX;
		int y = mouseY;
		Color col1 = new Color(0, 255, 255);
		Color col2 = new Color(0, 0, 255);

		if (slide == 3) {
			for (AyushTextButton one : options) {
				if (!one.getBColor().equals(col2)) {
					if (one.isPointInButton(x, y)) {
						one.setBColor(col1);
					} else {
						one.setBColor(Color.white);
					}

				}
			}
		}

	}

}
