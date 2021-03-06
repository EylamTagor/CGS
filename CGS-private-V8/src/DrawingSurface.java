import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	private ArrayList<SohilButton> natsgames;
	private int slide;
	///birdblunder question 3, psycho question 2, space question0, driving quesiont 1
	private ArrayList<Question> wronganswers;
	private ArrayList<Question> filler1, filler2;
	private ArrayList<Question> parlibb, bizcommbb, bizprobb, infotechbb, mathbb,fblabb, bizbb;
	private ArrayList<Question> parlips, bizcommps, bizprops, infotechps, mathps,fblaps, bizps;
	private ArrayList<Question> parlis, bizcomms, bizpros, infotechs, maths,fblas, bizs;
	private ArrayList<Question> parlid, bizcommd, bizprod, infotechd, mathd,fblad, bizd;
	private SohilButton quit3;
	private SohilButton win, backtonats;

		
	public DrawingSurface() {
		player = new Player();
		player.earn(575);
		topics = new ArrayList<String>();
		wronganswers = new ArrayList<Question>();
		slide = 1;
		options = new AyushTextButton[7];
		options[0] = new AyushTextButton(30, 40,700,80,  130, 90, Color.WHITE, new Color(54, 141, 165), "Intro to Parliamentary Procedure", 30);
		options[1]  = new AyushTextButton(30,130,700, 80, 130, 180, Color.WHITE, new Color(54, 141, 165), "Intro to Business Communication", 30);
		options[2]  = new AyushTextButton(30, 220,700, 80, 150, 270, Color.WHITE, new Color(54, 141, 165), "Intro to Business Procedures", 30);
		options[3]  = new AyushTextButton(30,310,700, 80, 130, 360, Color.WHITE, new Color(54, 141, 165), "Intro to Information Technology", 30);
		options[4]  = new AyushTextButton(30,400,700, 80, 170, 450,Color.WHITE, new Color(54, 141, 165), "Intro to Financial Math", 30);
		options[5]  = new AyushTextButton(30,490,500, 80, 200, 540, Color.WHITE, new Color(54, 141, 165), "Intro to FBLA", 30);
		options[6]  = new AyushTextButton(30,580,500, 80, 200, 630, Color.WHITE, new Color(54, 141, 165), "Intro to Business", 30);
		
		
		natsgames = new ArrayList<SohilButton>();
		final int marginy = 10;
		final int marginx = 50;
		natsgames.add(new SohilButton("Game 1", 30, SohilButton.RECTANGLE, 25, 100, 350, 100));
		natsgames.add(new SohilButton("Game 2", 30, SohilButton.RECTANGLE, 25, natsgames.get(0).getY()  + natsgames.get(0).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Game 3", 30, SohilButton.RECTANGLE, 25, natsgames.get(1).getY()  + natsgames.get(1).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Game 4", 30, SohilButton.RECTANGLE, 25, natsgames.get(2).getY()  + natsgames.get(2).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Game 5", 30, SohilButton.RECTANGLE, 25, natsgames.get(3).getY()  + natsgames.get(3).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Game 6", 30, SohilButton.RECTANGLE, natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx, 100, 350, 90));
		natsgames.add(new SohilButton("Game 7", 30, SohilButton.RECTANGLE, natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx, natsgames.get(5).getY()  + natsgames.get(5).getHeight() + marginy, 350, 90 ));
		natsgames.add(new SohilButton("Game 8", 30, SohilButton.RECTANGLE, natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx, natsgames.get(6).getY()  + natsgames.get(6).getHeight() + marginy, 350, 90 ));
		natsgames.add(new SohilButton("Game 9", 30, SohilButton.RECTANGLE, natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx, natsgames.get(7).getY()  + natsgames.get(7).getHeight() + marginy, 350, 90 ));
		natsgames.add(new SohilButton("Game 10", 30, SohilButton.RECTANGLE, natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx, natsgames.get(8).getY()  + natsgames.get(8).getHeight() + marginy, 350, 90 ));
		
		win = new SohilButton("Claim your reward!", 20, SohilButton.RECTANGLE, 610, 400,50);
		
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
		game2 = new SohilButton("Game 2", 40, SohilButton.RECTANGLE, game1.getY() + game1.getHeight() + gameButtonMargin, 400, 100);
		game3 = new SohilButton("Game 3", 40, SohilButton.RECTANGLE, game2.getY() + game2.getHeight() + gameButtonMargin, 400, 100);
		game4 = new SohilButton("Game 4", 40, SohilButton.RECTANGLE, game3.getY() + game3.getHeight() + gameButtonMargin, 400, 100);

		backConference = new SohilButton("Back", 20, SohilButton.RECTANGLE, Main.width - 105, Main.height - 100, 75, 50);
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
			conferenceSelection.add(new SohilButton(((Integer) i).toString(), 40, SohilButton.CIRCLE, (Main.width/2) + (i-3) * confButtonDiff, 225, buttonWidth, buttonWidth));
		}
		
		conferenceSelection.add(nationals = new SohilButton("Nationals", 40, SohilButton.RECTANGLE, 300, 400, 100));
		conferenceSelection.add(quit = new SohilButton("Quit", 40, SohilButton.RECTANGLE, 425, 400, 100));
		quit3 = new SohilButton("Quit", 40, SohilButton.RECTANGLE, 550, 400, 100);
		proceedToNats = new SohilButton("Proceed to Nationals", 40, SohilButton.RECTANGLE, 450, 500,100);
		backtonats = new SohilButton("Back to Nationals", 40, SohilButton.RECTANGLE, 450, 500,100);

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
		
		filler1 = new ArrayList<Question>();
		filler2 = new ArrayList<Question>();
		
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
		
		
		for(int i = 0;i<100;i++) {
			filler1.add(new Question("test", "test", "test", "test", "test"));
			filler2.add(new Question("test", "test", "test", "test", "test"));
		}
		bizcommbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlibb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlibb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlibb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlibb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprobb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprobb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprobb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprobb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblabb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblabb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblabb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblabb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathbb.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced\n tomatoes, crisp dark-red \nlettuce leaves, and perfect \nrounds of sliced onion.\" \nThis is an example of what \ntype of text?", "descriptive", "persuasive", "instructional", "informative"));
		
		
		bizcommps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlips.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlips.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlips.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlips.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprops.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprops.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprops.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprops.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblaps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblaps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblaps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblaps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathps.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced \ntomatoes, crisp dark-red lettuce leaves, and perfect rounds \nof sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		
		
		bizcommd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcommd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlid.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlid.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlid.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlid.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprod.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprod.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprod.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizprod.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblad.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblad.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblad.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblad.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		mathd.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		
		
		bizcomms.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcomms.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcomms.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizcomms.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlis.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlis.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlis.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		parlis.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechs.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechs.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechs.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		infotechs.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizpros.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizpros.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizpros.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizpros.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizs.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizs.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizs.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		bizs.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblas.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblas.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblas.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		fblas.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		maths.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		maths.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		maths.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		maths.add(new Question("\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?", "descriptive", "persuasive", "instructional", "informative"));
		
	}
	
	public ArrayList<Question> getQueArray(String name, String game){
		
		if(game.equals("bb")) {
			if(name.equals("Intro to Parliamentary Procedure")) {
				return parlibb;
			}else if(name.equals("Intro to Information Technology")) {
				return infotechbb;
			}else if(name.equals("Intro to Business Procedures")) {
				return bizprobb;
			}else if(name.equals("Intro to Business Communication")) {
				return bizcommbb;
			}else if(name.equals("Intro to Financial Math")) {
				return mathbb;
			}else if(name.equals("Intro to FBLA")) {
				return fblabb;
			}else if(name.equals("Intro to Business")) {
				return bizbb;
			}
		}else if(game.equals("s")) {
			if(name.equals("Intro to Parliamentary Procedure")) {
				return parlis;
			}else if(name.equals("Intro to Information Technology")) {
				return infotechs;
			}else if(name.equals("Intro to Business Procedures")) {
				return bizpros;
			}else if(name.equals("Intro to Business Communication")) {
				return bizcomms;
			}else if(name.equals("Intro to Financial Math")) {
				return maths;
			}else if(name.equals("Intro to FBLA")) {
				return fblas;
			}else if(name.equals("Intro to Business")) {
				return bizs;
			}
		}else if(game.equals("ps")) {
			if(name.equals("Intro to Parliamentary Procedure")) {
				return parlips;
			}else if(name.equals("Intro to Information Technology")) {
				return infotechps;
			}else if(name.equals("Intro to Business Procedures")) {
				return bizprops;
			}else if(name.equals("Intro to Business Communication")) {
				return bizcommps;
			}else if(name.equals("Intro to Financial Math")) {
				return mathps;
			}else if(name.equals("Intro to FBLA")) {
				return fblaps;
			}else if(name.equals("Intro to Business")) {
				return bizps;
			}
		}else if(game.equals("d")) {
			if(name.equals("Intro to Parliamentary Procedure")) {
				return parlid;
			}else if(name.equals("Intro to Information Technology")) {
				return infotechd;
			}else if(name.equals("Intro to Business Procedures")) {
				return bizprod;
			}else if(name.equals("Intro to Business Communication")) {
				return bizcommd;
			}else if(name.equals("Intro to Financial Math")) {
				return mathd;
			}else if(name.equals("Intro to FBLA")) {
				return fblad;
			}else if(name.equals("Intro to Business")) {
				return bizd;
			}
		}
		
		return null;
		
	}
	
	public boolean is5Selected() {
		int selected = 0;;
		for(AyushTextButton e : options) {
			if(e.getBColor().equals(new Color(44, 44, 221))) {
				selected++;
			}
		}
		return selected == 5;
	}
	
	public void drawInstructions() {
		if(slide == 1) {
			background(38);
			fill(255,0,0);
			textFont( createFont(font, 100));
			text("Welcome to", 100, 130);
			text("FBLA Tester", 90 , 280);
			next.draw(this);
		}else if(slide == 2) {
			background(38);
			text("cutscene", 100,130);
			next.draw(this);
		}else if(slide == 4) {
			background(38);
			textSize(33);
			fill(255,0,0);
			text("Choose the 5 topics you want to study", 75, 25);
			options[0].draw(this);
			options[1].draw(this);
			options[2].draw(this);
			options[3].draw(this);
			options[4].draw(this);
			options[5].draw(this);
			options[6].draw(this);
			
			if(is5Selected()) {
				next2.draw(this);
				
			}
			

		}else if(slide == 3) {
			background(38);
			next2.draw(this);
			pushStyle();
			textAlign(CENTER, CENTER);
			text("Instructions", Main.width/2, confHeadHeight);
			popStyle();
		}
		
		else if(slide == 5) {
		
			for(AyushTextButton e: options) {
				if(e.getBColor().equals(new Color(44, 44, 221))) {
					topics.add(e.getText());
				}
			}
			theOnceBoolean = true;

		}
	}
	
	public void drawMain() {
		background(38);
		if (activeButton == backConference) 
			drawConferenceScreen();
			
		
		else if (activeButton == conferenceSelection.get(0))
			drawConference1();
		else if (activeButton == conferenceSelection.get(1))
			drawConference2();
		else if (activeButton == conferenceSelection.get(2))
			drawConference3();
		else if (activeButton == conferenceSelection.get(3))
			drawConference4();
		else if (activeButton == conferenceSelection.get(4))
			drawConference5();
		
		else if(activeButton == proceedToNats) {
			drawNatsConference();
			
		}
		else if(activeButton == natsgames.get(0)) {
			drawSpaceNatsGame(0);
			activeButton = proceedToNats;
		}else if(activeButton == natsgames.get(1)) {
			drawBirdBlunderNatsGame(1);
			activeButton = proceedToNats;

		}else if(activeButton == natsgames.get(2)) {
			drawPsychoSearchNatsGame(2);
			activeButton = proceedToNats;

		}else if(activeButton == natsgames.get(3)) {
			drawSpaceNatsGame(3);
			activeButton = proceedToNats;

		}else if(activeButton == natsgames.get(4)) {
			drawDrivingNatsGame(4);
			activeButton = proceedToNats;

		}else if(activeButton == natsgames.get(5)) {
			drawBirdBlunderNatsGame(5);
			activeButton = proceedToNats;

		}else if(activeButton == natsgames.get(6)) {
			drawSpaceNatsGame(6);
			activeButton = proceedToNats;

		}else if(activeButton == natsgames.get(7)) {
			drawPsychoSearchNatsGame(7);
			activeButton = proceedToNats;

		}else if(activeButton == natsgames.get(8)) {
			drawDrivingNatsGame(8);
			activeButton = proceedToNats;

		}else if(activeButton == natsgames.get(9)) {
			drawBirdBlunderNatsGame(9);
			activeButton = proceedToNats;

		}else if(activeButton == win) {
			drawWin();
		}else if(activeButton == backtonats) {
			drawNatsConference();
		}
		
		else if(activeButton == quit3) {
			System.exit(0);
		}
		
		if(wronganswers.size() >=10) {
			activeButton = null;
			drawFailure();
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
				
				if(activeButton == game4) {
					drawBirdBlunderGame();
					activeButton = b;
				}
			}
		}
		
		if (activeButton == nationals) {
			drawNationals();
			
		}
		if (activeButton == quit)
			exit();
		
