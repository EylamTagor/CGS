import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import btns.TextButton;
import games.driving.Driving;
import games.psychosearch.PsychoSearch;
import games.space.Space;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Dashboard extends PApplet {
	private SohilButton shop, nationals, quit, activeButton, backConference, game1, game2, game3;
	private ArrayList<ArrayList<SohilButton>> conferences;
	private ArrayList<SohilButton> conferenceSelection, conference1, conference2, conference3, conference4, conference5;
	private ArrayList<ProgressBar> progressBars;
	private Player player;
	private boolean theOnceBoolean;
	private int clickTime, spaceConfIndicator, drivingConfIndicator;
	private int confButtonDiff = 100, buttonWidth = 80, confHeadHeight = 80, gameButtonMargin = 40;

	public Dashboard() {
		player = new Player();
		player.earn(575);

		game1 = new SohilButton("Game 1", 40, SohilButton.RECTANGLE, 150, 400, 100);
		game2 = new SohilButton("Game 2", 40, SohilButton.RECTANGLE,
				game1.getY() + game1.getHeight() + gameButtonMargin, 400, 100);
		game3 = new SohilButton("Game 3", 40, SohilButton.RECTANGLE,
				game2.getY() + game2.getHeight() + gameButtonMargin, 400, 100);

		backConference = new SohilButton("Back", 20, SohilButton.RECTANGLE, Main.width - 105, Main.height - 100, 75,
				50);
		activeButton = backConference;

		progressBars = new ArrayList<ProgressBar>();
		for (int i = 0; i < 5; i++) {
			progressBars.add(new ProgressBar("", 200, game3.getY() + game3.getHeight(), 400, 100, 0));
		}

		conferences = new ArrayList<ArrayList<SohilButton>>();
		conferenceSelection = new ArrayList<SohilButton>();
		conferences.add(conference1 = new ArrayList<SohilButton>());
		conferences.add(conference2 = new ArrayList<SohilButton>());
		conferences.add(conference3 = new ArrayList<SohilButton>());
		conferences.add(conference4 = new ArrayList<SohilButton>());
		conferences.add(conference5 = new ArrayList<SohilButton>());

		for (int i = 0; i < 5; i++) {
			conferences.get(i).add(backConference);
			conferences.get(i).add(game1);
			conferences.get(i).add(game2);
			conferences.get(i).add(game3);
		}

		for (int i = 1; i < 6; i++) {
			conferenceSelection.add(new SohilButton(((Integer) i).toString(), 40, SohilButton.CIRCLE,
					(Main.width / 2) + (i - 3) * confButtonDiff, 225, buttonWidth, buttonWidth));
		}

		shop = new SohilButton("Shop", 40, SohilButton.RECTANGLE, 400, 400, 100);
		conferenceSelection.add(nationals = new SohilButton("Nationals", 40, SohilButton.RECTANGLE, 325, 400, 100));
		conferenceSelection.add(quit = new SohilButton("Quit", 40, SohilButton.RECTANGLE, 475, 400, 100));
	}

	public void draw() {
		if (!theOnceBoolean)
			drawInstructions();
		else
			drawMain();
	}

	public void drawInstructions() {
		background(38);
		textSize(40);
		textAlign(LEFT, BOTTOM);
		text("Instructions here...", 25, confHeadHeight);
		text("click anywhere to start!", 25, confHeadHeight + 50);
	}

	public void drawMain() {
		background(38);
		if (activeButton == backConference)
			drawConferenceScreen();

		if (activeButton == conferenceSelection.get(0))
			drawConference1();
		if (activeButton == conferenceSelection.get(1))
			drawConference2();
		if (activeButton == conferenceSelection.get(2))
			drawConference3();
		if (activeButton == conferenceSelection.get(3))
			drawConference4();
		if (activeButton == conferenceSelection.get(4))
			drawConference5();

		for (ArrayList<SohilButton> a : conferences) {
			for (SohilButton b : a) {
				if (activeButton == game1) {
					drawSpaceGame();
					activeButton = b;
				}
				if (activeButton == game2) {
					drawDrivingGame();
					activeButton = b;
				}
				if (activeButton == game3) {
					drawPsychoSearchGame();
					activeButton = b;
				}
			}
		}

		if (activeButton == nationals)
			drawNationals();
		if (activeButton == quit)
			exit();

//		System.out.println(Arrays.toString(player.getProgress()));
	}

	public void drawSpaceGame() {
		// change drawing's type to whatever game you want to run (or duplicate for each
		// game if you want
		Space drawing = new Space(new Question("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "right",
				"wrong1", "wrong2", "wrong3"), player, spaceConfIndicator, 1);
		drawing.setSize(800, 700);
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		drawing.setFrame(window);

		window.setSize(800, 700);
		window.setLocation(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		window.setVisible(true);
		canvas.requestFocus();
	}

	public void drawDrivingGame() {
		// change drawing's type to whatever game you want to run (or duplicate for each
		// game if you want)
		Driving drawing = new Driving(new Question("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "right",
				"wrong1", "wrong2", "wrong3"), player, drivingConfIndicator, 5);
		drawing.setSize(800, 700);
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setSize(800, 700);
		window.setLocation(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		window.setVisible(true);
		canvas.requestFocus();
	}

	public void drawPsychoSearchGame() {
		ArrayList<String> ans = new ArrayList<String>();
		ans.add(0, "correct answer");
		for (int i = 0; i < 2; i++) {
			ans.add("answer" + i);
		}

		PsychoSearch drawing = new PsychoSearch(ans, "Example Question Example Question");
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		window.setSize(800, 700);
		window.setLocation(250, 20);
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}

	public void drawNationals() {
		textAlign(LEFT, BOTTOM);
		text("The final game with all the topics and", 25, confHeadHeight);
		text("whatnot, but for now you gotta restart", 25, confHeadHeight + 50);
		text("the program sorry lol", 25, confHeadHeight + 100);
	}

	public void drawConferenceScreen() {
		headingFormat();
		text("Conferences", Main.width / 2, confHeadHeight);
		for (SohilButton b : conferenceSelection) {
			b.draw(this);
			if (b.isPointInside(mouseX, mouseY)) {
				b.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = b;
					clickTime = millis();
				}
			} else {
				b.setColor(new Color(135, 206, 255));
			}
		}
		nationals.draw(this);
		quit.draw(this);
//		shop.draw(this);
	}

	public void drawConference1() {
		spaceConfIndicator = 0;
		drivingConfIndicator = 0;
		for (SohilButton b : conference1) {
			b.draw(this);
			if (b.isPointInside(mouseX, mouseY) && millis() - clickTime > 500) {
				b.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = b;
				}
			} else {
				b.setColor(new Color(135, 206, 255));
			}
		}
		progressBars.get(0).setProgress(player.getProgress()[0]);
		progressBars.get(0).draw(this);
		headingFormat();
		text("Conference 1", Main.width / 2, confHeadHeight);
	}

	public void drawConference2() {
		spaceConfIndicator = 1;
		drivingConfIndicator = 1;
		for (SohilButton b : conference2) {
			b.draw(this);
			if (b.isPointInside(mouseX, mouseY) && millis() - clickTime > 500) {
				b.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = b;
				}
			} else {
				b.setColor(new Color(135, 206, 255));
			}
		}
		progressBars.get(1).setProgress(player.getProgress()[1]);
		progressBars.get(1).draw(this);
		headingFormat();
		text("Conference 2", Main.width / 2, confHeadHeight);
	}

	public void drawConference3() {
		spaceConfIndicator = 2;
		drivingConfIndicator = 2;
		for (SohilButton b : conference3) {
			b.draw(this);
			if (b.isPointInside(mouseX, mouseY) && millis() - clickTime > 500) {
				b.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = b;
				}
			} else {
				b.setColor(new Color(135, 206, 255));
			}
		}
		progressBars.get(2).setProgress(player.getProgress()[2]);
		progressBars.get(2).draw(this);
		headingFormat();
		text("Conference 3", Main.width / 2, confHeadHeight);
	}

	public void drawConference4() {
		spaceConfIndicator = 3;
		drivingConfIndicator = 3;
		for (SohilButton b : conference4) {
			b.draw(this);
			if (b.isPointInside(mouseX, mouseY) && millis() - clickTime > 500) {
				b.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = b;
				}
			} else {
				b.setColor(new Color(135, 206, 255));
			}
		}
		progressBars.get(3).setProgress(player.getProgress()[3]);
		progressBars.get(3).draw(this);
		headingFormat();
		text("Conference 4", Main.width / 2, confHeadHeight);
	}

	public void drawConference5() {
		spaceConfIndicator = 4;
		drivingConfIndicator = 4;
		for (SohilButton b : conference5) {
			b.draw(this);
			if (b.isPointInside(mouseX, mouseY) && millis() - clickTime > 500) {
				b.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = b;
				}
			} else {
				b.setColor(new Color(135, 206, 255));
			}
		}
		progressBars.get(4).setProgress(player.getProgress()[4]);
		progressBars.get(4).draw(this);
		headingFormat();
		text("Conference 5", Main.width / 2, confHeadHeight);
	}

	public void headingFormat() {
		fill(255);
		textSize(80);
		textAlign(CENTER, CENTER);
	}

	public void drawShop() {
		background(255);

		back.draw(this);

		textSize(30);

		jacket.draw(this);
		shirt.draw(this);
		slacks.draw(this);
		shoes.draw(this);
		belt.draw(this);
		tie.draw(this);
	}

	public void mouseClicked() {
		theOnceBoolean = true;
		if (back.isPointInButton(mouseX, mouseY)) {
			// go back to dashboard
		} else if (jacket.isInBounds(mouseX, mouseY) && player.getBalance() >= 250) {
			player.obtainJacket();
		} else if (shirt.isInBounds(mouseX, mouseY) && player.getBalance() >= 75) {
			player.obtainShirt();
		} else if (slacks.isInBounds(mouseX, mouseY) && player.getBalance() >= 100) {
			player.obtainSlacks();
		} else if (shoes.isInBounds(mouseX, mouseY) && player.getBalance() >= 75) {
			player.obtainShoes();
		} else if (belt.isInBounds(mouseX, mouseY) && player.getBalance() >= 25) {
			player.obtainBelt();
		} else if (tie.isInBounds(mouseX, mouseY) && player.getBalance() >= 50) {
			player.obtainTie();
		}
	}

}
