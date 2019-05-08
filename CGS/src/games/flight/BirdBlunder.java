package games.flight;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import ayush.shapes.Rectangle;
import buttons.AyushTextButton;
import buttons.ImageButton;
import other.Player;
import other.Screen;
import processing.core.PApplet;
import processing.core.PImage;
import running.FBLATriviaTester;
import running.Question;

public class BirdBlunder extends Screen {

	//
	private int counter;
	private PhysicsShape shape;
	private PImage background, bird, coin;
	private final int numOfAnswersPerSec;
	private boolean devMode;
	private ArrayList<String> answers;
	private int index;
	private int slide;
	private String que;
	private ArrayList<Answer> birds;
	private AyushTextButton[] qslidebuttons;
	private AyushTextButton backtohome;
	private String ca;
	private int countercoins;
	private double numOfCoinsPerSec;
	private ArrayList<ImageButton> coins;
	private int money;
	private int tcounterwin, tcounterlose;
	private int circrad;
	private String wrong;
	private Player p;
	private int conf;
	private boolean isAddedYet;
	private AyushTextButton quit, quit2;
	private boolean hasLostYet;
	private ArrayList<Question> answer, wronganswers;
	private ArrayList<String> rightAnswers;
	private boolean theOnceBoolean;
	private int inde;

	
	private FBLATriviaTester papp;
	
	
	private Question question;

	public BirdBlunder(ArrayList<String> as, String question, int numOfBirdsPerSec, int conf, Player p,
			ArrayList<Question> answers, ArrayList<Question> wronganswers, int indexx, FBLATriviaTester papp) {
		super(800,700);
		qslidebuttons = new AyushTextButton[2];
		shape = new PhysicsShape(new Rectangle(100, 250, 50, 50));
		counter = 0;
		birds = new ArrayList<Answer>();
		coins = new ArrayList<ImageButton>();
		devMode = false;
		this.answers = as;
		this.numOfAnswersPerSec = numOfBirdsPerSec;
		index = 0;
		slide = 0;
		que = question;
		qslidebuttons[0] = new AyushTextButton(50, 500, 200, 75, 75, 540, Color.BLUE, new Color(96, 117, 150),
				"Instructions", 25);
		qslidebuttons[1] = new AyushTextButton(550, 500, 200, 75, 575, 540, Color.BLUE, new Color(96, 117, 150),
				"Play!", 25);
		ca = as.get(0);
		countercoins = 0;
		numOfCoinsPerSec = .5;
		money = 0;
		tcounterwin = 0;
		tcounterlose = 0;
		circrad = 0;
		wrong = "";
		this.papp = papp;
		backtohome = new AyushTextButton(250, 500, 300, 100, 275, 550, Color.BLUE, new Color(96, 117, 150),
				"Back to Question", 30);
		this.conf = conf;
		this.p = p;
		isAddedYet = false;
		quit = new AyushTextButton(250, 300, 200, 100, 275, 365, Color.BLACK, Color.white, "Quit", 40);
		quit2 = new AyushTextButton(700, 625, 100, 55, 715, 655, Color.black, Color.white, "Quit", 20);
		hasLostYet = false;
		answer = answers;
		this.wronganswers = wronganswers;
		theOnceBoolean = false;
		inde = indexx;

		this.question = new Question(que, as.get(0), as.get(1), as.get(2), as.get(3));
	}

