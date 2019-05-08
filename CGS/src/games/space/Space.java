package games.space;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import buttons.AyushTextButton;
import buttons.TextButton1;
import other.Player;
import other.Screen;
import processing.core.PFont;
import processing.core.PImage;
import running.FBLATriviaTester;
import running.Question;

public class Space extends Screen {
	private Player player;
	private int conference;

	private Question question;

	private PImage background, astronaut;
	private PFont font;

	private TextButton1 start, pause, quit;

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
	
	
	private AyushTextButton quitintro;
	private ArrayList<Question> answers, wrongAnswers;
	private ArrayList<String> rightAnswers;
	private int index;
	private FBLATriviaTester papp;
	private boolean bool;

	public Space(Question question, Player player, int conference, float speed, ArrayList<Question> answers,
			ArrayList<Question> wrongAnswers, ArrayList<String> rightAnswers, int index, FBLATriviaTester papp) {
		super(800,700);
		once = true;
		this.player = player;
		this.conference = conference;
		this.question = question;
		start = new TextButton1(50, 375, 105, 40, 70, 400, 255, 255, 255, 0, 0, 0, "START");
		pause = new TextButton1(0, 0, 100, 40, 15, 25, 255, 255, 255, 0, 0, 0, "PAUSE");
		quit = new TextButton1(275, 275, 240, 100, 390, 350, 255, 255, 255, 0, 0, 0, "QUIT");
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
		quitintro = new AyushTextButton(700, 625, 100, 55, 715, 655, Color.black, Color.white, "Quit", 20);

		bool = false;
	}

	
	public void setup() {
		background = papp.loadImage("images\\Space-800x700.jpg");
		astronaut = papp.loadImage("images\\astronaut-clipart-png.png");
		font = papp.createFont("Arial Bold", 18);
	}

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
			if (pause.isPointInButton(papp.mouseX, papp.mouseY))
				pause.setColor(200, 200, 200);
			else
				pause.setColor(255, 255, 255);

			papp.textAlign(papp.CENTER);
			papp.textSize(60);
			quit.draw(papp);
			if (quit.isPointInButton(papp.mouseX,papp.mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);
		} else if (status == -1) {
			papp.textSize(36);
			papp.text("SPACE EXPLORATION", super.DRAWING_WIDTH / 2, 50);
			papp.textSize(25);
			papp.text("How to Play", super.DRAWING_WIDTH / 2, 80);
			papp.textSize(20);
			papp.textAlign(papp.LEFT);
			papp.text("An astronaut is on a mission to explore an asteroid. As he approaches\nthe asteroid, the astronaut realizes there are four asteroids, each with\na different answer to your question. Help advance humanity by guiding\nthe astronaut onto the correct asteroid before they drift off the screen!",
					50, 125);
			papp.text("CONTROLS\nUse the arrow keys to navigate through space", 50, 300);

			papp.fill(0);
			start.draw(papp);
			quitintro.draw(papp);

			if (start.isPointInButton(papp.mouseX, papp.mouseY))
				start.setColor(200, 200, 200);
			else
				start.setColor(255, 255, 255);
		} else if (status == 0) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), super.DRAWING_WIDTH / 2, super.DRAWING_HEIGHT - 75);
			if (timer == 300) {
				papp.textAlign(papp.LEFT);
				pause.draw(papp);
				if (pause.isPointInButton(papp.mouseX, papp.mouseY))
					pause.setColor(200, 200, 200);
				else
					pause.setColor(255, 255, 255);
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
				papp.text("Get Ready! Start in: " + ((int) 5 - timer / 60), super.DRAWING_WIDTH / 2, super.DRAWING_WIDTH / 2);
				timer++;
			}
		} else if (status == 1) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), super.DRAWING_WIDTH / 2, super.DRAWING_HEIGHT - 75);
			papp.text("YOU LOSE!", super.DRAWING_WIDTH / 2, 50);
			papp.textSize(15);
			papp.text("Either time's up, or you landed on the\nwrong asteroid. The correct answer is: "
					+ question.getCorrect(), super.DRAWING_WIDTH / 2, 75);
			papp.textAlign(papp.CENTER);

			papp.textSize(60);
			quit.draw(papp);
			if (quit.isPointInButton(papp.mouseX, papp.mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);

			if (!bool) {
				bool = true;
				wrongAnswers.add(answers.get(index));
			}
		} else if (status == 2) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), super.DRAWING_WIDTH / 2, super.DRAWING_HEIGHT- 75);
			papp.text("YOU WIN!", super.DRAWING_WIDTH / 2, 50);
			papp.textSize(15);
			papp.text("You guided the astronaut\nonto the correct asteroid!", super.DRAWING_WIDTH / 2, 75);
			papp.textAlign(papp.CENTER);

			papp.textSize(60);
			quit.draw(papp);
			if (quit.isPointInButton(papp.mouseX, papp.mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);

			if(once) {
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

	public void mouseClicked() {
		if (status == -1 && start.isInBounds(papp.mouseX, papp.mouseY))
			status = 0;

		if (pause.isInBounds(papp.mouseX,papp.mouseY)) {
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

		if (quitintro.isPointInButton(papp.mouseX, papp.mouseY)) {
			papp.setConfBack();
		}

		if ((status == -2 || status == 1 || status == 2) && quit.isInBounds(papp.mouseX, papp.mouseY))
			papp.setConfBack();
	}

	public void mouseMoved() {
		if (quitintro.isPointInButton(papp.mouseX, papp.mouseY)) {
			quitintro.setBColor(new Color(125, 125, 125));
		} else {
			quitintro.setBColor(Color.white);
		}
	}

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
}