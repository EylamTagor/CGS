package games.psychosearch;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import ayush.shapes.Circle;
import buttons.AyushTextButton;
import buttons.ImageButton;
import general.Player;
import general.Question;
import processing.core.PApplet;
import test.Rectangle;

public class PsychoSearch extends PApplet {

	//
	private Player player;
	private ArrayList<ImageButton> coins;
	private ArrayList<String> answers;
	private int slide;
	private ArrayList<AyushTextButton> locs;
	private float x, y, radius;
	private final int numOfCoins;
	private int money;
	private int secondstimes60;
	private AyushTextButton[] qslidebuttons;
	private String que;
	public int circradintro;
	private AyushTextButton backtohome, quit;
	private int conf;
	private boolean isAddedYet;
	private JFrame window;
	private AyushTextButton quit2;
	private Circle animatedCircle;
	private String ca;
	private ArrayList<Question> answ, wrongans;
	private int index;
	private boolean bool;

	public PsychoSearch(ArrayList<String> as, String question, int seconds, Player p, int conf,
			ArrayList<Question> answer, ArrayList<Question> wronganswers, int index) {
		slide = 0;
		bool = false;
		qslidebuttons = new AyushTextButton[2];
		que = question;
		secondstimes60 = (seconds) * 60;
		qslidebuttons[0] = new AyushTextButton(50, 500, 200, 75, 75, 540, Color.BLACK, Color.WHITE, "Instructions", 25);
		qslidebuttons[1] = new AyushTextButton(550, 500, 200, 75, 575, 540, Color.BLACK, Color.WHITE, "Play!", 25);
		circradintro = 600;
		money = 0;
		answers = as;
		numOfCoins = 5;
		x = 400;
		y = 350;
		radius = 100;
		locs = new ArrayList<AyushTextButton>();
		for (String e : answers) {
			// Answers must be less than 100 pixels wide
			float topx = (float) (Math.random() * 600);
			float topy = (float) (Math.random() * 625);
			locs.add(new AyushTextButton(topx, topy, 150, 50, topx + 10, topy + 20, Color.black, Color.white, e, 15));
		}
		coins = new ArrayList<ImageButton>();
		backtohome = new AyushTextButton(250, 500, 300, 100, 275, 550, Color.BLACK, Color.white, "Back to Question",
				30);
		player = p;
		this.conf = conf;
		isAddedYet = false;
		quit = new AyushTextButton(250, 500, 300, 100, 350, 565, Color.BLACK, Color.white, "Quit", 40);
		quit2 = new AyushTextButton(700, 625, 100, 55, 715, 655, Color.black, Color.white, "Quit", 20);
		animatedCircle = new Circle(400, 350, 200);
		animatedCircle.setFillColor(Color.BLACK);
		ca = as.get(0);
		this.index = index;
		answ = answer;
		wrongans = wronganswers;
	}

	public PsychoSearch(Question ques, int seconds, Player p, int conf, ArrayList<Question> answer,
			ArrayList<Question> wronganswers, int index) {
		player = p;
		bool = false;
		ArrayList<String> as = new ArrayList<String>();
		as.add(ques.getCorrect());
		as.add(ques.getWrong1());
		as.add(ques.getWrong2());
		as.add(ques.getWrong3());

		slide = 0;
		qslidebuttons = new AyushTextButton[2];
		que = ques.getQuestion();
		secondstimes60 = (seconds) * 60;
		qslidebuttons[0] = new AyushTextButton(50, 500, 200, 75, 75, 540, Color.BLACK, Color.WHITE, "Instructions", 25);
		qslidebuttons[1] = new AyushTextButton(550, 500, 200, 75, 575, 540, Color.BLACK, Color.WHITE, "Play!", 25);
		circradintro = 600;
		money = 0;
		answers = as;
		numOfCoins = 5;
		x = 400;
		y = 350;
		radius = 100;
		locs = new ArrayList<AyushTextButton>();
		for (String e : answers) {
			// Answers must be less than 100 pixels wide
			float topx = (float) (Math.random() * 600);
			float topy = (float) (Math.random() * 625);
			locs.add(new AyushTextButton(topx, topy, 150, 50, topx + 10, topy + 20, Color.black, Color.white, e, 15));
		}
		coins = new ArrayList<ImageButton>();
		backtohome = new AyushTextButton(250, 500, 300, 100, 275, 550, Color.BLACK, Color.white, "Back to Question",
				30);
		this.conf = conf;
		isAddedYet = false;
		quit = new AyushTextButton(250, 500, 300, 100, 350, 565, Color.BLACK, Color.white, "Quit", 40);
		quit2 = new AyushTextButton(700, 625, 100, 55, 715, 655, Color.black, Color.white, "Quit", 20);
		animatedCircle = new Circle(400, 350, 200);
		animatedCircle.setFillColor(Color.BLACK);
		ca = ques.getCorrect();
		this.index = index;
		answ = answer;
		wrongans = wronganswers;
	}

