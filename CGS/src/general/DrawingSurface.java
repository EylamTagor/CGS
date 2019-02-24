package general;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import buttons.AyushTextButton;
import buttons.ImageButton;
import buttons.SohilButton;
import buttons.TextButton;
import games.birdblunder.BirdBlunder;
import games.driving.Driving;
import games.psychosearch.PsychoSearch;
import games.space.Space;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private TextButton back, jacket, shirt, slacks, shoes, belt, tie;
	private SohilButton nationals, quit, activeButton, backConference, game1, game2, game3, game4;
	private ArrayList<ArrayList<SohilButton>> conferences;
	private ArrayList<SohilButton> conferenceSelection, conference1, conference2, conference3, conference4, conference5;
	private ArrayList<ProgressBar> progressBars;
	private Player player;
	private boolean theOnceBoolean;
	private int clickTime, spaceConfIndicator, drivingConfIndicator;
	private int confButtonDiff = 100, buttonWidth = 80, confHeadHeight = 80, gameButtonMargin = 20;
	private SohilButton proceedToNats;
	private ArrayList<String> topics;
	private final String font;
	private ImageButton next, next2;
	private AyushTextButton[] options;
	private int slide;
	/// birdblunder question 3, psycho question 2, space question0, driving quesiont
	/// 1
	private ArrayList<Question> wronganswers;

	private ArrayList<Question> parlibb, bizcommbb, bizprobb, infotechbb, mathbb, fblabb, bizbb;
	private ArrayList<Question> parlips, bizcommps, bizprops, infotechps, mathps, fblaps, bizps;
	private ArrayList<Question> parlis, bizcomms, bizpros, infotechs, maths, fblas, bizs;
	private ArrayList<Question> parlid, bizcommd, bizprod, infotechd, mathd, fblad, bizd;

	public DrawingSurface() {
		player = new Player();
		player.earn(575);
		topics = new ArrayList<String>();
		wronganswers = new ArrayList<Question>();
		slide = 1;
		options = new AyushTextButton[7];
		options[0] = new AyushTextButton(30, 40, 700, 80, 130, 90, Color.BLACK, Color.WHITE,
				"Intro to Parliamentary Procedure", 30);
		options[1] = new AyushTextButton(30, 130, 700, 80, 130, 180, Color.BLACK, Color.WHITE,
				"Intro to Business Communication", 30);
		options[2] = new AyushTextButton(30, 220, 700, 80, 150, 270, Color.BLACK, Color.WHITE,
				"Intro to Business Procedures", 30);
		options[3] = new AyushTextButton(30, 310, 700, 80, 130, 360, Color.BLACK, Color.WHITE,
				"Intro to Information Technology", 30);
		options[4] = new AyushTextButton(30, 400, 700, 80, 170, 450, Color.BLACK, Color.WHITE,
				"Intro to Financial Math", 30);
		options[5] = new AyushTextButton(30, 490, 500, 80, 200, 540, Color.BLACK, Color.WHITE, "Intro to FBLA", 30);
		options[6] = new AyushTextButton(30, 580, 500, 80, 200, 630, Color.BLACK, Color.WHITE, "Intro to Business", 30);

		initializeQuestionArrays();

		font = "Verdana";

		back = new TextButton(10, 10, 120, 25, 15, 25, 255, 200, 200, 0, 0, 0, "Back to conference");
		jacket = new TextButton(75, 100, 300, 100, 150, 150, 200, 255, 200, 0, 0, 0, "Jacket: $250");
		shirt = new TextButton(425, 100, 300, 100, 500, 150, 200, 255, 200, 0, 0, 0, "Shirt: $75");
		slacks = new TextButton(75, 250, 300, 100, 150, 300, 200, 255, 200, 0, 0, 0, "Slacks: $100");
		shoes = new TextButton(425, 250, 300, 100, 500, 300, 200, 255, 200, 0, 0, 0, "Shoes: $75");
		belt = new TextButton(75, 400, 300, 100, 150, 450, 200, 255, 200, 0, 0, 0, "Belt: $25");
		tie = new TextButton(425, 400, 300, 100, 500, 450, 200, 255, 200, 0, 0, 0, "Tie: $50");

		game1 = new SohilButton("Game 1", 40, SohilButton.RECTANGLE, 150, 400, 100);
		game2 = new SohilButton("Game 2", 40, SohilButton.RECTANGLE,
				game1.getY() + game1.getHeight() + gameButtonMargin, 400, 100);
		game3 = new SohilButton("Game 3", 40, SohilButton.RECTANGLE,
				game2.getY() + game2.getHeight() + gameButtonMargin, 400, 100);
		game4 = new SohilButton("Game 4", 40, SohilButton.RECTANGLE,
				game3.getY() + game3.getHeight() + gameButtonMargin, 400, 100);

		backConference = new SohilButton("Back", 20, SohilButton.RECTANGLE, Main.width - 105, Main.height - 100, 75,
				50);
		activeButton = backConference;

		progressBars = new ArrayList<ProgressBar>();
		for (int i = 0; i < 5; i++) {
			progressBars.add(new ProgressBar("", 200, game4.getY() + game4.getHeight() - 25, 400, 100, 0));
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
			conferences.get(i).add(game4);

		}

		for (int i = 1; i < 6; i++) {
			conferenceSelection.add(new SohilButton(((Integer) i).toString(), 40, SohilButton.CIRCLE,
					(Main.width / 2) + (i - 3) * confButtonDiff, 225, buttonWidth, buttonWidth));
		}

		conferenceSelection.add(nationals = new SohilButton("Nationals", 40, SohilButton.RECTANGLE, 300, 400, 100));
		conferenceSelection.add(quit = new SohilButton("Quit", 40, SohilButton.RECTANGLE, 425, 400, 100));

		proceedToNats = new SohilButton("Proceed to Nationals", 40, SohilButton.RECTANGLE, 450, 500, 100);
	}

	public void draw() {
		if (!theOnceBoolean)
			drawInstructions();
		else
			drawMain();
	}

	public void initializeQuestionArrays() {

		parlibb = new ArrayList<Question>();
		bizcommbb = new ArrayList<Question>();
		bizprobb = new ArrayList<Question>();
		infotechbb = new ArrayList<Question>();
		mathbb = new ArrayList<Question>();
		fblabb = new ArrayList<Question>();
		bizbb = new ArrayList<Question>();

		parlis = new ArrayList<Question>();
		bizcomms = new ArrayList<Question>();
		bizpros = new ArrayList<Question>();
		infotechs = new ArrayList<Question>();
		maths = new ArrayList<Question>();
		fblas = new ArrayList<Question>();
		bizs = new ArrayList<Question>();

		parlid = new ArrayList<Question>();
		bizcommd = new ArrayList<Question>();
		bizprod = new ArrayList<Question>();
		infotechd = new ArrayList<Question>();
		mathd = new ArrayList<Question>();
		fblad = new ArrayList<Question>();
		bizd = new ArrayList<Question>();

		parlips = new ArrayList<Question>();
		bizcommps = new ArrayList<Question>();
		bizprops = new ArrayList<Question>();
		infotechps = new ArrayList<Question>();
		mathps = new ArrayList<Question>();
		fblaps = new ArrayList<Question>();
		bizps = new ArrayList<Question>();

		bizcommbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlibb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlibb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlibb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlibb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprobb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprobb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprobb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprobb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizbb.add(new Question(
				"__________ marketing involves developing a unique mix of goods and services for each individual customer.",
				"One-to-one", "B2B", "Usage", "Volume"));
		bizbb.add(new Question(
				"Groups of people such as workers who pool their money together for savings and to make loans is called a:",
				"credit union", "union bank", "state union", "labor union"));
		bizbb.add(new Question("When compared to a traditional savings account, a certificate of deposit is:",
				"less liquid", "equally liquid", "more dynamic", "more liquid"));
		bizbb.add(new Question("Spending a few hours observing someone in your chosen occupation is called job _____",
				"shadowing", "training", "orientation", "mentoring"));
		fblabb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblabb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblabb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblabb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathbb.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?",
				"descriptive", "persuasive", "instructional", "informative"));

		bizcommps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlips.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlips.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlips.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlips.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprops.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprops.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprops.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprops.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizps.add(new Question(
				"__________ marketing involves developing a unique mix of goods and services for each individual customer.",
				"One-to-one", "B2B", "Usage", "Volume"));
		bizps.add(new Question(
				"Groups of people such as workers who pool their money together for savings and to make loans is called a:",
				"credit union", "union bank", "state union", "labor union"));
		bizps.add(new Question("When compared to a traditional savings account, a certificate of deposit is:",
				"less liquid", "equally liquid", "more dynamic", "more liquid"));
		bizps.add(new Question("Spending a few hours observing someone in your chosen occupation is called job _____",
				"shadowing", "training", "orientation", "mentoring"));
		fblaps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblaps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblaps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblaps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));

		bizcommd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlid.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlid.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlid.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlid.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprod.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprod.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprod.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizprod.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizd.add(new Question(
				"__________ marketing involves developing a unique mix of goods and services for each individual customer.",
				"One-to-one", "B2B", "Usage", "Volume"));
		bizd.add(new Question(
				"Groups of people such as workers who pool their money together for savings and to make loans is called a:",
				"credit union", "union bank", "state union", "labor union"));
		bizd.add(new Question("When compared to a traditional savings account, a certificate of deposit is:",
				"less liquid", "equally liquid", "more dynamic", "more liquid"));
		bizd.add(new Question("Spending a few hours observing someone in your chosen occupation is called job _____",
				"shadowing", "training", "orientation", "mentoring"));
		fblad.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblad.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblad.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblad.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		mathd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));

		bizcomms.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcomms.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcomms.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcomms.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlis.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlis.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlis.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		parlis.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechs.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechs.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechs.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		infotechs.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizpros.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizpros.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizpros.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizpros.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizs.add(new Question(
				"__________ marketing involves developing a unique mix of goods and services for each individual customer.",
				"One-to-one", "B2B", "Usage", "Volume"));
		bizs.add(new Question(
				"Groups of people such as workers who pool their money together for savings and to make loans is called a:",
				"credit union", "union bank", "state union", "labor union"));
		bizs.add(new Question("When compared to a traditional savings account, a certificate of deposit is:",
				"less liquid", "equally liquid", "more dynamic", "more liquid"));
		bizs.add(new Question("Spending a few hours observing someone in your chosen occupation is called job _____",
				"shadowing", "training", "orientation", "mentoring"));
		fblas.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblas.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblas.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		fblas.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		maths.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		maths.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		maths.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		maths.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));

	}

	public ArrayList<Question> getQueArray(String name, String game) {

		if (game.equals("bb")) {
			if (name.equals("Intro to Parliamentary Procedure")) {
				return parlibb;
			} else if (name.equals("Intro to Information Technology")) {
				return infotechbb;
			} else if (name.equals("Intro to Business Procedures")) {
				return bizprobb;
			} else if (name.equals("Intro to Business Communication")) {
				return bizcommbb;
			} else if (name.equals("Intro to Financial Math")) {
				return mathbb;
			} else if (name.equals("Intro to FBLA")) {
				return fblabb;
			} else if (name.equals("Intro to Business")) {
				return bizbb;
			}
		} else if (game.equals("s")) {
			if (name.equals("Intro to Parliamentary Procedure")) {
				return parlis;
			} else if (name.equals("Intro to Information Technology")) {
				return infotechs;
			} else if (name.equals("Intro to Business Procedures")) {
				return bizpros;
			} else if (name.equals("Intro to Business Communication")) {
				return bizcomms;
			} else if (name.equals("Intro to Financial Math")) {
				return maths;
			} else if (name.equals("Intro to FBLA")) {
				return fblas;
			} else if (name.equals("Intro to Business")) {
				return bizs;
			}
		} else if (game.equals("ps")) {
			if (name.equals("Intro to Parliamentary Procedure")) {
				return parlips;
			} else if (name.equals("Intro to Information Technology")) {
				return infotechps;
			} else if (name.equals("Intro to Business Procedures")) {
				return bizprops;
			} else if (name.equals("Intro to Business Communication")) {
				return bizcommps;
			} else if (name.equals("Intro to Financial Math")) {
				return mathps;
			} else if (name.equals("Intro to FBLA")) {
				return fblaps;
			} else if (name.equals("Intro to Business")) {
				return bizps;
			}
		} else if (game.equals("d")) {
			if (name.equals("Intro to Parliamentary Procedure")) {
				return parlid;
			} else if (name.equals("Intro to Information Technology")) {
				return infotechd;
			} else if (name.equals("Intro to Business Procedures")) {
				return bizprod;
			} else if (name.equals("Intro to Business Communication")) {
				return bizcommd;
			} else if (name.equals("Intro to Financial Math")) {
				return mathd;
			} else if (name.equals("Intro to FBLA")) {
				return fblad;
			} else if (name.equals("Intro to Business")) {
				return bizd;
			}
		}

		return null;

	}

	public void drawInstructions() {
		if (slide == 1) {
			background(255);
			fill(255, 0, 0);
			textFont(createFont(font, 100));
			text("Welcome to", 100, 130);
			text("FBLA Tester", 90, 280);
			next.draw(this);
		} else if (slide == 2) {
			background(255);
			text("cutscene", 100, 130);
			next.draw(this);
		} else if (slide == 3) {
			background(255);
			textSize(33);
			fill(255, 0, 0);
			text("Choose the 5 topics you want to study", 75, 25);
			options[0].draw(this);
			options[1].draw(this);
			options[2].draw(this);
			options[3].draw(this);
			options[4].draw(this);
			options[5].draw(this);
			options[6].draw(this);
			next2.draw(this);

		} else if (slide == 4) {
			theOnceBoolean = true;
			for (AyushTextButton e : options) {
				if (e.getBColor().equals(new Color(0, 0, 255))) {
					topics.add(e.getText());
				}
			}
		}
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

		if (activeButton == proceedToNats) {
			drawNatsConference();
		}

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

				if (activeButton == game4) {
					drawBirdBlunderGame();
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

	public void setup() {
		next = new ImageButton(loadImage("images\\next.png"), 300, 450, 200, 200);
		next2 = new ImageButton(loadImage("images\\next.png"), 580, 500, 150, 150);
	}

	public void drawNatsConference() {
		headingFormat();
		text("nats", Main.width / 2, confHeadHeight);
		textSize(10);
		for (int i = 0; i < wronganswers.size(); i++) {
			Question e = wronganswers.get(i);
			text(e.toString(), Main.width / 2, confHeadHeight + 100 + 50 * i);
		}
	}

	public void drawBirdBlunderGame() {
		// TODO Auto-generated method stub

		ArrayList<Question> as = getQueArray(topics.get(spaceConfIndicator), "bb");
		final int birdspersec = 3;
		BirdBlunder drawing = new BirdBlunder(as.get(3), birdspersec, spaceConfIndicator, player, as, wronganswers, 3);
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();
		drawing.setFrame(window);
		window.setSize(800, 700);
		window.setLocation(250, 20);
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();

	}

	public void drawSpaceGame() {
		// change drawing's type to whatever game you want to run (or duplicate for each
		// game if you want
		ArrayList<Question> as = getQueArray(topics.get(spaceConfIndicator), "s");
		final int speed = 3;
		Space drawing = new Space(new Question("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "right",
				"wrong1", "wrong2", "wrong3"), player, spaceConfIndicator, speed, as, wronganswers, 0);
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
		ArrayList<Question> as = getQueArray(topics.get(spaceConfIndicator), "s");

		final int speed = 10;
		Driving drawing = new Driving(new Question("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "right",
				"wrong1", "wrong2", "wrong3"), player, drivingConfIndicator, speed, as, wronganswers, 1);
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

	public void drawPsychoSearchGame() {
		// TODO Auto-generated method stub

		ArrayList<Question> as = getQueArray(topics.get(spaceConfIndicator), "ps");

		final int seconds = 30;
		PsychoSearch drawing = new PsychoSearch(as.get(2), seconds, player, spaceConfIndicator, as, wronganswers, 2);
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();
		drawing.setFrame(window);
		window.setSize(800, 700);
		window.setLocation(250, 20);
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}

	public void drawNationals() {
		backConference.draw(this);
		if (backConference.isPointInside(mouseX, mouseY)) {
			backConference.setColor(new Color(0, 191, 255));
			if (mousePressed) {
				activeButton = backConference;
			}
		} else {
			backConference.setColor(new Color(135, 206, 255));
		}

		int[] prog = player.getProgress();
		boolean hasPassedConfs = true;
		for (int e : prog) {
			if (e < 4) {
				hasPassedConfs = false;
			}
		}
		if (hasPassedConfs) {
			headingFormat();
			textSize(50);
			text("Congrats on passing all of the \nconferences!", Main.width / 2 + 10, confHeadHeight);
			text("The National Conference is \ndesigned to test all of the \nquestions you got wrong",
					Main.width / 2 + 10, confHeadHeight + 200);

			proceedToNats.draw(this);
			if (proceedToNats.isPointInside(mouseX, mouseY)) {
				proceedToNats.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = proceedToNats;
				}
			} else {
				proceedToNats.setColor(new Color(135, 206, 255));
			}

		} else {
			headingFormat();
			text("Not yet!\nFinish all of the \nconferences first.", Main.width / 2, confHeadHeight + 200);
		}
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
		// System.out.println(player.getProgress()[0]);
		progressBars.get(0).draw(this);
		headingFormat();
		textSize(45);

		text(topics.get(0), Main.width / 2, confHeadHeight);
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
		textSize(45);
		text(topics.get(1), Main.width / 2, confHeadHeight);
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
		textSize(45);
		text(topics.get(2), Main.width / 2, confHeadHeight);
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
		textSize(45);
		text(topics.get(3), Main.width / 2, confHeadHeight);
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
		textSize(45);
		text(topics.get(4), Main.width / 2, confHeadHeight);
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

		int x = mouseX;
		int y = mouseY;

		Color col1 = new Color(0, 0, 255);
		Color col2 = new Color(0, 255, 255);

		if (!theOnceBoolean) {
			if (slide == 1) {
				if (mouseButton == LEFT) {
					if (next.isPointInButton(mouseX, mouseY)) {
						slide++;
					}
				}

			} else if (slide == 2) {
				if (mouseButton == LEFT) {
					if (next.isPointInButton(mouseX, mouseY)) {
						slide++;
					}
				}
			} else if (slide == 3) {
				if (mouseButton == LEFT) {

					if (next2.isPointInButton(x, y)) {
						slide++;
					}

					for (int i = 0; i < options.length; i++) {
						if (options[i].isPointInButton(x, y)) {
							if (options[i].getBColor().equals(col1)) {
								options[i].setBColor(col2);
							} else {
								options[i].setBColor(col1);

							}
						}
					}
				}
			}
		}

	}

	public void mouseMoved() {
		int x = mouseX;
		int y = mouseY;
		Color col1 = new Color(0, 255, 255);
		Color col2 = new Color(0, 0, 255);

		if (slide == 3) {
			for (AyushTextButton one : options) {
				if (!one.getBColor().equals(col2)) {
					if (one.isPointInButton(x, y)) {
						one.setBColor(col1);
					} else {
						one.setBColor(Color.white);
					}

				}
			}
		}
	}

	public void keyPressed() {

		// press g to quickly pass all the games
		if (key == 'g') {
			player.passGame(0);
			player.passGame(0);
			player.passGame(0);
			player.passGame(0);
			player.passGame(1);
			player.passGame(1);
			player.passGame(1);
			player.passGame(1);
			player.passGame(2);
			player.passGame(2);
			player.passGame(2);
			player.passGame(2);
			player.passGame(3);
			player.passGame(3);
			player.passGame(3);
			player.passGame(3);
			player.passGame(4);
			player.passGame(4);
			player.passGame(4);
			player.passGame(4);

		}
	}
}
