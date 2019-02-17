import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Space extends PApplet {
	private Question question;

	private PImage background, astronaut;
	private PFont font;

	private TextButton start;

	private Asteroid[] asteroids;
	public static final float[] randomVals = { 100, 250, 400, 550 };
	private boolean[] gone;

	private float playerX, playerY;
	private boolean up, down, left, right;
	private int timer, status; // 0 = running, 1 = lose, 2 = win, -1 = how to play
	private double speed;

	public Space(Question question) {
		this.question = question;
		start = new TextButton(50, 375, 105, 40, 70, 400, 255, 255, 255, 0, 0, 0, "START");

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
		speed = 1;
		timer = 0;
	}

	public void setup() {
		background = loadImage("Space-800x700.jpg");
		astronaut = loadImage("astronaut-clipart-png.png");
		font = createFont("Arial Bold", 18);
	}

	public void draw() {
		background(255);
		image(background, 0, 0, 800, 700);

		fill(255);
		textSize(25);
		textAlign(CENTER);
		textFont(font);

		if (status == -1) {
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
		} else if (status == 0) {
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			if (timer == 600) {
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
						asteroids[i].moveTo(asteroids[i].getX(), (float) (asteroids[i].getY() + speed));
				}

				if (asteroids[0].isEllipseInside(playerX + 25, playerY + 25, 50, 50))
					status = 2;

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
				text("Get Ready! Start in: " + ((int) 10 - timer / 60), width / 2, height / 2);
				timer++;
			}
		} else if (status == 1) {
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU LOSE!", width / 2, 50);
			textSize(15);
			text("Time's up. The correct answer is: " + question.getCorrect(), width / 2, 75);
		} else if (status == 2) {
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU WIN!", width / 2, 50);
			textSize(15);
			text("You guided the astronaut\nonto the correct asteroid!", width / 2, 75);
		}
	}

	public void mouseClicked() {
		if (status == -1 && start.isInBounds(mouseX, mouseY))
			status = 0;
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
