package games.flashlight;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import ayush.shapes.Circle;
import buttons.ImageButton;
import buttons.SButton;
import other.Player;
import other.Question;
import other.Screen;
import running.FBLATriviaTester;
import shapes.Rectangle;

/**
 * Subclass of Screen. Represents the drawing surface on which the Flashlight
 * game will occur
 */
public class Flashlight extends Screen {

	//
	private Player player;
	private ArrayList<ImageButton> coins;
	private ArrayList<String> answers;
	private int slide;
	private ArrayList<SButton> locs;
	private float x, y, radius;
	private final int numOfCoins;
	private int money;
	private int secondstimes60;
	private SButton[] qslidebuttons;
	private String que;
	public int circradintro;
	private SButton backtohome, quit;
	private int conf;
	private boolean isAddedYet;
	private SButton quit2;
	private Circle animatedCircle;
	private String ca;
	private ArrayList<Question> answ, wrongans;
	private ArrayList<String> rightAnswers;
	private int index;
	private boolean bool;
	private FBLATriviaTester papp;
	private Question question;
	private boolean isRepeat;

	/**
	 * Creates a new Flashlight object with the following parameters
	 * 
	 * @param as           the answers to the questions in the database
	 * @param question     the question this game will test the player on
	 * @param seconds      the general speed of the game, used to measure difficulty
	 * @param p            the player who will play this game
	 * @param conf         the conference/competition this game belongs to
	 * @param answer       the answers to this question
	 * @param wronganswers all of the player's incorrect answers from previous
	 *                     minigames
	 * @param index        this game's spot in the database, used to track progress
	 * @param papp         the PApplet this game will run in
	 */
	public Flashlight(ArrayList<String> as, String question, int seconds, Player p, int conf,
			ArrayList<Question> answer, ArrayList<Question> wronganswers, int index, FBLATriviaTester papp) {
		super(800, 700);
		slide = 0;
		bool = false;
		qslidebuttons = new SButton[2];
		que = question;
		secondstimes60 = (seconds) * 60;
		qslidebuttons[0] = new SButton("Instructions", 25, 1, 50, 500, 200, 75);
		qslidebuttons[1] = new SButton("Play", 25, 1, 550, 500, 200, 75);
		circradintro = 600;
		money = 0;
		answers = as;
		numOfCoins = 5;
		x = 400;
		y = 350;
		radius = 100;
		locs = new ArrayList<SButton>();
		for (String e : answers) {
			// Answers must be less than 100 pixels wide
			float topx = (float) (Math.random() * 600);
			float topy = (float) (Math.random() * 625);
			locs.add(new SButton(e, 15, 1, topx, topy, 150, 50));
		}
		coins = new ArrayList<ImageButton>();
		backtohome = new SButton("Back to question", 30, 1, 250, 500, 300, 100);
		player = p;
		this.conf = conf;
		isAddedYet = false;
		quit = new SButton("Quit", 40, 1, 250, 500, 300, 100);
		quit2 = new SButton("Quit", 20, 1, 675, 600, 100, 55);
		animatedCircle = new Circle(400, 350, 200);
		animatedCircle.setFillColor(Color.BLACK);
		ca = as.get(0);
		this.index = index;
		answ = answer;
		wrongans = wronganswers;
		this.papp = papp;
		this.question = new Question(que, as.get(0), as.get(1), as.get(2), as.get(3));
	}

