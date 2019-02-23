package games.space;

import javax.swing.JFrame;

import buttons1.TextButton1;
import general.Player;
import general.Question;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Space extends PApplet {
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

	private JFrame window;

	public Space(Question question, Player player, int conference, float speed) {
		this.player = player;
		this.conference = conference;
		this.question = question;
		start = new TextButton1(50, 375, 105, 40, 70, 400, 255, 255, 255, 0, 0, 0, "START");
		pause = new TextButton1(0, 0, 100, 40, 15, 25, 255, 255, 255, 0, 0, 0, "PAUSE");
		quit = new TextButton1(275, 275, 240, 100, 390, 350, 255, 255, 255, 0, 0, 0, "QUIT");

		asteroids = new Asteroid[4];

		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid(question, i, 0, randomVals[(int) (Math.random() * 4)]);
		}

		boolean[] taken = new boolean[4];
		int count = 0;
		while (!taken[0] || !taken[1] || !taken[2] || !taken[3]) {
			int index = (int) (Math.random() * 4);
			if (!taken[index]) {
				asteroids[index].moveTo(200 * count + 100, asteroids[index].getY());
				taken[index] = true;
				count++;
			}
		}

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
	}

	public void setFrame(JFrame win) {
		window = win;
	}

	public void setup() {
		background = loadImage("images\\Space-800x700.jpg");
		astronaut = loadImage("images\\astronaut-clipart-png.png");
		font = createFont("Arial Bold", 18);
	}

	public void draw() {
		background(255);
		image(background, 0, 0, 800, 700);

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
			text("SPACE EXPLORATION", width / 2, 50);
			textSize(25);
			text("How to Play", width / 2, 80);
			textSize(20);
			textAlign(LEFT);
			text("An astronaut is on a mission to explore an asteroid. As he approaches\nthe asteroid, the astronaut realizes there are four asteroids, each with\na different answer to your question. Help advance humanity by guiding\nthe astronaut onto the correct asteroid before they drift off the screen!",
					50, 125);
			text("CONTROLS\nUse the arrow keys to navigate through space", 50, 300);

			fill(0);
			start.draw(this);

			if (start.isPointInButton(mouseX, mouseY))
				start.setColor(200, 200, 200);
			else
				start.setColor(255, 255, 255);
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
				for (boolean b : gone)
					if (b)
						gones++;

				if (gones == 4)
					status = 1;

				for (int i = 0; i < asteroids.length; i++) {
					asteroids[i].draw(this);

					if (asteroids[i].getY() < 0 || asteroids[i].getY() > height)
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

				image(astronaut, playerX, playerY, 50, 50);

				if (up && playerY > 0)
					playerY -= 7.5;
				if (down && playerY < 625)
					playerY += 7.5;
				if (left && playerX > 0)
					playerX -= 7.5;
				if (right && playerX < 745)
					playerX += 7.5;
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
			text("Either time's up, or you landed on the\nwrong asteroid. The correct answer is: "
					+ question.getCorrect(), width / 2, 75);
			textAlign(CENTER);

			textSize(60);
			quit.draw(this);
			if (quit.isPointInButton(mouseX, mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);
		} else if (status == 2) {
			textSize(20);
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU WIN!", width / 2, 50);
			textSize(15);
			text("You guided the astronaut\nonto the correct asteroid!", width / 2, 75);
			textAlign(CENTER);

			textSize(60);
			quit.draw(this);
			if (quit.isPointInButton(mouseX, mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);

			noLoop();
			player.passGame(conference);
		}
	}

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

		if ((status == -2 || status == 1 || status == 2) && quit.isInBounds(mouseX, mouseY))
			window.dispose();
	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP)
				up = true;
			if (keyCode == DOWN)
				down = true;
			if (keyCode == LEFT)
				left = true;
			if (keyCode == RIGHT)
				right = true;

			if (keyCode == ESC)
				window.dispose();
		}
	}

	public void keyReleased() {
		if (key == CODED) {
			if (keyCode == UP)
				up = false;
			if (keyCode == DOWN)
				down = false;
			if (keyCode == LEFT)
				left = false;
			if (keyCode == RIGHT)
				right = false;
		}
	}
}