//		System.out.println(Arrays.toString(player.getProgress()));
	}
	
	public void drawWin() {
		if(player.getProgress()[5]<3) {
			headingFormat();
			textSize(40);
			text("You haven't beaten "+ wronganswers.size() +" of those \ngames yet!", Main.width/2, confHeadHeight);
			backtonats.draw(this);
			if (backtonats.isPointInside(mouseX, mouseY)) {
				backtonats.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = backtonats;
				}
			} else {
				backtonats.setColor(new Color(135, 206, 255));
			}
		}else {
			headingFormat();
			text("YOU WON! CONGRATS!", Main.width/2, confHeadHeight);
			quit.draw(this);
			if (quit.isPointInside(mouseX, mouseY)) {
				quit.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = quit;
				}
			} else {
				quit.setColor(new Color(135, 206, 255));
			}
		}
	}
	
	public void drawDrivingNatsGame(int inde) {
		// TODO Auto-generated method stub

		final int speed = 20;
		Driving drawing = new Driving(wronganswers.get(inde), player, 5, speed, filler1, filler2, 1);
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
		canvas.requestFocus();	}

	public void drawPsychoSearchNatsGame(int inde) {
		// TODO Auto-generated method stub
		
		
		final int seconds = 15;
		PsychoSearch drawing = new PsychoSearch(wronganswers.get(inde),seconds, player, 5, filler1, filler2, 2);
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		drawing.setFrame(window);
		window.setSize(800, 700);
		window.setLocation(250, 20);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}

	public void drawBirdBlunderNatsGame(int inde) {
		// TODO Auto-generated method stub
		final int birdspersec = 6;
		BirdBlunder drawing = new BirdBlunder(wronganswers.get(inde),birdspersec, 5, player, filler1, filler2, inde);
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		drawing.setFrame(window);
		window.setSize(800, 700);
		window.setLocation(250, 20);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}

	public void drawSpaceNatsGame(int inde) {
		// TODO Auto-generated method stub
		final int speed = 2;
		Space drawing = new Space(wronganswers.get(inde), player, 5, speed, filler1, filler2, 0);
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

	public void drawFailure() {
		headingFormat();
		textSize(40);
		text("That is your tenth wrong question! \nObviously you haven't studied enough. \nCome back when you are better :(", Main.width/2, confHeadHeight +100);
		quit3.draw(this);			
		if (quit3.isPointInside(mouseX, mouseY)) {
			quit3.setColor(new Color(0, 191, 255));
			if (mousePressed) {
				activeButton = quit3;
				clickTime = millis();
			}
		} else {
			quit3.setColor(new Color(135, 206, 255));
		}
	}
	
	public void setup() {
		next = new ImageButton(loadImage("images\\next.png"), 300, 450, 200 ,200);
		next2 = new ImageButton(loadImage("images\\next.png"), 580, 500, 150 ,150);
	}
	
	public void drawNatsConference() {
		
		headingFormat();
		if(wronganswers.size() == 0) {
			textSize(45);
			text("You got all the questions right! \nYou won the game, no national\n conference for geniuses like you! \n:)", Main.width/2, confHeadHeight+150);
			quit3.draw(this);			
			if (quit3.isPointInside(mouseX, mouseY)) {
				quit3.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = quit3;
					clickTime = millis();
				}
			} else {
				quit3.setColor(new Color(135, 206, 255));
			}
		}else {
			headingFormat();
			
			
			
			text("Nationals", Main.width/2, confHeadHeight-50);
			for(int i = 0;i<wronganswers.size();i++) {
				SohilButton e = natsgames.get(i);
				e.draw(this);
				if(e.isPointInside(mouseX, mouseY)) {
					//System.out.println("here");
					e.setColor(new Color(0, 191, 255));
					
					//System.out.println("here2");
					if(mousePressed) {
						activeButton = e;
					}
				}else {
					e.setColor(new Color(135, 206, 255));
				}
				
				
			}
			win.draw(this);
			if (win.isPointInside(mouseX, mouseY)) {
				win.setColor(new Color(0, 191, 255));
				if (mousePressed) {
					activeButton = win;
				}
			} else {
				win.setColor(new Color(135, 206, 255));
			}
		}
		
		
	}
	
	public void drawBirdBlunderGame() {
		// TODO Auto-generated method stub
		

		ArrayList<Question> as = getQueArray(topics.get(spaceConfIndicator), "bb");
		final int birdspersec = 3;
		BirdBlunder drawing = new BirdBlunder(as.get(3),birdspersec, spaceConfIndicator, player, as, wronganswers, 3);
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		drawing.setFrame(window);
		window.setSize(800, 700);
		window.setLocation(250, 20);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
		
	}

	public void drawSpaceGame() {
		// change drawing's type to whatever game you want to run (or duplicate for each
		// game if you want
		ArrayList<Question> as = getQueArray(topics.get(spaceConfIndicator), "s");
		final int speed = 1;
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
		PsychoSearch drawing = new PsychoSearch(as.get(2),seconds, player, spaceConfIndicator, as, wronganswers, 2);
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		drawing.setFrame(window);
		window.setSize(800, 700);
		window.setLocation(250, 20);
		window.setMinimumSize(new Dimension(100,100));
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
		for(int i = 0;i<prog.length - 1;i++) {
			int e = prog[i];
			if(e<4) {
				hasPassedConfs = false;
			}
		}
		if(hasPassedConfs) {
			headingFormat();
			textSize(50);
			text("Congrats on passing all of the \nconferences!", Main.width/2+10, confHeadHeight);
			text("The National Conference is \ndesigned to test all of the \nquestions you got wrong", Main.width/2+10, confHeadHeight+200);

			proceedToNats.draw(this);
			if(proceedToNats.isPointInside(mouseX, mouseY)) {
				proceedToNats.setColor(new Color(0,191,255));
				if(mousePressed) {
					activeButton = proceedToNats;
				}
			}else {
				proceedToNats.setColor(new Color(135, 206, 255));
			}
			
		}else {
			headingFormat();
			text("Not yet!\nFinish all of the \nconferences first.", Main.width/2, confHeadHeight+200);
		}
	}
	
	public void drawConferenceScreen() {
		headingFormat();
		text("Conferences", Main.width/2, confHeadHeight);
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
		//System.out.println(player.getProgress()[0]);
		progressBars.get(0).draw(this);
		headingFormat();
		textSize(45);

		text(topics.get(0), Main.width/2, confHeadHeight);
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
		text(topics.get(1), Main.width/2, confHeadHeight);
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
		text(topics.get(2), Main.width/2, confHeadHeight);
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
		text(topics.get(3), Main.width/2, confHeadHeight);
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
		text(topics.get(4), Main.width/2, confHeadHeight);
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
		
		Color col1 = new Color(44, 44, 221);
		Color col2 = new Color(0,255,255);

		if(!theOnceBoolean) {
			if(slide == 1) {
				if(mouseButton == LEFT) {
					if(next.isPointInButton(mouseX, mouseY)) {
						slide++;
					}
				}
				
			}else if(slide == 2) {
				if(mouseButton == LEFT) {
					if(next.isPointInButton(mouseX, mouseY)) {
						slide++;
					}
				}
			}else if(slide == 4) {
				if(mouseButton == LEFT) {
					
					if(next2.isPointInButton(x,y) && is5Selected()) {
						slide++;
					}
					
					for(int i =0;i<options.length;i++) {
						if(options[i].isPointInButton(x, y)) {
							if(options[i].getBColor().equals(col1)) {
								options[i].setBColor(col2);
							}else {
								options[i].setBColor(col1);
		
							}
						}
					}
				}
			}else if(slide == 3) {
				if(next2.isPointInButton(x, y)) {
					slide = 4;
				}
			}
		}
		
	}

	public void mouseMoved() {
		int x = mouseX;
		int y = mouseY;
		Color col1 = new Color(28, 221, 221);
		Color col2 = new Color(44, 44, 221);
		Color col3 = new Color(54, 141, 165);

		
		
		if(slide ==4 ) {
			for(AyushTextButton one : options) {
				if(!one.getBColor().equals(col2) ) {
					if(one.isPointInButton(x, y)) {
						one.setBColor(col1);
					}else {
						one.setBColor(col3);
					}
					
				}
			}
		}
	}
	
	public void keyPressed() {
		
		//press g to quickly pass all the games
		if(key == 'g') {
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
			

		}else if(key == 'h') {
			wronganswers.add(new Question("test11", "test1", "test", "test", "test"));
			wronganswers.add(new Question("test22", "test1", "test", "test", "test"));
			wronganswers.add(new Question("test33", "test1", "test", "test", "test"));
			wronganswers.add(new Question("test44", "test1", "test", "test", "test"));
			//wronganswers.add(new Question("test", "test", "test", "test", "test"));
			

		}
	}
}
