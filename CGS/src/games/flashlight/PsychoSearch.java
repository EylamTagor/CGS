package games.flashlight;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import ayush.shapes.Circle;
import buttons.AyushTextButton;
import buttons.ImageButton;
import other.Player;
import other.Screen;
import processing.core.PApplet;
import running.FBLATriviaTester;
import running.Question;
import test.Rectangle;

public class PsychoSearch extends Screen {

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
	private AyushTextButton quit2;
	private Circle animatedCircle;
	private String ca;
	private ArrayList<Question> answ, wrongans;
	private ArrayList<String> rightAnswers;
	private int index;
	private boolean bool;
	private FBLATriviaTester papp;
	private Question question;
	private boolean isRepeat;

	public PsychoSearch(ArrayList<String> as, String question, int seconds, Player p, int conf,
			ArrayList<Question> answer, ArrayList<Question> wronganswers, int index, FBLATriviaTester papp) {
		super(800,700);
		slide = 0;
		bool = false;
		qslidebuttons = new AyushTextButton[2];
		que = question;
		secondstimes60 = (seconds) * 60;
		qslidebuttons[0] = new AyushTextButton(50, 500, 200, 75, 75, 540, Color.BLACK, new Color(160, 160, 160),
				"Instructions", 25);
		qslidebuttons[1] = new AyushTextButton(550, 500, 200, 75, 575, 540, Color.BLACK, new Color(160, 160, 160),
				"Play!", 25);
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
		backtohome = new AyushTextButton(250, 500, 300, 100, 275, 550, Color.BLACK, new Color(160, 160, 160),
				"Back to Question", 30);
		player = p;
		this.conf = conf;
		isAddedYet = false;
		quit = new AyushTextButton(250, 500, 300, 100, 350, 565, Color.BLACK, new Color(160, 160, 160), "Quit", 40);
		quit2 = new AyushTextButton(700, 625, 100, 55, 715, 655, Color.black, new Color(160, 160, 160), "Quit", 20);
		animatedCircle = new Circle(400, 350, 200);
		animatedCircle.setFillColor(Color.BLACK);
		ca = as.get(0);
		this.index = index;
		answ = answer;
		wrongans = wronganswers;
		this.papp = papp;
		this.question = new Question(que, as.get(0), as.get(1), as.get(2), as.get(3));
	}

	public PsychoSearch(Question ques, int seconds, Player p, int conf, ArrayList<Question> answer,
			ArrayList<Question> wronganswers, ArrayList<String> rightAnswers, int index, FBLATriviaTester papp) {
		super(800,700);
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
		qslidebuttons[0] = new AyushTextButton(50, 500, 200, 75, 75, 540, Color.BLACK, new Color(160, 160, 160),
				"Instructions", 25);
		qslidebuttons[1] = new AyushTextButton(550, 500, 200, 75, 575, 540, Color.BLACK, new Color(160, 160, 160),
				"Play!", 25);
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
		backtohome = new AyushTextButton(250, 500, 300, 100, 275, 550, Color.BLACK, new Color(160, 160, 160),
				"Back to Question", 30);
		this.conf = conf;
		isAddedYet = false;
		quit = new AyushTextButton(250, 500, 300, 100, 350, 565, Color.BLACK, new Color(160, 160, 160), "Quit", 40);
		quit2 = new AyushTextButton(700, 625, 100, 55, 715, 655, Color.black, new Color(160, 160, 160), "Quit", 20);
		animatedCircle = new Circle(400, 350, 200);
		animatedCircle.setFillColor(Color.BLACK);
		ca = ques.getCorrect();
		this.index = index;
		answ = answer;
		wrongans = wronganswers;
		this.rightAnswers = rightAnswers;
		this.papp = papp;
		this.question = new Question(que, as.get(0), as.get(1), as.get(2), as.get(3));
		isRepeat = rightAnswers.contains(question.getQuestion());
	}

	public void setup() {
		for (int i = 0; i < numOfCoins; i++) {
			// coins.add(new ImageButton(loadImage("images\\psychosearch\\coinnw.png"),
			// (float)(Math.random()*740), (float)(Math.random()*640), 50,50));
		}
	}

	public void drawQuestion() {
		papp.textAlign(papp.BOTTOM, papp.LEFT);
		papp.background(38);
		papp.textSize(25);
		papp.fill(255);
		papp.text(que, 50, 100);
		qslidebuttons[0].draw(papp);
		qslidebuttons[1].draw(papp);
		animatedCircle.setX(animatedCircle.getX() + 15);
		if (animatedCircle.getX() > 900) {
			animatedCircle.setX(-100);
		}

		papp.fill(0);
		papp.ellipse(animatedCircle.getX(), animatedCircle.getY(), animatedCircle.getWidth(), animatedCircle.getHeight());
		quit2.draw(papp);

	}

	public void instructions() {
		papp.textAlign(papp.BOTTOM, papp.LEFT);
		papp.background(38);
		papp.textSize(60);
		papp.fill(255);
		papp.pushStyle();
		papp.textAlign(papp.CENTER);
		papp.text("Instructions", 400, 50);
		papp.popStyle();
		papp.textSize(30);
		papp.fill(0, 0, 255);
		papp.text("Use the arrow keys to move the flashlight to find \nthe correct answer button and click on it to win.",
				50, 125);
		backtohome.draw(papp);

	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		papp.pushStyle();
		papp.background(255);
		papp.textAlign(papp.BOTTOM, papp.LEFT);

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
		papp.popStyle();
		papp.popMatrix();

	}