	public void setup() {
		for (int i = 0; i < numOfCoins; i++) {
			// coins.add(new ImageButton(loadImage("images\\psychosearch\\coinnw.png"),
			// (float)(Math.random()*740), (float)(Math.random()*640), 50,50));
		}
	}

	public void drawQuestion() {
		background(255);
		textSize(25);
		fill(0);
		text(que, 50, 100);
		qslidebuttons[0].draw(this);
		qslidebuttons[1].draw(this);
		animatedCircle.setX(animatedCircle.getX() + 15);
		if (animatedCircle.getX() > 900) {
			animatedCircle.setX(-100);
		}

		fill(0);
		ellipse(animatedCircle.getX(), animatedCircle.getY(), animatedCircle.getWidth(), animatedCircle.getHeight());
		quit2.draw(this);

	}

	public void instructions() {
		background(255);
		textSize(50);
		fill(0);
		text("instructions", 100, 150);
		backtohome.draw(this);

	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		background(255);

		switch (slide) {
		case 2:
			drawGame();
			break;
		case 0:
			drawQuestion();
			break;
		case 1:
			instructions();
			break;
		case 3:
			lose();
			break;
		case 4:
			win();
			break;
		}

	}

	public void drawGame() {

		if (circradintro > radius) {
			fill(0);
			rect(0, 0, 800, 700);
			fill(255);
			ellipse(400, 350, circradintro * 2, circradintro * 2);
			circradintro -= 10;
		} else {
			drawActualGame();
		}
	}

	public void drawActualGame() {
		for (AyushTextButton e : locs) {
			e.draw(this);
		}
		for (ImageButton e : coins) {
			e.draw(this);
		}

		drawFast();

		fill(0, 255, 255);
		textSize(50);
		text("Time: " + (secondstimes60 / 60 + 1), 275, 60);
		if (secondstimes60 < 0) {
			slide = 3;
		} else {
			secondstimes60--;

		}
		quit2.draw(this);
	}

	public void win() {
		fill(0);
		rect(0, 0, 800, 700);
		fill(0, 255, 0);
		ellipse(x, y, radius * 2, radius * 2);
		if (radius < 1200) {
			radius += 15;
		} else {
			textSize(50);
			fill(0);
			text("Congrats, you won!", 30, 100);
			text("As you know, the answer was ", 30, 160);
			fill(0, 125, 255);
			text(ca, 200, 220);
			// text(money ,30,200);
			// player.passGame(conf);
			if (!isAddedYet) {
				player.passGame(conf);
				isAddedYet = true;
			}
			quit.draw(this);
		}

	}

	public void lose() {

		fill(0);
		rect(0, 0, 800, 700);
		fill(255, 0, 0);
		ellipse(x, y, radius * 2, radius * 2);
		if (radius < 1200) {
			radius += 15;
		} else {
			textSize(50);
			fill(0);
			text("Oh no! You either hit the wrong \nanswer or ran out of time.", 30, 100);
			text("The correct answer was ", 30, 240);
			fill(0, 125, 255);
			text(ca, 200, 300);
			// text(money ,30,200);
			// player.passGame(conf);
			if (!isAddedYet) {
				player.passGame(conf);
				isAddedYet = true;
			}
			quit.draw(this);
		}

		if (!bool) {
			bool = true;
			wrongans.add(answ.get(index));
		}

		// text(money ,30,200);
	}

