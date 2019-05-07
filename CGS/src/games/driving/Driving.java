package games.driving;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

import buttons.AyushTextButton;
import buttons.TextButton1;
import other.Player;
import other.Question;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Subclass of PApplet. Represents the drawing surface on which the Driving game
 * will occur.
 */
public class Driving extends PApplet {
	private Player player;
	private int conference;

	private Question question;
	private ArrayList<FuelTank> fuel;
	private ArrayList<Obstacle> obstacles;
	private boolean[] gone;

	private PImage car;
	private PFont font;

	private TextButton1 start, pause, quit;

	private int lane;
	private double speed;

	private int timer, status; // 0 = running, 1 = hit wrong fuel, 2 = win, 3 = ran out of time, 4 = hit
								// obstacle, -1 = how to play, -2 = pause

	private JFrame window;
	private ArrayList<Question> answers, wrongAnswers;
	private ArrayList<String> rightAnswers;
	private int index;
	private AyushTextButton quitintro;
	private boolean bool;

	/**
	 * Creates a new Driving object with the following parameters
	 * 
	 * @param question     the Question that this instance of the game will text the
	 *                     player on
	 * @param player       the player of the game
	 * @param conference   the conference/competition this game belongs to
	 * @param speed        the speed of the game, used to control difficulty
	 * @param answers      the answers to the question of this game
	 * @param wrongAnswers all of the player's incorrect answers throughout the
	 *                     whole game so far
	 * @param rightAnswers all of the player's correct answers throughout the whole
	 *                     game so far
	 * @param index        the spot of this game on the question database, used to
	 *                     track progress
	 */
	public Driving(Question question, Player player, int conference, float speed, ArrayList<Question> answers,
			ArrayList<Question> wrongAnswers, ArrayList<String> rightAnswers, int index) {
		this.player = player;
		this.conference = conference;

		this.question = question;
		start = new TextButton1(50, 375, 105, 40, 70, 400, 75, 175, 75, 255, 255, 255, "START");
		pause = new TextButton1(0, 0, 100, 40, 15, 25, 255, 255, 255, 0, 0, 0, "PAUSE");
		quit = new TextButton1(275, 275, 240, 100, 390, 350, 255, 255, 255, 0, 0, 0, "QUIT");

		fuel = new ArrayList<FuelTank>();
		obstacles = new ArrayList<Obstacle>();
		gone = new boolean[4];

		ArrayList<Integer> takenCue = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3)),
				takenLane = (ArrayList<Integer>) takenCue.clone();

		for (int i = 0; i < 4; i++) {
			fuel.add(new FuelTank(question, i, takenLane.remove((int) (Math.random() * takenLane.size())),
					takenCue.remove((int) (Math.random() * takenCue.size()))));

			int obstacleLane = (int) (Math.random() * 4);
			if (obstacleLane != fuel.get(i).getLane())
				obstacles.add(new Obstacle(obstacleLane, fuel.get(i).getCue()));
		}

		status = -1;
		this.speed = speed;
		lane = 0;
		timer = 0;

		this.answers = answers;
		this.wrongAnswers = wrongAnswers;
		this.rightAnswers = rightAnswers;
		this.index = index;
		quitintro = new AyushTextButton(700, 625, 100, 55, 715, 655, Color.black, Color.white, "Quit", 20);

		bool = false;
	}

	/**
	 * Sets the JFrame window this game will run in
	 * 
	 * @param win the new JFrame window
	 */
	public void setFrame(JFrame win) {
		window = win;
	}

	/**
	 * Sets the font type for text and the image for the player's car
	 */
	public void setup() {
		font = createFont("Arial Bold", 18);
		car = loadImage("images\\car.png");
	}

	/**
	 * Runs the GUI of the Driving game. Manages all output for this particular
	 * game.
	 */
	public void draw() {
		background(125);

		textFont(font);
		textAlign(CENTER);
		textSize(25);
		fill(255);

		if (status == -2) {
			textAlign(LEFT);
			textSize(20);
			pause.draw(this);
			if (pause.isPointInButton(mouseX, mouseY))
				pause.setColor(200, 200, 200);
			else
				pause.setColor(255, 255, 255);

			textAlign(CENTER);
			textSize(60);
			quit.draw(this);
			if (quit.isPointInButton(mouseX, mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);
		} else if (status == -1) {
			textSize(36);
			text("EXPERT DRIVING", width / 2, 50);
			textSize(25);
			text("How to Play", width / 2, 80);
			textSize(20);
			textAlign(LEFT);
			text("You're about to be late to work, and your fuel is almost gone! On your\nway, you must collect the fuel tanks with the correct answers. Be careful \nnot to hit obstacles or collect fuel tanks with incorrect answers!",
					50, 125);
			text("CONTROLS\nUse the left and right arrow keys to switch lanes", 50, 300);

			fill(0);
			noStroke();
			start.draw(this);
			if (start.isPointInButton(mouseX, mouseY))
				start.setColor(50, 150, 50);
			else
				start.setColor(75, 175, 75);

			quitintro.draw(this);
		} else if (status == 0) {
			textSize(20);
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);

			if (timer == 300) {
				textAlign(LEFT);
				pause.draw(this);
				if (pause.isPointInButton(mouseX, mouseY))
					pause.setColor(200, 200, 200);
				else
					pause.setColor(255, 255, 255);

				textAlign(CENTER);

				int gones = 0;

				for (boolean i : gone)
					if (i)
						gones++;
				if (gones == 4)
					status = 3;

				strokeWeight(8);
				stroke(0);
				line(0, 125, width, 125);
				line(0, 525, width, 525);

				strokeWeight(5);
				stroke(244, 226, 66);
				for (int i = 2; i <= 4; i++)
					line(0, 100 * i + 25, width, 100 * i + 25);
				noStroke();

				for (FuelTank tank : fuel) {
					tank.draw(this);

					if (tank.getX() > -250)
						tank.move(speed);
					else
						gone[fuel.indexOf(tank)] = true;

					if (tank.getLane() == lane && (tank.isPointInside(25) || tank.isPointInside(100)))
						status = 1;
				}

				for (Obstacle o : obstacles) {
					o.draw(this);

					if (o.getX() > -250)
						o.move(speed);

					if (o.getLane() == lane && (o.isPointInside(25) || o.isPointInside(100)))
						status = 4;
				}

				fill(200, 50, 50);
				image(car, 25, 150 + lane * 100, 75, 50);

				if (fuel.get(0).getLane() == lane && (fuel.get(0).isPointInside(25) || fuel.get(0).isPointInside(100)))
					status = 2;
			} else {
				textSize(36);
				text("Get Ready! Start in: " + ((int) 5 - timer / 60), width / 2, height / 2);
				timer++;
			}
		} else if (status == 1) {
			textSize(20);
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU LOSE!", width / 2, 50);
			textSize(15);
			text("You collected the wrong fuel tank. The correct answer is: " + question.getCorrect(), width / 2, 75);

			textSize(60);
			quit.draw(this);
			if (quit.isPointInButton(mouseX, mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);

			if (!bool) {
				bool = true;
				wrongAnswers.add(answers.get(index));
			}
		} else if (status == 2) {
			textSize(20);
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU WIN!", width / 2, 50);
			textSize(15);
			text("You collected the right fuel tank!", width / 2, 75);

			textSize(60);
			quit.draw(this);
			if (quit.isPointInButton(mouseX, mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);

			noLoop();
			if (!rightAnswers.contains(question.getQuestion())) {
				player.passGame(conference);
			}

			rightAnswers.add(question.getQuestion());
		} else if (status == 3) {
			textSize(20);
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU LOSE!", width / 2, 50);
			textSize(15);
			text("You were too slow, and missed all the fuel tanks!", width / 2, 75);

			textSize(60);
			quit.draw(this);

			if (bool) {
				bool = true;
				wrongAnswers.add(answers.get(index));
			}
		} else if (status == 4) {
			textSize(20);
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU LOSE!", width / 2, 50);
			textSize(15);
			text("You crashed into an obstacle!", width / 2, 75);

			textSize(60);
			quit.draw(this);

			if (bool) {
				bool = true;
				wrongAnswers.add(answers.get(index));
			}
		}
	}

	/**
	 * Handles input in the form of clicking the mouse.
	 */
	public void mouseClicked() {
		if (status == -1 && start.isInBounds(mouseX, mouseY))
			status = 0;

		if (pause.isInBounds(mouseX, mouseY)) {
			if (status == 0 && timer == 300) {
				status = -2;
				pause.setText("RESUME");
				pause.setWidth(115);
			} else if (status == -2) {
				status = 0;
				pause.setText("PAUSE");
				pause.setWidth(100);
			}
		}

		if ((status == -2 || status == 1 || status == 2 || status == 3 || status == 4)
				&& quit.isInBounds(mouseX, mouseY))
			window.dispose();

		if (quitintro.isPointInButton(mouseX, mouseY)) {
			window.dispose();
		}
	}

	/**
	 * Handles input in the form of mouse movement.
	 */
	public void mouseMoved() {
		if (quitintro.isPointInButton(mouseX, mouseY)) {
			quitintro.setBColor(new Color(79, 79, 79));
		} else {
			quitintro.setBColor(Color.WHITE);
		}
	}

	/**
	 * Handles input in the form of keyboard presses.
	 */
	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP && lane > 0)
				lane--;
			if (keyCode == DOWN && lane < 3)
				lane++;
		}
	}
}