	public void drawGame() {
		papp.textAlign(papp.BOTTOM, papp.LEFT);

		if (circradintro > radius) {
			papp.fill(0);
			papp.rect(0, 0, 800, 700);
			papp.fill(255);
			papp.ellipse(400, 350, circradintro * 2, circradintro * 2);
			circradintro -= 10;
		} else {
			drawActualGame();
		}
	}

	public void drawActualGame() {
		papp.textAlign(papp.BOTTOM, papp.LEFT);

		for (AyushTextButton e : locs) {
			e.draw(papp);
		}
		for (ImageButton e : coins) {
			e.draw(papp);
		}

		drawFast();

		papp.fill(0, 255, 255);
		papp.textSize(50);
		papp.text("Time: " + (secondstimes60 / 60 + 1), 275, 60);
		if (secondstimes60 < 0) {
			slide = 3;
		} else {
			secondstimes60--;

		}
		quit2.draw(papp);
	}

	public void win() {
		papp.fill(0);
		papp.rect(0, 0, 800, 700);
		papp.fill(0, 255, 0);
		papp.ellipse(x, y, radius * 2, radius * 2);
		if (radius < 1200) {
			radius += 15;
		} else {
			papp.textSize(50);
			papp.fill(0);
			papp.text("Congrats, you won!", 30, 100);
			papp.text("As you know, the answer was ", 30, 160);
			papp.fill(0, 125, 255);
			papp.text(ca, 200, 220);
			// text(money ,30,200);
			// player.passGame(conf);
			if (!isAddedYet) {
				if (!isRepeat)
					player.passGame(conf);
				isAddedYet = true;
				rightAnswers.add(question.getQuestion());
//				System.out.println(isRepeat);
			}
			quit.draw(papp);
		}

	}

	public void lose() {

		papp.fill(0);
		papp.rect(0, 0, 800, 700);
		papp.fill(255, 0, 0);
		papp.ellipse(x, y, radius * 2, radius * 2);
		if (radius < 1200) {
			radius += 15;
		} else {
			papp.textSize(50);
			papp.fill(0);
			papp.text("Oh no! You either hit the wrong \nanswer or ran out of time.", 30, 100);
			papp.text("The correct answer was ", 30, 240);
			papp.fill(0, 125, 255);
			papp.text(ca, 200, 300);
			// text(money ,30,200);
			// player.passGame(conf);

			quit.draw(papp);
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
		left.draw(papp, new Color(0, 0, 0));
		right.draw(papp, new Color(0, 0, 0));
		up.draw(papp, new Color(0, 0, 0));
		down.draw(papp, new Color(0, 0, 0));
		for (float px = circle.getX(); px < circle.getWidth() + circle.getX(); px++) {
			for (float py = circle.getY(); py < circle.getHeight() + circle.getY(); py++) {
				if (!isInCircle(px, py)) {
					papp.fill(0);
					papp.rect(px, py, 1, 1);
				}
			}
		}

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
		int mx = papp.mouseX;
		int my =papp. mouseY;

		if (slide == 0) {

			if (qslidebuttons[0].isPointInButton(mx, my)) {

				slide = 1;
				qslidebuttons[0].setBColor(new Color(160, 160, 160));
			} else if (qslidebuttons[1].isPointInButton(mx, my)) {
				slide = 2;
				qslidebuttons[1].setBColor(new Color(160, 160, 160));

			} else if (quit2.isPointInButton(mx, my)) {
				papp.setConfBack();
			}
		} else if (slide == 2) {

			if (locs.get(0).isPointInButton(mx, my)) {
				slide = 4;// win
			}

			if (quit2.isPointInButton(mx, my)) {
				papp.setConfBack();
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
				backtohome.setBColor(new Color(160, 160, 160));
			}
		} else if (slide == 3) {
			if (quit.isPointInButton(mx, my)) {
				papp.setConfBack();
			}
		} else if (slide == 4) {
			if (quit.isPointInButton(mx, my)) {
				papp.setConfBack();
			}
		}

	}

	public void mouseMoved() {

		int px = papp.mouseX;
		int py = papp.mouseY;
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
						e.setBColor(new Color(60, 60, 60));
					} else {
						e.setBColor(new Color(160, 160, 160));
					}

				}

				if (quit2.isPointInButton(px, py)) {
					quit2.setBColor(new Color(125, 125, 125));

				} else {
					quit2.setBColor(new Color(160, 160, 160));
				}
			}
		} else if (slide == 1) {
			if (backtohome.isPointInButton(px, py)) {
				backtohome.setBColor(new Color(60, 60, 60));
			} else {
				backtohome.setBColor(new Color(160, 160, 160));
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
		if (papp.keyCode == KeyEvent.VK_UP) {
			y -= 10;
		} else if (papp.keyCode == KeyEvent.VK_RIGHT) {
			x += 10;
		} else if (papp.keyCode == KeyEvent.VK_LEFT) {
			x -= 10;
		} else if (papp.keyCode == KeyEvent.VK_DOWN) {
			y += 10;
		}
		// update();
	}

	@Override
	public void mousePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased() {
		// TODO Auto-generated method stub
		
	}

}