	public BirdBlunder(Question ques, int numOfBirdsPerSec, int conf, Player p, ArrayList<Question> answers,
			ArrayList<Question> wronganswers, ArrayList<String> rightAnswers, int indexx, FBLATriviaTester papp) {
		super(800,700);
		this.papp = papp;
		ArrayList<String> as = new ArrayList<String>();
		as.add(ques.getCorrect());
		as.add(ques.getWrong1());
		as.add(ques.getWrong2());
		as.add(ques.getWrong3());

		qslidebuttons = new AyushTextButton[2];
		shape = new PhysicsShape(new Rectangle(100, 250, 50, 50));
		counter = 0;
		birds = new ArrayList<Answer>();
		coins = new ArrayList<ImageButton>();
		devMode = false;
		this.answers = as;
		this.numOfAnswersPerSec = numOfBirdsPerSec;
		index = 0;
		slide = 0;
		que = ques.getQuestion();
		qslidebuttons[0] = new AyushTextButton(50, 500, 200, 75, 75, 540, Color.BLUE, new Color(96, 117, 150),
				"Instructions", 25);
		qslidebuttons[1] = new AyushTextButton(550, 500, 200, 75, 575, 540, Color.BLUE, new Color(96, 117, 150),
				"Play!", 25);
		ca = as.get(0);
		countercoins = 0;
		numOfCoinsPerSec = .5;
		money = 0;
		tcounterwin = 0;
		tcounterlose = 0;
		circrad = 0;
		wrong = "";
		backtohome = new AyushTextButton(250, 500, 300, 100, 275, 550, Color.BLUE, new Color(96, 117, 150),
				"Back to Question", 30);
		this.conf = conf;
		this.p = p;
		isAddedYet = false;
		quit = new AyushTextButton(250, 400, 200, 100, 275, 465, Color.BLACK, Color.white, "Quit", 40);
		quit2 = new AyushTextButton(700, 625, 100, 55, 715, 655, Color.black, Color.white, "Quit", 20);
		hasLostYet = false;

		answer = answers;
		this.wronganswers = wronganswers;
		this.rightAnswers = rightAnswers;
		inde = indexx;

		this.question = new Question(que, as.get(0), as.get(1), as.get(2), as.get(3));
	}

	

	public void setup() {
		background = papp.loadImage("images\\back.jpg");
		bird = papp.loadImage("images\\bird.png");
		coin = papp.loadImage("images\\coinnw.png");
	}

	public void draw() {
		papp.pushMatrix();
		papp.pushStyle();
		papp.textAlign(papp.BOTTOM, papp.LEFT);
		
		switch (slide) {
		case 0:
			drawQuestion();
			break;
		case 1:
			drawGame();
			break;
		case 2:
			lose();
			break;
		case 3:
			instructions();
			break;
		case 4:
			win();
			break;
		}
		papp.popStyle();
		papp.popMatrix();
	}

	public void drawQuestion() {
		papp.image(background, 0, 0, 800, 700);
		papp.textSize(50);
		papp.fill(255, 255, 255);
		papp.text(que, 25, 100);
		papp.noStroke();
		qslidebuttons[0].draw(papp);
		qslidebuttons[1].draw(papp);
		quit2.draw(papp);
	}

	public void instructions() {
		papp.image(background, 0, 0, 800, 700);
		papp.textSize(50);
		papp.fill(255, 0, 0);
		papp.text("Instructions:", 250, 50);
		papp.fill(0, 255, 0);
		papp.text("Use the space bar to float \nthe bird up and dodge the \nwrong answers and try and \nhit the correct answers.",
				50, 125);
		backtohome.draw(papp);
	}

