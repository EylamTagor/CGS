package games.driving;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

import buttons.AyushTextButton;
import buttons.TextButton1;
import other.Player;
import other.Screen;
import processing.core.PFont;
import processing.core.PImage;
import running.FBLATriviaTester;
import running.Question;

public class Driving extends Screen {
	private Player player;
	private int conference;

	private Question question;
	private ArrayList<FuelTank> fuel;
	private ArrayList<Obstacle> obstacles;
	private boolean[] gone;

	private PImage car;
	private PFont font;

	private TextButton1 start, pause, quit;

	private int width, height;
	
	private int lane;
	private double speed;

	private int timer, status; // 0 = running, 1 = hit wrong fuel, 2 = win, 3 = ran out of time, 4 = hit
								// obstacle, -1 = how to play, -2 = pause
	private FBLATriviaTester papp;
	private ArrayList<Question> answers, wrongAnswers;
	private ArrayList<String> rightAnswers;
	private int index;
	private AyushTextButton quitintro;
	private boolean bool;
	private boolean once;

	public Driving(Question question, Player player, int conference, float speed, ArrayList<Question> answers,
			ArrayList<Question> wrongAnswers, ArrayList<String> rightAnswers, int index, FBLATriviaTester papp) {
		super(800,700);
		this.player = player;
		this.conference = conference;
		this.papp = papp;
		this.question = question;
		start = new TextButton1(50, 375, 105, 40, 70, 400, 75, 175, 75, 255, 255, 255, "START");
		pause = new TextButton1(0, 0, 100, 40, 15, 25, 255, 255, 255, 0, 0, 0, "PAUSE");
		quit = new TextButton1(275, 275, 240, 100, 390, 350, 255, 255, 255, 0, 0, 0, "QUIT");

		width = super.DRAWING_WIDTH;
		height = super.DRAWING_HEIGHT;
		once = true;
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

	

	public void setup() {
		font = papp.createFont("Arial Bold", 18);
		car = papp.loadImage("images\\car.png");
	}

	public void draw() {
		
		papp.pushStyle();
		papp.pushMatrix();
		papp.background(125);

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
			papp.text("EXPERT DRIVING", papp.width / 2, 50);
			papp.textSize(25);
			papp.text("How to Play", width / 2, 80);
			papp.textSize(20);
			papp.textAlign(papp.LEFT);
			papp.text("You're about to be late to work, and your fuel is almost gone! On your\nway, you must collect the fuel tanks with the correct answers. Be careful \nnot to hit obstacles or collect fuel tanks with incorrect answers!",
					50, 125);
			papp.text("CONTROLS\nUse the left and right arrow keys to switch lanes", 50, 300);

			papp.fill(0);
			papp.noStroke();
			start.draw(papp);
			if (start.isPointInButton(papp.mouseX, papp.mouseY))
				start.setColor(50, 150, 50);
			else
				start.setColor(75, 175, 75);

			quitintro.draw(papp);
		} else if (status == 0) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), width / 2, height - 75);

			if (timer == 300) {
				papp.textAlign(papp.LEFT);
				pause.draw(papp);
				if (pause.isPointInButton(papp.mouseX, papp.mouseY))
					pause.setColor(200, 200, 200);
				else
					pause.setColor(255, 255, 255);

				papp.textAlign(papp.CENTER);

				int gones = 0;

				for (boolean i : gone)
					if (i)
						gones++;
				if (gones == 4)
					status = 3;

				papp.strokeWeight(8);
				papp.stroke(0);
				papp.line(0, 125, width, 125);
				papp.line(0, 525, width, 525);

				papp.strokeWeight(5);
				papp.stroke(244, 226, 66);
				for (int i = 2; i <= 4; i++)
					papp.line(0, 100 * i + 25, width, 100 * i + 25);
				papp.noStroke();

				for (FuelTank tank : fuel) {
					tank.draw(papp);

					if (tank.getX() > -250)
						tank.move(speed);
					else
						gone[fuel.indexOf(tank)] = true;

					if (tank.getLane() == lane && (tank.isPointInside(25) || tank.isPointInside(100)))
						status = 1;
				}

				for (Obstacle o : obstacles) {
					o.draw(papp);

					if (o.getX() > -250)
						o.move(speed);

					if (o.getLane() == lane && (o.isPointInside(25) || o.isPointInside(100)))
						status = 4;
				}

				papp.fill(200, 50, 50);
				papp.image(car, 25, 150 + lane * 100, 75, 50);

				if (fuel.get(0).getLane() == lane && (fuel.get(0).isPointInside(25) || fuel.get(0).isPointInside(100)))
					status = 2;
			} else {
				papp.textSize(36);
				papp.text("Get Ready! Start in: " + ((int) 5 - timer / 60), width / 2, height / 2);
				timer++;
			}
		} else if (status == 1) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			papp.text("YOU LOSE!", width / 2, 50);
			papp.textSize(15);
			papp.text("You collected the wrong fuel tank. The correct answer is: " + question.getCorrect(), width / 2, 75);

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
			papp.text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			papp.text("YOU WIN!", width / 2, 50);
			papp.textSize(15);
			papp.text("You collected the right fuel tank!", width / 2, 75);

			papp.textSize(60);
			quit.draw(papp);
			if (quit.isPointInButton(papp.mouseX,papp.mouseY))
				quit.setColor(200, 200, 200);
			else
				quit.setColor(255, 255, 255);

			
			if(once) {
				if (!rightAnswers.contains(question.getQuestion())) {
					player.passGame(conference);
				}

				rightAnswers.add(question.getQuestion());
			}
			
		} else if (status == 3) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			papp.text("YOU LOSE!", width / 2, 50);
			papp.textSize(15);
			papp.text("You were too slow, and missed all the fuel tanks!", width / 2, 75);

			papp.textSize(60);
			quit.draw(papp);

			if (bool) {
				bool = true;
				wrongAnswers.add(answers.get(index));
			}
		} else if (status == 4) {
			papp.textSize(20);
			papp.text("QUESTION: " + question.getQuestion(), width / 2, height - 75);
			papp.text("YOU LOSE!", width / 2, 50);
			papp.textSize(15);
			papp.text("You crashed into an obstacle!", width / 2, 75);

			papp.textSize(60);
			quit.draw(papp);

			if (bool) {
				bool = true;
				wrongAnswers.add(answers.get(index));
			}
		}
		
		papp.popStyle();
		papp.popMatrix();
	}

	public void mouseClicked() {
		if (status == -1 && start.isInBounds(papp.mouseX,papp.mouseY))
			status = 0;

		if (pause.isInBounds(papp.mouseX, papp.mouseY)) {
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
				&& quit.isInBounds(papp.mouseX, papp.mouseY))
			papp.setConfBack();

		if (quitintro.isPointInButton(papp.mouseX, papp.mouseY)) {
			papp.setConfBack();
		}
	}

	public void mouseMoved() {
		if (quitintro.isPointInButton(papp.mouseX,papp.mouseY)) {
			quitintro.setBColor(new Color(79, 79, 79));
		} else {
			quitintro.setBColor(Color.WHITE);
		}
	}

	public void keyPressed() {
		if (papp.key == papp.CODED) {
			if (papp.keyCode == papp.UP && lane > 0)
				lane--;
			if (papp.keyCode == papp.DOWN && lane < 3)
				lane++;
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



	@Override
	public void keyReleased() {
		// TODO Auto-generated method stub
		
	}
}