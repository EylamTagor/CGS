import processing.core.PApplet;

public class Space extends PApplet {
	private Player player;
	private Question question;

	private Asteroid[] asteroids;
	public static final float[] randomVals = { 100, 250, 400, 550 };
	private boolean[] gone;

	private float playerX, playerY;
	private boolean up, down, left, right;
	private int status; // 0 = running, -1 = lose, 1 = win

	public Space(Question question) {
		player = new Player();
		this.question = question;

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
		status = 0;
	}

	public void draw() {
		background(255);

		fill(0);
		textSize(20);
		textAlign(CENTER);
		text(question.getQuestion(), width / 2, height - 50);

		if (status == 0) {
			int gones = 0;
			for (boolean b : gone)
				if (b)
					gones++;

			if (gones == 4)
				status = -1;

			for (int i = 0; i < asteroids.length; i++) {
				asteroids[i].draw(this);

				if (asteroids[i].getY() < 0 || asteroids[i].getY() > height)
					gone[i] = true;

				if (asteroids[i].isTop())
					asteroids[i].moveTo(asteroids[i].getX(), (float) (asteroids[i].getY() + 1.5));
				else
					asteroids[i].moveTo(asteroids[i].getX(), (float) (asteroids[i].getY() - 1.5));
			}

			if (asteroids[0].isEllipseInside(playerX, playerY, 50, 50))
				status = 1;

			fill(125, 50, 200);
			ellipseMode(CENTER);
			ellipse(playerX, playerY, 50, 50);

			if (up && playerY > 25)
				playerY -= 5;
			if (down && playerY < 640)
				playerY += 5;
			if (left && playerX > 25)
				playerX -= 5;
			if (right && playerX < 770)
				playerX += 5;
		} else if (status == -1)
			question.setQuestion("YOU LOSE!");
		else if (status == 1)
			question.setQuestion("YOU WIN!");
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