	/**
	 * Creates a new Flashlight object with the following parameters
	 * 
	 * @param ques         the question this game will test the player on
	 * @param seconds      the general speed of the game, used to measure difficulty
	 * @param p            the player who will play this game
	 * @param conf         the conference/competition this game belongs to
	 * @param answer       the answers to this question
	 * @param wronganswers all the player's incorrect answers from previous
	 *                     minigames
	 * @param rightAnswers all the player's correct answers from previous minigames
	 * @param index        this game's spot in the database, used to track progress
	 * @param papp         the PApplet this game will run in
	 */
	public Flashlight(Question ques, int seconds, Player p, int conf, ArrayList<Question> answer,
			ArrayList<Question> wronganswers, ArrayList<String> rightAnswers, int index, FBLATriviaTester papp) {
		super(800, 700);
		player = p;
		bool = false;
		ArrayList<String> as = new ArrayList<String>();
		as.add(ques.getCorrect());
		as.add(ques.getWrong1());
		as.add(ques.getWrong2());
		as.add(ques.getWrong3());

		slide = 0;
		qslidebuttons = new SButton[2];
		que = ques.getQuestion();
		secondstimes60 = (seconds) * 60;
		qslidebuttons[0] = new SButton("Instructions", 25, 1, 50, 500, 200, 75);
		qslidebuttons[1] = new SButton("Play", 25, 1, 550, 500, 200, 75);
		circradintro = 600;
		money = 0;
		answers = as;
		numOfCoins = 5;
		x = 400;
		y = 350;
		radius = 100;
		locs = new ArrayList<SButton>();
		for (String e : answers) {
			// Answers must be less than 100 pixels wide
			float topx = (float) (Math.random() * 600);
			float topy = (float) (Math.random() * 625);
			locs.add(new SButton(e, 15, 1, topx, topy, 150, 50));
		}
		coins = new ArrayList<ImageButton>();
		backtohome = new SButton("Back to question", 30, 1, 250, 500, 300, 100);
		this.conf = conf;
		isAddedYet = false;
		quit = new SButton("Quit", 40, 1, 250, 500, 300, 100);
		quit2 = new SButton("Quit", 20, 1, 675, 600, 100, 55);
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

	/**
	 * [OBSOLETE FEATURE] Sets up images for coins
	 */
	public void setup() {
		for (int i = 0; i < numOfCoins; i++) {
			// coins.add(new ImageButton(loadImage("images\\psychosearch\\coinnw.png"),
			// (float)(Math.random()*740), (float)(Math.random()*640), 50,50));
		}
	}

	/**
	 * Draws the question at the start of the game
	 */
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
		papp.ellipse(animatedCircle.getX(), animatedCircle.getY(), animatedCircle.getWidth(),
				animatedCircle.getHeight());
		quit2.draw(papp);

	}

