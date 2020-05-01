package games.space;

import java.awt.Color;
import java.util.ArrayList;

import buttons.SButton;
import other.Player;
import other.Question;
import other.Screen;
import processing.core.PFont;
import processing.core.PImage;
import running.FBLATriviaTester;

/**
 * Subclass of Screen. Represents the drawing surface on which the Space game
 * will occur and therefore handles that game's IO.
 */
public class Space extends Screen {
	private Player player;
	private int conference;

	private Question question;

	private PImage background, astronaut;
	private PFont font;

	private SButton start, pause, quit;

	private Asteroid[] asteroids;
	public static final float[] randomVals = { 100, 250, 400, 550 };
	private boolean[] gone;

	private float playerX, playerY;
	private boolean up, down, left, right;
	private int timer, status; // 0 = running, 1 = lose, 2 = win, -1 = how to play, -2 = pause
	private double speed;
	private boolean once;

	private int width;
	private int height;

	private SButton quitintro;
	private ArrayList<Question> answers, wrongAnswers;
	private ArrayList<String> rightAnswers;
	private int index;
	private FBLATriviaTester papp;
	private boolean bool;

	/**
	 * Creates a new Space object with the following parameters
	 * 
	 * @param question     the question this game will test the player on
	 * @param player       the player who will play this game
	 * @param conference   the conference/competition this game belongs to
	 * @param speed        the general speed of the game, used to measure difficulty
	 * @param answers      the answers to the question of this game
	 * @param wrongAnswers all the player's incorrect answers from previous
	 *                     minigames
	 * @param rightAnswers all the player's correct answers from previous minigames
	 * @param index        this game's spot in the database, used to track progress
	 * @param papp         the PApplet this game will run in
	 */
	public Space(Question question, Player player, int conference, float speed, ArrayList<Question> answers,
			ArrayList<Question> wrongAnswers, ArrayList<String> rightAnswers, int index, FBLATriviaTester papp) {
		super(800, 700);
		once = true;
		this.player = player;
		this.conference = conference;
		this.question = question;
		start = new SButton("START", 25, 1, 50, 375, 105, 40);
		pause = new SButton("PAUSE", 25, 1, 0, 0, 100, 40);
		quit = new SButton("QUIT", 25, 1, 275, 275, 240, 100);
		this.papp = papp;
		asteroids = new Asteroid[4];
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid(question, i, 0, randomVals[(int) (Math.random() * 4)]);
		}

		boolean[] taken = new boolean[4];
		int count = 0;
		while (!taken[0] || !taken[1] || !taken[2] || !taken[3]) {
			int ind = (int) (Math.random() * 4);
			if (!taken[ind]) {
				asteroids[ind].moveTo(200 * count + 100, asteroids[ind].getY());
				taken[ind] = true;
				count++;
			}
		}

		height = super.DRAWING_HEIGHT;
		width = super.DRAWING_WIDTH;

		playerX = 400;
		playerY = 350;

		up = false;
		down = false;
		left = false;
		right = false;
		gone = new boolean[4];
		status = -1;
		this.speed = speed;
		timer = 0;

		this.answers = answers;
		this.wrongAnswers = wrongAnswers;
		this.rightAnswers = rightAnswers;
		this.index = index;
		quitintro = new SButton("Quit", 20, 1, 675, 600, 100, 55);