	public void drawFast() {
		// background(255);
		Rectangle circle = new Rectangle(x - radius, y - radius, radius * 2, radius * 2);
		Rectangle left = new Rectangle(0, 0, x - radius, 700);
		Rectangle right = new Rectangle(x + radius, 0, 800 - (x + radius), 700);
		Rectangle up = new Rectangle(0, 0, 800, y - radius);
		Rectangle down = new Rectangle(0, y + radius, 800, 700 - (y + radius));
		left.draw(this, new Color(0, 0, 0));
		right.draw(this, new Color(0, 0, 0));
		up.draw(this, new Color(0, 0, 0));
		down.draw(this, new Color(0, 0, 0));
		for (float px = circle.getX(); px < circle.getWidth() + circle.getX(); px++) {
			for (float py = circle.getY(); py < circle.getHeight() + circle.getY(); py++) {
				if (!isInCircle(px, py)) {
					fill(0);
					rect(px, py, 1, 1);
				}
			}
		}

	}

	public void setFrame(JFrame wind) {
		window = wind;
	}

	public boolean isInCircle(float xx, float yy) {
		float xmath = Math.abs(xx - x) * Math.abs(xx - x);
		float ymath = Math.abs(yy - y) * Math.abs(yy - y);

		if (Math.sqrt(xmath + ymath) < radius) {
			return true;
		} else {
			return false;
		}
	}

	public void mouseClicked() {
		int mx = mouseX;
		int my = mouseY;

		if (slide == 0) {

			if (qslidebuttons[0].isPointInButton(mx, my)) {

				slide = 1;
				qslidebuttons[0].setBColor(Color.white);
			} else if (qslidebuttons[1].isPointInButton(mx, my)) {
				slide = 2;
				qslidebuttons[1].setBColor(Color.white);

			} else if (quit2.isPointInButton(mx, my)) {
				window.dispose();
			}
		} else if (slide == 2) {

			if (locs.get(0).isPointInButton(mx, my)) {
				slide = 4;// win
			}

			if (quit2.isPointInButton(mx, my)) {
				window.dispose();
			}

			for (int i = 1; i < locs.size(); i++) {
				if (locs.get(i).isPointInButton(mx, my)) {
					slide = 3;// lose
				}
			}

			for (int i = 0; i < coins.size(); i++) {
				if (coins.get(i).isPointInButton(mx, my)) {
					coins.remove(i);
					money++;
				}
			}
		} else if (slide == 1) {
			if (backtohome.isPointInButton(mx, my)) {
				slide = 0;
				backtohome.setBColor(Color.white);
			}
		} else if (slide == 3) {
			if (quit.isPointInButton(mx, my)) {
				window.dispose();
			}
		} else if (slide == 4) {
			if (quit.isPointInButton(mx, my)) {
				window.dispose();
			}
		}

	}

	public void mouseMoved() {

		int px = mouseX;
		int py = mouseY;
		Color col1 = new Color(0, 255, 255);
		Color col2 = new Color(41, 155, 149);
		Color col4 = new Color(96, 117, 150);
		Color col3 = new Color(55, 64, 79);
		if (slide == 2) {
			for (AyushTextButton e : locs) {
				if (e.isPointInButton(px, py)) {
					e.setBColor(new Color(0, 255, 255));
				} else {
					e.setBColor(Color.WHITE);
				}
			}

			if (quit2.isPointInButton(px, py)) {
				quit2.setBColor(new Color(125, 125, 125));

			} else {
				quit2.setBColor(Color.white);
			}
		} else if (slide == 0) {
			if (slide == 0) {
				for (AyushTextButton e : qslidebuttons) {
					if (e.isPointInButton(px, py)) {
						e.setBColor(col2);
					} else {
						e.setBColor(Color.white);
					}

				}

				if (quit2.isPointInButton(px, py)) {
					quit2.setBColor(new Color(125, 125, 125));

				} else {
					quit2.setBColor(Color.white);
				}
			}
		} else if (slide == 1) {
			if (backtohome.isPointInButton(px, py)) {
				backtohome.setBColor(col2);
			} else {
				backtohome.setBColor(Color.WHITE);
			}
		} else if (slide == 3) {
			if (quit.isPointInButton(px, py)) {
				quit.setBColor(col1);
			} else {
				quit.setBColor(Color.white);
			}
		} else if (slide == 4) {
			if (quit.isPointInButton(px, py)) {
				quit.setBColor(col1);
			} else {
				quit.setBColor(Color.white);
			}
		}

	}

	public void keyPressed() {
		if (keyCode == KeyEvent.VK_UP) {
			y -= 10;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			x += 10;
		} else if (keyCode == KeyEvent.VK_LEFT) {
			x -= 10;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			y += 10;
		} else if (keyCode == KeyEvent.VK_5) {
			window.dispose();
		}
		// update();
	}

}