	/**
	 * Draws the instructions of the game when prompted (after clicking the
	 * "instructions" button)
	 */
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
		papp.text(
				"Use the arrow keys to move the flashlight to find \nthe correct answer button and click on it to win.",
				50, 125);
		backtohome.draw(papp);

	}

	/**
	 * Handles all GUI/output of this Flashlight game
	 */
	public void draw() {
		papp.pushStyle();
		papp.pushMatrix();
		papp.background(38);
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

	/**
	 * Draws starting animation
	 */
	public void drawGame() {
		papp.textAlign(papp.BOTTOM, papp.LEFT);

		if (circradintro > radius) {
			papp.fill(0);
			papp.rect(0, 0, 800, 700);
			papp.fill(38);
			papp.ellipse(400, 350, circradintro * 2, circradintro * 2);
			circradintro -= 10;
		} else {
			drawActualGame();
		}
	}

	/**
	 * Handles GUI/output for the actual gameplay part of this Flashlight game,
	 * after being called on by drawGame()
	 */
	public void drawActualGame() {
		papp.textAlign(papp.BOTTOM, papp.LEFT);

		for (SButton e : locs) {
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

	/**
	 * Handles win conditions, bumps up player's progress accordingly, and prompts
	 * to quit
	 */
	public void win() {
		papp.fill(0);
		papp.rect(0, 0, 800, 700);
		papp.fill(75, 175, 75);
		papp.ellipse(x, y, radius * 2, radius * 2);
		if (radius < 1200) {
			radius += 15;
		} else {
			papp.textSize(50);
			papp.fill(0);
			papp.text("Congrats, you won!", 30, 100);
			papp.text("As you know, the answer was ", 30, 160);
			papp.fill(0, 125, 255);
			papp.text(ca, 30, 220);
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

	/**
	 * Handles lose conditions, and prompts to quit
	 */
	public void lose() {

		papp.fill(0);
		papp.rect(0, 0, 800, 700);
		papp.fill(175, 75, 75);
		papp.ellipse(x, y, radius * 2, radius * 2);
		if (radius < 1200) {
			radius += 15;
		} else {
			papp.textSize(50);
			papp.fill(0);
			papp.text("Oh no! You either hit the wrong \nanswer or ran out of time.", 25, 100);
			papp.text("The correct answer was ", 25, 240);
			papp.fill(0, 125, 255);
			papp.text(ca, 30, 300);
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

	/**
	 * Draws/handles GUI and output for a faster version of this game
	 */
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

	/**
	 * @param xx the x-coordinate of the point
	 * @param yy the y-coordinate of the point
	 * @return true if the point (xx, yy) is inside the flashlight's lit area/field
	 *         of view
	 */
	public boolean isInCircle(float xx, float yy) {
		float xmath = Math.abs(xx - x) * Math.abs(xx - x);
		float ymath = Math.abs(yy - y) * Math.abs(yy - y);

		if (Math.sqrt(xmath + ymath) < radius) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Handles input in the form of quick mouse clicks
	 */
	public void mouseClicked() {
		int mx = papp.mouseX;
		int my = papp.mouseY;

		if (slide == 0) {

			if (qslidebuttons[0].isPointInside(mx, my)) {

				slide = 1;
				qslidebuttons[0].setColor(new Color(160, 160, 160));
			} else if (qslidebuttons[1].isPointInside(mx, my)) {
				slide = 2;
				qslidebuttons[1].setColor(new Color(160, 160, 160));

			} else if (quit2.isPointInside(mx, my)) {
				papp.setConfBack();
			}
		} else if (slide == 2) {

			if (locs.get(0).isPointInside(mx, my)) {
				slide = 4;// win
			}

			if (quit2.isPointInside(mx, my)) {
				papp.setConfBack();
			}

			for (int i = 1; i < locs.size(); i++) {
				if (locs.get(i).isPointInside(mx, my)) {
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
			if (backtohome.isPointInside(mx, my)) {
				slide = 0;
				backtohome.setColor(new Color(160, 160, 160));
			}
		} else if (slide == 3) {
			if (quit.isPointInside(mx, my)) {
				papp.setConfBack();
			}
		} else if (slide == 4) {
			if (quit.isPointInside(mx, my)) {
				papp.setConfBack();
			}
		}

	}

	/**
	 * Handles input in the form of any movement of the mouse
	 */
	public void mouseMoved() {

		int px = papp.mouseX;
		int py = papp.mouseY;
		Color col1 = new Color(0, 191, 255);
		Color col2 = new Color(41, 155, 149);
		Color col4 = new Color(96, 117, 150);
		Color col3 = new Color(55, 64, 79);
		if (slide == 2) {
			for (SButton e : locs) {
				if (e.isPointInside(px, py)) {
					e.setColor(new Color(0, 191, 255));
				} else {
					e.setColor(new Color(135, 206, 255));
				}
			}

			if (quit2.isPointInside(px, py)) {
				quit2.setColor(new Color(0, 191, 255));

			} else {
				quit2.setColor(new Color(135, 206, 255));
			}
		} else if (slide == 0) {
			if (slide == 0) {
				for (SButton e : qslidebuttons) {
					if (e.isPointInside(px, py)) {
						e.setColor(new Color(0, 191, 255));
					} else {
						e.setColor(new Color(135, 206, 255));
					}

				}

				if (quit2.isPointInside(px, py)) {
					quit2.setColor(new Color(135, 206, 255));

				} else {
					quit2.setColor(new Color(135, 206, 255));
				}
			}
		} else if (slide == 1) {
			if (backtohome.isPointInside(px, py)) {
				backtohome.setColor(new Color(0, 191, 255));
			} else {
				backtohome.setColor(new Color(135, 206, 255));
			}
		} else if (slide == 3) {
			if (quit.isPointInside(px, py)) {
				quit.setColor(col1);
			} else {
				quit.setColor(new Color(135, 206, 255));
			}
		} else if (slide == 4) {
			if (quit.isPointInside(px, py)) {
				quit.setColor(col1);
			} else {
				quit.setColor(new Color(135, 206, 255));
			}
		}

	}

	/**
	 * Handles all relevant keyboard-related input
	 */
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
		// Necessity from Screen
	}

	@Override
	public void mouseDragged() {
		// Necessity from Screen
	}

	@Override
	public void mouseReleased() {
		// Necessity from Screen
	}

	@Override
	public void keyReleased() {
		// Necessity from Screen
	}

}