		bool = false;
	}

	/**
	 * Sets up images for the background and the player's astronaut, and sets up the
	 * font type for text.
	 */
	public void setup() {
		background = papp.loadImage("images\\Space-800x700.jpg");
		astronaut = papp.loadImage("images\\astronaut-clipart-png.png");
		font = papp.createFont("Arial Bold", 18);
	}

	/**
	 * Draws the game on the PApplet, and therefore handles practically all of GUI
	 * and outputs of this game.
	 */
	public void draw() {

		papp.pushStyle();
		papp.pushMatrix();
		papp.background(255);
		papp.image(background, 0, 0, 800, 700);

		papp.textFont(font);
		papp.textAlign(papp.CENTER);
		papp.textSize(25);
		papp.fill(255);

		if (status == -2) {
			papp.textAlign(papp.LEFT);
			papp.textSize(20);
			pause.draw(papp);
			if (pause.isPointInside(papp.mouseX, papp.mouseY))
				pause.setColor(new Color(0, 191, 255));
			else
				pause.setColor(new Color(135, 206, 255));

			papp.textAlign(papp.CENTER);
			papp.textSize(60);
			quit.draw(papp);
			if (quit.isPointInside(papp.mouseX, papp.mouseY))
				quit.setColor(new Color(0, 191, 255));
			else
				quit.setColor(new Color(135, 206, 255));
		} else if (status == -1) {
			papp.textSize(36);
			papp.text("SPACE EXPLORATION", super.DRAWING_WIDTH / 2, 50);
			papp.textSize(20);
			papp.textAlign(papp.LEFT);
			papp.text(
					"An astronaut is on a mission to explore an asteroid. As he approaches\nthe asteroid, the astronaut realizes there are four asteroids, each with\na different answer to your question. Help advance humanity by guiding\nthe astronaut onto the correct asteroid before they drift off the screen!",
					50, 125);
			papp.text("CONTROLS\nUse the arrow keys to navigate through space", 50, 300);

			papp.fill(0);
			start.draw(papp);
			quitintro.draw(papp);

			if (start.isPointInside(papp.mouseX, papp.mouseY))
				start.setColor(new Color(0, 191, 255));
			else
				start.setColor(new Color(135, 206, 255));
		} else if (status == 0) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), super.DRAWING_WIDTH / 2, super.DRAWING_HEIGHT - 75);
			if (timer == 300) {
				papp.textAlign(papp.LEFT);
				pause.draw(papp);
				if (pause.isPointInside(papp.mouseX, papp.mouseY))
					pause.setColor(new Color(0, 191, 255));
				else
					pause.setColor(new Color(135, 206, 255));
				papp.textAlign(papp.CENTER);

				int gones = 0;
				for (boolean b : gone)
					if (b)
						gones++;

				if (gones == 4)
					status = 1;

				for (int i = 0; i < asteroids.length; i++) {
					asteroids[i].draw(papp);

					if (asteroids[i].getY() < 0 || asteroids[i].getY() > super.DRAWING_HEIGHT)
						gone[i] = true;

					if (asteroids[i].isTop())
						asteroids[i].moveTo(asteroids[i].getX(), (float) (asteroids[i].getY() + speed));
					else
						asteroids[i].moveTo(asteroids[i].getX(), (float) (asteroids[i].getY() - speed));
				}

				if (asteroids[0].isEllipseInside(playerX + 25, playerY + 25, 50, 50))
					status = 2;

				for (int i = 1; i < asteroids.length; i++) {
					if (asteroids[i].isEllipseInside(playerX + 25, playerY + 25, 50, 50))
						status = 1;
				}

				papp.image(astronaut, playerX, playerY, 50, 50);

				if (up && playerY > 0)
					playerY -= 7.5;
				if (down && playerY < 625)
					playerY += 7.5;
				if (left && playerX > 0)
					playerX -= 7.5;
				if (right && playerX < 745)
					playerX += 7.5;
			} else {
				papp.textSize(36);
				papp.text("Get Ready! Start in: " + ((int) 5 - timer / 60), super.DRAWING_WIDTH / 2,
						super.DRAWING_WIDTH / 2);
				timer++;
			}
		} else if (status == 1) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), super.DRAWING_WIDTH / 2, super.DRAWING_HEIGHT - 75);
			papp.textSize(40);
			papp.text("YOU LOSE!", super.DRAWING_WIDTH / 2, 50);
			papp.textSize(25);
			papp.text("Either time's up, or you landed on the\nwrong asteroid. The correct answer is: \n"
					+ question.getCorrect(), super.DRAWING_WIDTH / 2, 100);
			papp.textAlign(papp.CENTER);

			papp.textSize(60);
			quit.draw(papp);
			if (quit.isPointInside(papp.mouseX, papp.mouseY))
				quit.setColor(new Color(0, 191, 255));
			else
				quit.setColor(new Color(135, 206, 255));

			if (!bool) {
				bool = true;
				wrongAnswers.add(answers.get(index));
			}
		} else if (status == 2) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), super.DRAWING_WIDTH / 2, super.DRAWING_HEIGHT - 75);
			papp.textSize(40);
			papp.text("YOU WIN!", super.DRAWING_WIDTH / 2, 50);
			papp.textSize(35);
			papp.text("You guided the astronaut\nonto the correct asteroid!", super.DRAWING_WIDTH / 2, 100);
			papp.textAlign(papp.CENTER);

			papp.textSize(60);
			quit.draw(papp);
			if (quit.isPointInside(papp.mouseX, papp.mouseY))
				quit.setColor(new Color(0, 191, 255));
			else
				quit.setColor(new Color(135, 206, 255));

			if (once) {
				if (!rightAnswers.contains(question.getQuestion())) {
					player.passGame(conference);
				}

				rightAnswers.add(question.getQuestion());
				once = false;
			}

		}

		papp.popStyle();
		papp.popMatrix();
	}

	/**
	 * Handles input in the form of a quick mouse click
	 */
	public void mouseClicked() {
		if (status == -1 && start.isPointInside(papp.mouseX, papp.mouseY))
			status = 0;

		if (pause.isPointInside(papp.mouseX, papp.mouseY)) {
			if (status == 0 && timer == 300) {
				status = -2;
				pause.setName("RESUME");
				pause.setWidth(115);
			} else if (status == -2) {
				status = 0;
				pause.setName("PAUSE");
				pause.setWidth(100);
			}
		}

		if (quitintro.isPointInside(papp.mouseX, papp.mouseY)) {
			papp.setConfBack();
		}

		if ((status == -2 || status == 1 || status == 2) && quit.isPointInside(papp.mouseX, papp.mouseY))
			papp.setConfBack();
	}

	/**
	 * Handles input in the form of any mouse movement
	 */
	public void mouseMoved() {
		if (quitintro.isPointInside(papp.mouseX, papp.mouseY)) {
			quitintro.setColor(new Color(0, 191, 255));
		} else {
			quitintro.setColor(new Color(135, 206, 255));
		}
	}

	/**
	 * Handles all relevant keyboard-related input
	 */
	public void keyPressed() {
		if (papp.key == papp.CODED) {
			if (papp.keyCode == papp.UP)
				up = true;
			if (papp.keyCode == papp.DOWN)
				down = true;
			if (papp.keyCode == papp.LEFT)
				left = true;
			if (papp.keyCode == papp.RIGHT)
				right = true;

			if (papp.keyCode == papp.ESC)
				papp.setConfBack();
		}
	}

	public void keyReleased() {
		if (papp.key == papp.CODED) {
			if (papp.keyCode == papp.UP)
				up = false;
			if (papp.keyCode == papp.DOWN)
				down = false;
			if (papp.keyCode == papp.LEFT)
				left = false;
			if (papp.keyCode == papp.RIGHT)
				right = false;
		}
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
}