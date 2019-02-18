package games.birdblunder;

import java.awt.Color;
import java.util.ArrayList;

import ayush.shapes.Rectangle;
import btns.ImageButton;
import btns.TextButton;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface2 extends PApplet {

	//
	private int counter;
	private PhysicsShape shape;
	private PImage background, bird, coin;
	private final int numOfAnswersPerSec;
	private boolean devMode;
	private ArrayList<String> answers;
	private int index;
	private int slide;
	private String que;
	private ArrayList<Answer> birds;
	private TextButton[] qslidebuttons;
	private String ca;
	private int countercoins;
	private double numOfCoinsPerSec;
	private ArrayList<ImageButton> coins;
	private int money;

	public DrawingSurface2(ArrayList<String> as, String question) {
		qslidebuttons = new TextButton[2];
		shape = new PhysicsShape(new Rectangle(100, 250, 50, 50));
		numOfAnswersPerSec = 1;
		counter = 0;
		birds = new ArrayList<Answer>();
		coins = new ArrayList<ImageButton>();
		devMode = false;
		answers = as;
		index = 0;
		slide = 0;
		que = question;
		qslidebuttons[0] = new TextButton(50, 500, 200, 75, 75, 540, Color.BLACK, Color.WHITE, "Instructions", 25);
		qslidebuttons[1] = new TextButton(550, 500, 200, 75, 575, 540, Color.BLACK, Color.WHITE, "Play!", 25);
		ca = as.get(0);
		countercoins = 0;
		numOfCoinsPerSec = .5;
		money = 0;

	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		background = loadImage("images\\birdblunder\\back.jpg");
		bird = loadImage("images\\birdblunder\\bird.png");
		coin = loadImage("images\\birdblunder\\coinnw.png");
	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		switch (slide) {
		case 0:
			drawQuestion();
			break;
		case 1:
			drawGame();
			break;
		case 2:
			break;
		case 3:
			instructions();
			break;
		case 4:
			win();
			break;
		}

	}

	public void drawQuestion() {
		background(255);
		textSize(25);
		fill(0);
		text(que, 50, 50);
		qslidebuttons[0].draw(this);
		qslidebuttons[1].draw(this);
	}

	public void instructions() {
		background(255);
		textSize(50);
		fill(0);
		text("instructions", 100, 150);
	}

	public void drawGame() {
		background(255);
		image(background, 0, 0, 800, 700);
		shape.act(new Rectangle(0, 0, 800, 700));
		image(bird, shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
		if (devMode) {
			shape.draw(this, new Rectangle(0, 0, 800, 700));
		}
		if (shape.getY() < 700 - shape.getHeight()) {
			shape.accelerate(0, .2);

		} else {

			slide++;
		}

		if (counter < (60 / numOfAnswersPerSec)) {
			counter++;
		} else {
			counter = 0;
			String answer;
			if (index >= answers.size()) {
				index = 0;
			}
			answer = answers.get((int) (Math.random() * answers.size()));
			birds.add(new Answer(answer, 800, (int) (Math.random() * 600), 25));
			index++;
		}

		if (countercoins < 60 / numOfCoinsPerSec) {
			countercoins++;
		} else {
			countercoins = 0;
			ImageButton coindraw = new ImageButton(coin, 900, (float) (Math.random() * 625), 50, 50);
			coins.add(coindraw);

		}

		for (int i = 0; i < coins.size(); i++) {

			ImageButton e = coins.get(i);
			e.draw(this);
			e.setX(e.getX() - 10);

			if (shape.overlaps(e.getRectangle())) {
				coins.remove(i);
				money++;
			}

			if (devMode) {
				e.getRectangle().draw(this);
			}
		}

		for (Answer e : birds) {
			e.moveLeft();

			e.draw(this);
			Rectangle r = e.getRectangle();
			if (shape.overlaps(r)) {
				if (e.getText().equalsIgnoreCase(ca)) {
					win();
				} else {

					shape.setColor(Color.RED);
					lose(e.getText());
					slide = 2;
					break;
				}
			}
			if (devMode) {
				r.draw(this);
			}

		}

	}

	public void win() {
		// TODO Auto-generated method stub
		background(255);
		textSize(50);
		fill(0);
		text("You hit the correct answer, \n" + ca, 75, 150);
		text("Money: " + money, 75, 300);
		slide = 4;
	}

	public void mouseClicked() {

		int x = mouseX;
		int y = mouseY;

		if (slide == 0) {
			if (qslidebuttons[0].isPointInButton(x, y)) {
				slide = 3;
			} else if (qslidebuttons[1].isPointInButton(x, y)) {
				slide = 1;
			}
		}

	}

	public void mouseMoved() {

		int px = mouseX;
		int py = mouseY;

		Color col1 = new Color(0, 255, 255);
		Color col2 = new Color(0, 0, 255);

		if (slide == 0) {
			for (TextButton e : qslidebuttons) {
				if (e.isPointInButton(px, py)) {
					e.setBColor(col1);
				} else {
					e.setBColor(Color.white);
				}

			}
		}

	}

	public void lose(String wrong) {
		background(255);
		textSize(50);
		fill(0);
		text("You lost! The correct answer \nwas " + ca + "\nYou hit " + wrong, 75, 150);
		text("Money: " + money, 75, 300);

		slide = 2;
	}

	public void keyPressed() {
		if (key == ' ') {
			shape.accelerate(0, -.75);

		} else if (key == 'j') {
			devMode = !devMode;
		}
	}

}
