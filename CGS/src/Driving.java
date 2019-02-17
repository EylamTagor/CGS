import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Driving extends PApplet {
	private Question question;
	private ArrayList<FuelTank> fuel;
	private ArrayList<Obstacle> obstacles;
	private boolean[] gone;

	private PImage car;
	private PFont font;

	private TextButton start;

	private int lane;
	private double speed;

	private int timer, status; // 0 = running, 1 = hit wrong fuel, 2 = win, 3 = ran out of time, 4 = hit
								// obstacle, -1 = how to play

	public Driving(Question question) {
		this.question = question;
		start = new TextButton(50, 375, 105, 40, 70, 400, 75, 175, 75, 255, 255, 255, "START");
		fuel = new ArrayList<FuelTank>();
		obstacles = new ArrayList<Obstacle>();
		gone = new boolean[4];

		ArrayList<Integer> takenCue = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3)),
				takenLane = (ArrayList<Integer>) takenCue.clone();

		for (int i = 0; i < 4; i++) {
			fuel.add(new FuelTank(question, i, (int) (Math.random() * 4),
					takenCue.remove((int) (Math.random() * takenCue.size()))));

			int obstacleLane = (int) (Math.random() * 4);
			if (obstacleLane != fuel.get(i).getLane())
				obstacles.add(new Obstacle(obstacleLane, fuel.get(i).getCue()));
		}

		status = -1;
		speed = 5;
		lane = 0;
		timer = 0;
	}

	public void setup() {
		font = createFont("Arial Bold", 18);
		car = loadImage("car.png");
	}

	public void draw() {
		background(125);
		fill(255);
		textSize(25);
		textAlign(CENTER);
		textFont(font);

		if (status == -1) {
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
		} else if (status == 0) {
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);

			if (timer == 300) {
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
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU LOSE!", width / 2, 50);
			textSize(15);
			text("You collected the wrong fuel tank. The correct answer is: " + question.getCorrect(), width / 2, 75);
		} else if (status == 2) {
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU WIN!", width / 2, 50);
			textSize(15);
			text("You collected the right fuel tank!", width / 2, 75);
		} else if (status == 3) {
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU LOSE!", width / 2, 50);
			textSize(15);
			text("You were too slow, and missed all the fuel tanks!", width / 2, 75);
		} else if (status == 4) {
			text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			text("YOU LOSE!", width / 2, 50);
			textSize(15);
			text("You crashed into an obstacle!", width / 2, 75);
		}
	}

	public void mouseClicked() {
		if (status == -1 && start.isInBounds(mouseX, mouseY))
			status = 0;
	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP && lane > 0)
				lane--;
			if (keyCode == DOWN && lane < 3)
				lane++;
		}
	}
}