	public void drawGame() {
		papp.background(255);
		papp.image(background, 0, 0, 800, 700);
		shape.act(new Rectangle(0, 0, 800, 700));
		papp.image(bird, shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
		if (devMode) {
			shape.draw(papp, new Rectangle(0, 0, 800, 700));
		}
		if (shape.getY() < 700 - shape.getHeight()) {
			shape.accelerate(0, .2);

		} else {

			slide++;
		}

		if (counter < (60 / numOfAnswersPerSec)) {
			counter++;
		} else {
			counter = 0;
			String answer;
			if (index >= answers.size()) {
				index = 0;
			}
			answer = answers.get((int) (Math.random() * answers.size()));
			birds.add(new Answer(answer, 800, (int) (Math.random() * 600), 25));
			index++;
		}
		/*
		 * if(countercoins<60/numOfCoinsPerSec) { countercoins++; }else { countercoins =
		 * 0; ImageButton coindraw = new ImageButton(coin, 900,
		 * (float)(Math.random()*625), 50,50); coins.add(coindraw);
		 * 
		 * }
		 */
		for (int i = 0; i < coins.size(); i++) {

			ImageButton e = coins.get(i);
			e.draw(papp);
			e.setX(e.getX() - 10);

			if (shape.overlaps(e.getRectangle())) {
				coins.remove(i);
				money++;
			}

			if (devMode) {
				e.getRectangle().draw(papp);
			}
		}
		quit2.draw(papp);

		for (Answer e : birds) {
			e.moveLeft();

			e.draw(papp);
			Rectangle r = e.getRectangle();
			if (shape.overlaps(r)) {
				if (e.getText().equalsIgnoreCase(ca)) {
					win();
				} else {

					// shape.setColor(Color.RED);
					wrong = e.getText();
					slide = 2;

					break;
				}
			}
			if (devMode) {
				r.draw(papp);
			}

		}

	}

	public void win() {
		// TODO Auto-generated method stub

		papp.image(background, 0, 0, 800, 700);
		papp.fill(4, 165, 61);

		papp.ellipse(400, 350, circrad, circrad);
		if (circrad > 1060) {
			papp.textSize(50);
			papp.fill(0);
			papp.text("You hit the correct answer, \n" + ca, 75, 150);
			quit.draw(papp);

			// text("Money: " + money, 75,300);
		} else {
			circrad += 20;
		}
		if (!isAddedYet) {
			if (!rightAnswers.contains(question.getQuestion()))
				p.passGame(conf);
			isAddedYet = true;

			rightAnswers.add(question.getQuestion());
		}
		slide = 4;

	}

	public void mouseClicked() {

		int x = papp.mouseX;
		int y = papp.mouseY;

		if (slide == 0) {
			if (qslidebuttons[0].isPointInButton(x, y)) {
				slide = 3;
			} else if (qslidebuttons[1].isPointInButton(x, y)) {
				slide = 1;
			} else if (quit2.isPointInButton(x, y)) {
				papp.setConfBack();
			}
		} else if (slide == 3) {
			if (backtohome.isPointInButton(x, y)) {
				slide = 0;
			}
		} else if (slide == 2) {
			if (quit.isPointInButton(x, y)) {
				papp.setConfBack();
			}
		} else if (slide == 4) {
			if (quit.isPointInButton(x, y)) {
				papp.setConfBack();
			}
		} else if (slide == 1) {
			if (quit2.isPointInButton(x, y)) {
				papp.setConfBack();
			}
		}

	}

	public void mouseMoved() {

		int px = papp.mouseX;
		int py = papp.mouseY;

		Color col1 = new Color(96, 117, 150);
		Color col2 = new Color(55, 64, 79);
		Color col3 = new Color(0, 255, 255);

		if (slide == 0) {
			for (AyushTextButton e : qslidebuttons) {
				if (e.isPointInButton(px, py)) {
					e.setBColor(col2);
				} else {
					e.setBColor(col1);
				}

			}

			if (quit2.isPointInButton(px, py)) {
				quit2.setBColor(new Color(125, 125, 125));

			} else {
				quit2.setBColor(Color.white);
			}
		} else if (slide == 3) {
			if (backtohome.isPointInButton(px, py)) {
				backtohome.setBColor(col2);
			} else {
				backtohome.setBColor(col1);
			}
		} else if (slide == 2) {
			if (quit.isPointInButton(px, py)) {
				quit.setBColor(col3);
			} else {
				quit.setBColor(Color.white);
			}
		} else if (slide == 4) {
			if (quit.isPointInButton(px, py)) {
				quit.setBColor(col3);
			} else {
				quit.setBColor(Color.white);
			}
		} else if (slide == 1) {
			if (quit2.isPointInButton(px, py)) {
				quit2.setBColor(new Color(125, 125, 125));

			} else {
				quit2.setBColor(Color.white);
			}
		}

	}

	public void lose() {
		papp.image(background, 0, 0, 800, 700);
		papp.fill(255, 0, 0);
		papp.ellipse(400, 350, circrad, circrad);
		if (circrad > 1060) {
			papp.textSize(50);
			papp.fill(0);
			papp.text("You lost!", 75, 100);
			papp.text("The correct answer was:", 75, 160);
			papp.fill(0, 0, 255);
			papp.text(ca, 75, 220);
			papp.fill(0);
			papp.text("You hit: ", 75, 280);
			papp.fill(0, 0, 255);
			papp.text(wrong, 270, 280);
			papp.fill(0, 255, 0);
			quit.draw(papp);
			// text("Money collected: " + money, 75,340);
		} else {
			circrad += 20;
		}

		if (!theOnceBoolean) {
			theOnceBoolean = true;
			wronganswers.add(answer.get(inde));
		}

	}

	public boolean getLost() {
//		System.out.println(hasLostYet);
		return hasLostYet;
	}

	public void keyPressed() {
		if (papp.key == ' ') {
			shape.setVelocity(0,-8);;

		} else if (papp.key == 'j') {
			devMode = !devMode;
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
