package running;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import buttons.AyushTextButton;
import buttons.ImageButton;
import buttons.SohilButton;
import buttons.TextButton;
import games.driving.Driving;
import games.flashlight.Flashlight;
import games.flight.Flight;
import games.space.Space;
import other.Player;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class FBLATriviaTester extends PApplet {
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
	private SohilButton gamemessagebutton;
	/// birdblunder question 3, psycho question 2, space question0, driving quesiont
	/// 1
	private ArrayList<Question> wronganswers;
	private ArrayList<String> rightAnswers;
	private ArrayList<Question> filler1, filler2;
	private ArrayList<Question> parlibb, bizcommbb, bizprobb, infotechbb, mathbb, fblabb, bizbb;
	private ArrayList<Question> parlips, bizcommps, bizprops, infotechps, mathps, fblaps, bizps;
	private ArrayList<Question> parlis, bizcomms, bizpros, infotechs, maths, fblas, bizs;
	private ArrayList<Question> parlid, bizcommd, bizprod, infotechd, mathd, fblad, bizd;
	private SohilButton quit3;
	private SohilButton win, backtonats;
	private ProgressBar confs, nats;
	private int status = 1; // 1 instructinos 2 win 3 dnats 4 psnats 5 bbnats 6 snats 7 fail 8 natsconf 9 bb
							// 10 space 11 driving 12 ps 13 nats 14 confscreen 15 conf1 16 conf2 17 conf3 18
							// conf4 19 conf5 20 playgame

	public FBLATriviaTester() {
		player = new Player();
		player.earn(575);
		topics = new ArrayList<String>();
		wronganswers = new ArrayList<Question>();
		rightAnswers = new ArrayList<String>();
		slide = 1;
		options = new AyushTextButton[7];
		options[0] = new AyushTextButton(30, 40, 700, 80, 130, 90, Color.WHITE, new Color(54, 141, 165),
				"Intro to Parliamentary Procedure", 30);
		options[1] = new AyushTextButton(30, 130, 700, 80, 130, 180, Color.WHITE, new Color(54, 141, 165),
				"Intro to Business Communication", 30);
		options[2] = new AyushTextButton(30, 220, 700, 80, 150, 270, Color.WHITE, new Color(54, 141, 165),
				"Intro to Business Procedures", 30);
		options[3] = new AyushTextButton(30, 310, 700, 80, 130, 360, Color.WHITE, new Color(54, 141, 165),
				"Intro to Information Technology", 30);
		options[4] = new AyushTextButton(30, 400, 700, 80, 170, 450, Color.WHITE, new Color(54, 141, 165),
				"Intro to Financial Math", 30);
		options[5] = new AyushTextButton(30, 490, 500, 80, 200, 540, Color.WHITE, new Color(54, 141, 165),
				"Intro to FBLA", 30);
		options[6] = new AyushTextButton(30, 580, 500, 80, 200, 630, Color.WHITE, new Color(54, 141, 165),
				"Intro to Business", 30);

		natsgames = new ArrayList<SohilButton>();
		final int marginy = 10;
		final int marginx = 50;
		natsgames.add(new SohilButton("Space Game", 30, SohilButton.RECTANGLE, 25, 100, 350, 90));
		natsgames.add(new SohilButton("Flight Game", 30, SohilButton.RECTANGLE, 25,
				natsgames.get(0).getY() + natsgames.get(0).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Flashlight Game", 30, SohilButton.RECTANGLE, 25,
				natsgames.get(1).getY() + natsgames.get(1).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Space Game", 30, SohilButton.RECTANGLE, 25,
				natsgames.get(2).getY() + natsgames.get(2).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Driving Game", 30, SohilButton.RECTANGLE, 25,
				natsgames.get(3).getY() + natsgames.get(3).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Flight Game", 30, SohilButton.RECTANGLE,
				natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx, 100, 350, 90));
		natsgames.add(new SohilButton("Space Game", 30, SohilButton.RECTANGLE,
				natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx,
				natsgames.get(5).getY() + natsgames.get(5).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Flashlight Game", 30, SohilButton.RECTANGLE,
				natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx,
				natsgames.get(6).getY() + natsgames.get(6).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Driving Game", 30, SohilButton.RECTANGLE,
				natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx,
				natsgames.get(7).getY() + natsgames.get(7).getHeight() + marginy, 350, 90));
		natsgames.add(new SohilButton("Flight Game", 30, SohilButton.RECTANGLE,
				natsgames.get(0).getX() + natsgames.get(0).getWidth() + marginx,
				natsgames.get(8).getY() + natsgames.get(8).getHeight() + marginy, 350, 90));

		win = new SohilButton("Claim your reward!", 20, SohilButton.RECTANGLE, 610, 400, 50);

		initializeQuestionArrays();

		font = "Verdana";

		back = new TextButton(10, 10, 120, 25, 15, 25, 255, 200, 200, 0, 0, 0, "Back to conference");
		jacket = new TextButton(75, 100, 300, 100, 150, 150, 200, 255, 200, 0, 0, 0, "Jacket: $250");
		shirt = new TextButton(425, 100, 300, 100, 500, 150, 200, 255, 200, 0, 0, 0, "Shirt: $75");
		slacks = new TextButton(75, 250, 300, 100, 150, 300, 200, 255, 200, 0, 0, 0, "Slacks: $100");
		shoes = new TextButton(425, 250, 300, 100, 500, 300, 200, 255, 200, 0, 0, 0, "Shoes: $75");
		belt = new TextButton(75, 400, 300, 100, 150, 450, 200, 255, 200, 0, 0, 0, "Belt: $25");
		tie = new TextButton(425, 400, 300, 100, 500, 450, 200, 255, 200, 0, 0, 0, "Tie: $50");

		game1 = new SohilButton("Space Game", 40, SohilButton.RECTANGLE, 150, 400, 100);
		game2 = new SohilButton("Driving Game", 40, SohilButton.RECTANGLE,
				game1.getY() + game1.getHeight() + gameButtonMargin, 400, 100);
		game3 = new SohilButton("Flashlight Game", 40, SohilButton.RECTANGLE,
				game2.getY() + game2.getHeight() + gameButtonMargin, 400, 100);
		game4 = new SohilButton("Flight Game", 40, SohilButton.RECTANGLE,
				game3.getY() + game3.getHeight() + gameButtonMargin, 400, 100);

		backConference = new SohilButton("Back", 20, SohilButton.RECTANGLE, Main.width - 105, Main.height - 100, 75,
				50);
		activeButton = backConference;

		progressBars = new ArrayList<ProgressBar>();
		for (int i = 0; i < 5; i++) {
			progressBars.add(new ProgressBar("", 200, game4.getY() + game4.getHeight() - 25, 400, 100, 0, 4));
		}
		confs = new ProgressBar("Conference Progress", 200, game4.getY() + game4.getHeight() - 25, 400, 100, 0, 5);
		nats = new ProgressBar("Nationals Progress", 200, game4.getY() + game4.getHeight() - 25, 400, 100, 0, 5);

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
		quit3 = new SohilButton("Quit", 40, SohilButton.RECTANGLE, 550, 400, 100);
		proceedToNats = new SohilButton("Proceed to Nationals", 40, SohilButton.RECTANGLE, 450, 500, 100);
		backtonats = new SohilButton("Back to Nationals", 40, SohilButton.RECTANGLE, 450, 500, 100);
		gamemessagebutton = new SohilButton("d", marginx, marginx, frameRate, frameRate, frameRate);
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

		/***** BB *****/
		bizcommbb.add(new Question(
				"\"The hamburger was piled high\nwith juicy, red, thick-sliced\ntomatoes.\" This is an example\nof what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommbb.add(new Question("Which plural of the word is\nNOT correct?", "ski--skiis", "witch--witches",
				"cactus--cacti", "Jones--Joneses"));
		bizcommbb.add(new Question("Which one of the following\nwords is spelled correctly?", "leisure", "rateing",
				"doubtfull", "familys"));
		bizcommbb.add(new Question(
				"There is always one group that\nopposes all suggestions. That\n_____ always resists change.",
				"faction", "herd", "heard", "fraction"));

		parlibb.add(new Question("Which article in the FBLA bylaws\ndescribes the information\nabout FBLA dues?",
				"Article IV", "Article III", "Artivle VI", "Artivle V"));
		parlibb.add(new Question("Viva voce means:", "voice vote", "for motion", "no objection", "objection"));
		parlibb.add(new Question("Rescind means:", "cancel", "consideration", "give way to", "no objection"));
		parlibb.add(new Question(
				"The secretary must apply at\nleast _____ copies of the\nminutes to the necessary\nauthorities.", "two",
				"four", "three", "one"));
		infotechbb.add(new Question("Compressed files, or ____ files,\nusually have a _____ extension.", "zipped; .zip",
				"tipped; .tip", "joint; .jnt", "dipped; .dip"));
		infotechbb.add(new Question("A(n) _____ allows you to create,\nupdate, and administer a\nrelational database.",
				"RDBMS", "XML DBMS", "OODBMS", "ERD"));
		infotechbb.add(new Question(
				"Communication between all of\nthe different devices on the\nInternet is made possible by:", "TCP/IP",
				"HTTP", "FTP", "AT&T"));
		infotechbb.add(new Question("Some search engines use _\ninstead of the word NOT.", "-", "=", "*", "^"));
		bizprobb.add(new Question("If something is at the tertiary\nlevel, it appears:", "third", "thirteenth", "first",
				"second"));
		bizprobb.add(new Question("What ratio should be\ndetermined to calculate the\nearning power of a business?",
				"profitability", "quick", "earnings", "expenditure"));
		bizprobb.add(new Question(
				"A(n) ____ is a good opportunity\nto ask specific questions\nabout the job opening, career\npaths, and the company.",
				"interview", "phone call", "career day", "job app\nsession"));
		bizprobb.add(new Question("The easiest way to become\na business owner is to:", "buy stock",
				"purchase a\nfranchise", "start one", "find partner(s)"));
		bizbb.add(new Question(
				"_____ marketing involves\ndeveloping a unique mix of\ngoods and services for each\nindividual customer.",
				"One-to-one", "B2B", "Usage", "Volume"));
		bizbb.add(new Question(
				"Groups of people such as\nworkers who pool their money\ntogether for savings and to\nmake loans is called a:",
				"credit union", "union bank", "state union", "labor union"));
		bizbb.add(new Question("When compared to a traditional\nsavings account, a certificate\nof deposit is:",
				"less liquid", "equally liquid", "more dynamic", "more liquid"));
		bizbb.add(
				new Question("Spending a few hours\nobserving someone in your\nchosen occupation is called job\n_____.",
						"shadowing", "training", "orientation", "mentoring"));
		fblabb.add(new Question(
				"A parliamentary procedure\nteam can have ______ repeat\nmembers from a previous\nNational Leadership\nConference team.",
				"two", "one", "three", "none"));
		fblabb.add(new Question("Handbooks for officers can\nbe purchased from:", "MarketPlace", "Barnes & Noble",
				"NAP Committee", "board of\ndirectors"));
		fblabb.add(new Question("The Chapter Management\nHandbook updates are revised\nand distributed:", "annually",
				"as needed", "biannually", "every 2yrs"));
		fblabb.add(new Question("FBLA-PBL week is the second\nweek in:", "Feb.", "Jan.", "Mar.", "Apr."));
		mathbb.add(new Question("If 80% > 0.75, then:", "4/5 > 3/4", "4/5 < 3/4", "80% = 0.75", "80% = 3/4"));
		mathbb.add(new Question(
				"The gross weight of a can of\nsoup is 12.2 oz. If the can\nweighs 1.3 oz, what is the net\nweight of the soup?",
				"10.9 oz", "13.5 oz", "12.2 oz", "15.86 oz"));
		mathbb.add(new Question("Determine the average of 90,\n66, 84, 72, 98.", "82", "90", "102", "80"));
		mathbb.add(new Question("The best way to depict a future\nprediction is by using a:", "line chart", "bar chart",
				"histogram", "pie chart"));

		/***** PS *****/
		bizcommps.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced\ntomatoes.\"This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommps.add(new Question("Which plural of the word is NOT correct?", "ski--skiis", "witch--witches",
				"cactus--cacti", "Jones--Joneses"));
		bizcommps.add(new Question("Which one of the following words is spelled correctly?", "leisure", "rateing",
				"doubtfull", "familys"));
		bizcommps.add(new Question(
				"There is always one group that opposes all suggestions.\nThat _____ always resists change.", "faction",
				"herd", "heard", "fraction"));

		parlips.add(new Question("Which article in the FBLA bylaws describes\nthe information about FBLA dues?",
				"Article IV", "Article III", "Artivle VI", "Artivle V"));
		parlips.add(new Question("Viva voce means:", "voice vote", "for motion", "no objection", "objection"));
		parlips.add(new Question("Rescind means:", "cancel", "consideration", "give way to", "no objection"));
		parlips.add(new Question(
				"The secretary must apply at least _____ copies\nof the minutes to the necessary authorities.", "two",
				"four", "three", "one"));
		infotechps.add(new Question("Compressed files, or _____ files, usually have a _____\nextension.",
				"zipped; .zip", "tipped; .tip", "joint; .jnt", "dipped; .dip"));
		infotechps.add(new Question("A(n) _____ allows you to create, update,\nand administer a relational database.",
				"RDBMS", "XML DBMS", "OODBMS", "ERD"));
		infotechps.add(
				new Question("Communication between all of the different\ndevices on the Internet is mad possible by:",
						"TCP/IP", "HTTP", "FTP", "AT&T"));
		infotechps.add(new Question("Some search engines use _ instead of the word NOT.", "-", "=", "*", "^"));
		bizprops.add(new Question("If something is at the tertiary level, it appears:", "third", "thirteenth", "first",
				"second"));
		bizprops.add(new Question("What ratio should be determined to calculate the\nearning power of a business?",
				"profitability", "quick", "earnings", "expenditure"));
		bizprops.add(new Question(
				"A(n) ______________ is a good opportunity to ask specific\nquestions about the job opening, career paths, and the\ncompany.",
				"interview", "phone call", "career day", "job app\nsession"));
		bizprops.add(new Question("The easiest way to become a business owner is to:", "buy stock",
				"purchase a\nfranchise", "start one", "find partner(s)"));
		bizps.add(new Question(
				"__________ marketing involves developing a unique\nmix of goods and services for each individual customer.",
				"One-to-one", "B2B", "Usage", "Volume"));
		bizps.add(new Question(
				"Groups of people such as workers who pool their\nmoney together for savings and to make loans is called a:",
				"credit union", "union bank", "state union", "labor union"));
		bizps.add(new Question("When compared to a traditional\nsavings account, a certificate of deposit is:",
				"less liquid", "equally liquid", "more dynamic", "more liquid"));
		bizps.add(new Question("Spending a few hours observing\nsomeone in your chosen occupation is called job _____.",
				"shadowing", "training", "orientation", "mentoring"));
		fblaps.add(new Question(
				"A parliamentary procedure team can have ______ repeat\nmembers from a previous National Leadership Conference\nteam.",
				"two", "one", "three", "none"));
		fblaps.add(new Question("Handbooks for officers can be puchased from:", "MarketPlace", "Barnes & Noble",
				"NAP Committee", "board of\ndirectors"));
		fblaps.add(new Question("The Chapter Management Handbook\nupdates are revised and distributed:", "annually",
				"as needed", "biannually", "every 2yrs"));
		fblaps.add(new Question("FBLA-PBL week is the second week in:", "Feb.", "Jan.", "Mar.", "Apr."));
		mathps.add(new Question("If 80% > 0.75, then:", "4/5 > 3/4", "4/5 < 3/4", "80% = 0.75", "80% = 3/4"));
		mathps.add(new Question(
				"The gross weight of a can of soup is 12.2 oz.\nIf the can weighs 1.3 oz, what is the net weight of the soup?",
				"10.9 oz", "13.5 oz", "12.2 oz", "15.86 oz"));
		mathps.add(new Question("Determine the average of 90, 66, 84, 72, 98.", "82", "90", "102", "80"));
		mathps.add(new Question("The best way to depict a future prediction is by using a:", "line chart", "bar chart",
				"histogram", "pie chart"));

		/***** D *****/
		bizcommd.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes.\"\nThis is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcommd.add(new Question("Which plural of the word is NOT correct?", "ski--skiis", "witch--witches",
				"cactus--cacti", "Jones--Joneses"));
		bizcommd.add(new Question("Which one of the following words is spelled correctly?", "leisure", "rateing",
				"doubtfull", "familys"));
		bizcommd.add(new Question(
				"There is always one group that opposes all suggestions.\nThat _____ always resists change.", "faction",
				"herd", "heard", "fraction"));

		parlid.add(new Question("Which article in the FBLA bylaws describes\nthe information about FBLA dues?",
				"Article IV", "Article III", "Artivle VI", "Artivle V"));
		parlid.add(new Question("Viva voce means:", "voice vote", "for motion", "no objection", "objection"));
		parlid.add(new Question("Rescind means:", "cancel", "consideration", "give way to", "no objection"));
		parlid.add(new Question(
				"The secretary must apply at least _____ copies\nof the minutes to the necessary authorities.", "two",
				"four", "three", "one"));
		infotechd.add(new Question("Compressed files, or _____ files, usually have a _____ extension", "zipped; .zip",
				"tipped; .tip", "joint; .jnt", "dipped; .dip"));
		infotechd.add(new Question("A(n) _____ allows you to create, update,\nand administer a relational database.",
				"RDBMS", "XML DBMS", "OODBMS", "ERD"));
		infotechd.add(
				new Question("Communication between all of the different\ndevices on the Internet is mad possible by:",
						"TCP/IP", "HTTP", "FTP", "AT&T"));
		infotechd.add(new Question("Some search engines use _ instead of the word NOT.", "-", "=", "*", "^"));
		bizprod.add(new Question("If something is at the tertiary level, it appears:", "third", "thirteenth", "first",
				"second"));
		bizprod.add(new Question("What ratio should be determined to calculate the\nearning power of a business?",
				"profitability", "quick", "earnings", "expenditure"));
		bizprod.add(new Question(
				"A(n) ______________ is a good opportunity to ask specific\nquestions about the job opening, career paths, and the company.",
				"interview", "phone call", "career day", "job app\nsession"));
		bizprod.add(new Question("The easiest way to become a business owner is to:", "buy stock",
				"purchase a\nfranchise", "start one", "find partner(s)"));
		bizd.add(new Question(
				"__________ marketing involves developing a unique\nmix of goods and services for each individual customer.",
				"One-to-one", "B2B", "Usage", "Volume"));
		bizd.add(new Question(
				"Groups of people such as workers who pool their\nmoney together for savings and to make loans is called a:",
				"credit union", "union bank", "state union", "labor union"));
		bizd.add(new Question("When compared to a traditional\nsavings account, a certificate of deposit is:",
				"less liquid", "equally liquid", "more dynamic", "more liquid"));
		bizd.add(new Question("Spending a few hours observing\nsomeone in your chosen occupation is called job _____",
				"shadowing", "training", "orientation", "mentoring"));
		fblad.add(new Question(
				"A parliamentary procedure team can have ______ repeat members\nfrom a previous National Leadership Conference team.",
				"two", "one", "three", "none"));
		fblad.add(new Question("Handbooks for officers can be puchased from:", "MarketPlace", "Barnes & Noble",
				"NAP Committee", "board of\ndirectors"));
		fblad.add(new Question("The Chapter Management Handbook\nupdates are revised and distributed:", "annually",
				"as needed", "biannually", "every 2yrs"));
		fblad.add(new Question("FBLA-PBL week is the second week in:", "Feb.", "Jan.", "Mar.", "Apr."));
		mathd.add(new Question("If 80% > 0.75, then:", "4/5 > 3/4", "4/5 < 3/4", "80% = 0.75", "80% = 3/4"));
		mathd.add(new Question(
				"The gross weight of a can of soup is 12.2 oz.\nIf the can weighs 1.3 oz, what is the net weight of the soup?",
				"10.9 oz", "13.5 oz", "12.2 oz", "15.86 oz"));
		mathd.add(new Question("Determine the average of 90, 66, 84, 72, 98.", "82", "90", "102", "80"));
		mathd.add(new Question("The best way to depict a future prediction is by using a:", "line chart", "bar chart",
				"histogram", "pie chart"));

		/***** S *****/
		bizcomms.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes.\"\nThis is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcomms.add(new Question("Which plural of the word is NOT correct?", "ski--skiis", "witch--witches",
				"cactus--cacti", "Jones--Joneses"));
		bizcomms.add(new Question("Which one of the following words is spelled correctly?", "leisure", "rateing",
				"doubtfull", "familys"));
		bizcomms.add(new Question(
				"There is always one group that opposes all suggestions.\nThat _____ always resists change.", "faction",
				"herd", "heard", "fraction"));

		parlis.add(new Question("Which article in the FBLA bylaws describes\nthe information about FBLA dues?",
				"Article IV", "Article III", "Artivle VI", "Artivle V"));
		parlis.add(new Question("Viva voce means:", "voice vote", "for motion", "no objection", "objection"));
		parlis.add(new Question("Rescind means:", "cancel", "consideration", "give way to", "no objection"));
		parlis.add(new Question(
				"The secretary must apply at least _____ copies\nof the minutes to the necessary authorities.", "two",
				"four", "three", "one"));
		infotechs.add(new Question("Compressed files, or _____ files, usually have a _____ extension", "zipped; .zip",
				"tipped; .tip", "joint; .jnt", "dipped; .dip"));
		infotechs.add(new Question("A(n) _____ allows you to create, update,\nand administer a relational database.",
				"RDBMS", "XML DBMS", "OODBMS", "ERD"));
		infotechs.add(
				new Question("Communication between all of the different\ndevices on the Internet is mad possible by:",
						"TCP/IP", "HTTP", "FTP", "AT&T"));
		infotechs.add(new Question("Some search engines use _ instead of the word NOT.", "-", "=", "*", "^"));
		bizpros.add(new Question("If something is at the tertiary level, it appears:", "third", "thirteenth", "first",
				"second"));
		bizpros.add(new Question("What ratio should be determined to calculate the\nearning power of a business?",
				"profitability", "quick", "earnings", "expenditure"));
		bizpros.add(new Question(
				"A(n) ______________ is a good opportunity to ask specific\nquestions about the job opening, career paths, and the company.",
				"interview", "phone call", "career day", "job app\nsession"));
		bizpros.add(new Question("The easiest way to become a business owner is to:", "buy stock",
				"purchase a\nfranchise", "start one", "find partner(s)"));
		bizs.add(new Question(
				"__________ marketing involves developing a unique\nmix of goods and services for each individual customer.",
				"One-to-one", "B2B", "Usage", "Volume"));
		bizs.add(new Question(
				"Groups of people such as workers who pool their\nmoney together for savings and to make loans is called a:",
				"credit union", "union bank", "state union", "labor union"));
		bizs.add(new Question("When compared to a traditional\nsavings account, a certificate of deposit is:",
				"less liquid", "equally liquid", "more dynamic", "more liquid"));
		bizs.add(new Question("Spending a few hours observing someone in your chosen occupation is called job _____",
				"shadowing", "training", "orientation", "mentoring"));
		fblas.add(new Question(
				"A parliamentary procedure team can have ______ repeat members\nfrom a previous National Leadership Conference team.",
				"two", "one", "three", "none"));
		fblas.add(new Question("Handbooks for officers can be puchased from:", "MarketPlace", "Barnes & Noble",
				"NAP Committee", "board of\ndirectors"));
		fblas.add(new Question("The Chapter Management Handbook\nupdates are revised and distributed:", "annually",
				"as needed", "biannually", "every 2yrs"));
		fblas.add(new Question("FBLA-PBL week is the second week in:", "Feb.", "Jan.", "Mar.", "Apr."));
		maths.add(new Question("If 80% > 0.75, then:", "4/5 > 3/4", "4/5 < 3/4", "80% = 0.75", "80% = 3/4"));
		maths.add(new Question(
				"The gross weight of a can of soup is 12.2 oz.\nIf the can weighs 1.3 oz, what is the net weight of the soup?",
				"10.9 oz", "13.5 oz", "12.2 oz", "15.86 oz"));
		maths.add(new Question("Determine the average of 90, 66, 84, 72, 98.", "82", "90", "102", "80"));
		maths.add(new Question("The best way to depict a future prediction is by using a:", "line chart", "bar chart",
				"histogram", "pie chart"));
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

	public boolean is5Selected() {
		int selected = 0;
		;
		for (AyushTextButton e : options) {
			if (e.getBColor().equals(new Color(44, 44, 221))) {
				selected++;
			}
		}
		return selected == 5;
	}

	public void playGameMessage() {
		headingFormat();
		text("Return to\nNationals.", Main.width / 2, confHeadHeight + 200);
		backtonats.draw(this);

	}

	public void drawInstructions() {

		// if(status == 1) {
		if (slide == 1) {
			background(38);
			fill(255);
			textFont(createFont(font, 100));
			text("Welcome to", 100, 130);
			pushStyle();
			textAlign(CENTER);
			text("FBLA Trivia \nTester", Main.width / 2, 280);
			popStyle();
			next.draw(this);
		} else if (slide == 2) {
			background(38);
			textSize(18);
			fill(255);
			text("You recently heard about a club at your school called Future Business Leaders\nof America. Having nothing better to do, you decided to join and attend the\nnext meeting. You were so overwhelmed by the remarkable people and\nachievements that your school's chapter has that you immediately wanted to\nbecome a part of it.\n\nFast-forward to your tryout day for competitions. There were so many options\nto choose from, but you eventually settled for seven. Unfortuately, this year\nthe officers only let competitors have up to five competitions. ",
					50, 50);
			next.draw(this);
		} else if (slide == 4) {
			background(38);
			textSize(20);
			fill(255);
			text("Choose the 5 topics you want to study (only then can you proceed).", 25, 25);
			options[0].draw(this);
			options[1].draw(this);
			options[2].draw(this);
			options[3].draw(this);
			options[4].draw(this);
			options[5].draw(this);
			options[6].draw(this);

			if (is5Selected()) {
				next2.draw(this);

			}

		} else if (slide == 3) {
			background(38);
			next2.draw(this);
			pushStyle();
			textAlign(CENTER, CENTER);
			textSize(80);
			text("Instructions", Main.width / 2, confHeadHeight - 25);
			textSize(18);
			textAlign(BOTTOM, LEFT);
			text("On the next screen, you will select the competitions you want to compete in. \nOnce the game launches, go to each conference, which is focused on a certain \ntopic that you chose, and beat all of the games by answering the questions \ncorrectly in the games. You will know when the conference is complete when the \nprogress bar on the current conference's screen is full. \n\nWhen that happens for all of the conferences, which you will know when the \nprogress bar at the screen with all the conferences is full, press the Nationals \nbutton to go to the National Conference, where you will be tested on all of the \nquestions that you answered incorrectly. However, to ensure you know the \nanswers, the question will be the same but the games used to test them will be \nmuch more fast-paced. If there are no wrong answers, you automatically pass \nNationals! \n\nPress ESCAPE at any time to completely quit the game, \nand if you want to quit a certain minigame, the games \nalways have a quit button at the ready. ",
					50, 150);
			popStyle();
		}

		else if (slide == 5) {
			for (AyushTextButton e : options) {
				if (e.getBColor().equals(new Color(44, 44, 221))) {
					topics.add(e.getText());
				}
			}
			theOnceBoolean = true;

		}
		// }

	}

	public void drawMain() {
		confs.setProgress(0);
		for (int e : player.getProgress()) {
			if (e >= 4) {
				confs.increaseProgress(1);
			}
		}
		background(38);

		if (activeButton == backConference) {
			status = 14;
			drawConferenceScreen();
		} else if (activeButton == conferenceSelection.get(0)) {
			status = 15;
			drawConference1();

		} else if (activeButton == conferenceSelection.get(1)) {
			status = 16;

			drawConference2();
		} else if (activeButton == conferenceSelection.get(2)) {
			status = 17;

			drawConference3();
		} else if (activeButton == conferenceSelection.get(3)) {
			status = 18;

			drawConference4();
		} else if (activeButton == conferenceSelection.get(4)) {
			status = 19;

			drawConference5();
		} else if (activeButton == proceedToNats) {
			status = 8;

			drawNatsConference();
		} else if (activeButton == natsgames.get(0)) {
			status = 20;

			drawSpaceNatsGame(0);
			activeButton = gamemessagebutton;
		} else if (activeButton == natsgames.get(1)) {
			status = 20;

			drawBirdBlunderNatsGame(1);
			activeButton = gamemessagebutton;

		} else if (activeButton == natsgames.get(2)) {
			status = 20;

			drawPsychoSearchNatsGame(2);
			activeButton = gamemessagebutton;

		} else if (activeButton == natsgames.get(3)) {
			status = 20;

			drawSpaceNatsGame(3);
			activeButton = gamemessagebutton;

		} else if (activeButton == natsgames.get(4)) {
			status = 20;

			drawDrivingNatsGame(4);
			activeButton = gamemessagebutton;

		} else if (activeButton == natsgames.get(5)) {
			status = 20;

			drawBirdBlunderNatsGame(5);
			activeButton = gamemessagebutton;

		} else if (activeButton == natsgames.get(6)) {
			status = 20;

			drawSpaceNatsGame(6);
			activeButton = gamemessagebutton;

		} else if (activeButton == natsgames.get(7)) {
			status = 20;

			drawPsychoSearchNatsGame(7);
			activeButton = gamemessagebutton;
		} else if (activeButton == natsgames.get(8)) {
			status = 20;

			drawDrivingNatsGame(8);
			activeButton = gamemessagebutton;

		} else if (activeButton == natsgames.get(9)) {
			status = 20;

			drawBirdBlunderNatsGame(9);
			activeButton = gamemessagebutton;

		} else if (activeButton == win) {
			status = 2;

			drawWin();
		} else if (activeButton == backtonats) {
			status = 8;

			drawNatsConference();
		}

		else if (activeButton == quit3) {
			System.exit(0);
		} else if (activeButton == gamemessagebutton) {
			playGameMessage();
		}

		if (wronganswers.size() > 10) {
			activeButton = null;
			status = 7;
			drawFailure();
		}

		for (ArrayList<SohilButton> a : conferences) {
			for (SohilButton b : a) {
				if (activeButton == game1) {
					status = 10;

					drawSpaceGame();
					activeButton = b;
				}
				if (activeButton == game2) {
					status = 11;

					drawDrivingGame();
					activeButton = b;
				}
				if (activeButton == game3) {
					status = 12;

					drawPsychoSearchGame();
					activeButton = b;
				}

				if (activeButton == game4) {
					status = 9;

					drawBirdBlunderGame();
					activeButton = b;
				}
			}
		}

		if (activeButton == nationals) {
			status = 13;

			drawNationals();

		}
		if (activeButton == quit) {
			System.exit(0);
		}

//		System.out.println(Arrays.toString(player.getProgress()));
	}

	public void drawWin() {

		if (player.getProgress()[5] < wronganswers.size()) {
			headingFormat();
			textSize(40);
			text("You haven't beaten " + wronganswers.size() + " of those \ngames yet!", Main.width / 2,
					confHeadHeight);
			backtonats.draw(this);

		} else {
			headingFormat();
			textSize(50);
			text("YOU WON! CONGRATS!", Main.width / 2, confHeadHeight);
			quit.draw(this);

		}

	}

	public void drawDrivingNatsGame(int inde) {
		// TODO Auto-generated method stub
		final int speed = 20;
		Driving drawing = new Driving(wronganswers.get(inde), player, 5, speed, filler1, filler2, rightAnswers, 1);
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

	public void drawPsychoSearchNatsGame(int inde) {
		// TODO Auto-generated method stub

		final int seconds = 15;
		Flashlight drawing = new Flashlight(wronganswers.get(inde), seconds, player, 5, filler1, filler2, rightAnswers,
				2);
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

	public void drawBirdBlunderNatsGame(int inde) {
		// TODO Auto-generated method stub
		final int birdspersec = 6;
		Flight drawing = new Flight(wronganswers.get(inde), birdspersec, 5, player, filler1, filler2, rightAnswers,
				inde);
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

	public void drawSpaceNatsGame(int inde) {
		// TODO Auto-generated method stub
		final int speed = 2;
		Space drawing = new Space(wronganswers.get(inde), player, 5, speed, filler1, filler2, rightAnswers, 0);
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
		text("That is your tenth wrong question! \nObviously you haven't studied enough. \nCome back when you are better :(",
				Main.width / 2, confHeadHeight + 100);
		quit3.draw(this);

	}

	public void setup() {
		next = new ImageButton(loadImage("images\\next.png"), 300, 450, 200, 200);
		next2 = new ImageButton(loadImage("images\\next.png"), 580, 500, 150, 150);
	}

	public void drawNatsConference() {

		headingFormat();
		if (wronganswers.size() == 0) {
			textSize(45);
			text("You got all the questions right! \nYou won the game, no national\n conference for geniuses like you! \n:)",
					Main.width / 2, confHeadHeight + 150);
			quit3.draw(this);

		} else {
			headingFormat();

			text("Nationals", Main.width / 2, confHeadHeight - 50);
			for (int i = 0; i < wronganswers.size(); i++) {
				SohilButton e = natsgames.get(i);
				e.draw(this);

			}
			// nats.draw(this);
			win.draw(this);

		}

	}

	public void drawBirdBlunderGame() {
		// TODO Auto-generated method stub

		ArrayList<Question> as = getQueArray(topics.get(spaceConfIndicator), "bb");
		final int birdspersec = 3;
		// int index = (int)(Math.random() * as.size());
		Flight drawing = new Flight(as.get(3), birdspersec, spaceConfIndicator, player, as, wronganswers, rightAnswers,
				3);
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
		final int speed = 1;
		int index = (int) (Math.random() * as.size());

		Space drawing = new Space(as.get(0), player, spaceConfIndicator, speed, as, wronganswers, rightAnswers, 0);
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
		int index = (int) (Math.random() * as.size());

		final int speed = 10;
		Driving drawing = new Driving(as.get(1), player, drivingConfIndicator, speed, as, wronganswers, rightAnswers,
				1);
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
		int index = (int) (Math.random() * as.size());

		final int seconds = 30;
		Flashlight drawing = new Flashlight(as.get(2), seconds, player, spaceConfIndicator, as, wronganswers,
				rightAnswers, 2);
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

//		System.out.println(rightAnswers);
	}

	public void drawNationals() {

		backConference.draw(this);

		int[] prog = player.getProgress();
		boolean hasPassedConfs = true;
		for (int i = 0; i < prog.length - 1; i++) {
			int e = prog[i];
			if (e < 4) {
				hasPassedConfs = false;
			}
		}
		if (hasPassedConfs) {
			headingFormat();
			textSize(50);
			text("Congrats on passing all of the \nconferences!", Main.width / 2 + 10, confHeadHeight);
			text("The National Conference is \ndesigned to test all of the \nquestions you got wrong.",
					Main.width / 2 + 10, confHeadHeight + 200);

			proceedToNats.draw(this);

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

		}
		nationals.draw(this);
		quit.draw(this);
		confs.draw(this);

	}

	public void drawConference1() {

		spaceConfIndicator = 0;
		drivingConfIndicator = 0;
		for (SohilButton b : conference1) {
			b.draw(this);

		}
		if (player.getProgress()[0] >= 4)
			progressBars.get(0).setProgress(4);
		else
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

		}

		if (player.getProgress()[1] >= 4)
			progressBars.get(1).setProgress(4);
		else
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

		}

		if (player.getProgress()[2] >= 4)
			progressBars.get(2).setProgress(4);
		else
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

		}

		if (player.getProgress()[3] >= 4)
			progressBars.get(3).setProgress(4);
		else
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

		}

		if (player.getProgress()[4] >= 4)
			progressBars.get(4).setProgress(4);
		else
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

		Color col1 = new Color(44, 44, 221);
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
			} else if (slide == 4) {
				if (mouseButton == LEFT) {

					if (next2.isPointInButton(x, y) && is5Selected()) {
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
			} else if (slide == 3) {
				if (next2.isPointInButton(x, y)) {
					slide = 4;
				}
			}
		} else {// 1 instructinos 2 win 3 dnats 4 psnats 5 bbnats 6 snats 7 fail 8 natsconf 9 bb
				// 10 space 11 driving 12 ps 13 nats 14 confscreen 15 conf1 16 conf2 17 conf3 18
				// conf4 19 conf5 20 playgame}
			if (status == 20) {
				status = 8;
				if (backtonats.isPointInside(mouseX, mouseY)) {
					activeButton = backtonats;
				}
			} else if (status == 2) {

				if (player.getProgress()[5] < wronganswers.size()) {
					if (backtonats.isPointInside(mouseX, mouseY)) {
						activeButton = backtonats;

					}
				} else {
					if (quit.isPointInside(mouseX, mouseY)) {
						activeButton = quit;

					}
				}

			} else if (status == 7) {
				if (quit3.isPointInside(mouseX, mouseY)) {
					activeButton = quit3;

				}
			} else if (status == 8) {

				if (wronganswers.size() == 0) {
					if (quit3.isPointInside(mouseX, mouseY)) {
						activeButton = quit3;

					}
				} else {
					for (int i = 0; i < wronganswers.size(); i++) {
						SohilButton e = natsgames.get(i);
						if (e.isPointInside(mouseX, mouseY)) {
							activeButton = e;
						}

					}

					if (win.isPointInside(mouseX, mouseY)) {
						activeButton = win;

					}
				}

			} else if (status == 13) {
				if (backConference.isPointInside(mouseX, mouseY)) {
					activeButton = backConference;

				}

				int[] prog = player.getProgress();
				boolean hasPassedConfs = true;
				for (int i = 0; i < prog.length - 1; i++) {
					int e = prog[i];
					if (e < 4) {
						hasPassedConfs = false;
					}
				}
				if (hasPassedConfs) {
					if (proceedToNats.isPointInside(mouseX, mouseY)) {
						activeButton = proceedToNats;

					}
				}

			} else if (status == 14) {
				for (SohilButton b : conferenceSelection) {
					if (b.isPointInside(mouseX, mouseY)) {
						activeButton = b;
					}
				}
			} else if (status == 15) {
				for (SohilButton b : conference1) {
					if (b.isPointInside(mouseX, mouseY)) {
						activeButton = b;

					}
				}
			} else if (status == 16) {
				for (SohilButton b : conference2) {
					if (b.isPointInside(mouseX, mouseY)) {
						activeButton = b;

					}
				}
			} else if (status == 17) {
				for (SohilButton b : conference3) {
					if (b.isPointInside(mouseX, mouseY)) {
						activeButton = b;

					}
				}
			} else if (status == 18) {
				for (SohilButton b : conference4) {
					if (b.isPointInside(mouseX, mouseY)) {
						activeButton = b;

					}
				}
			} else if (status == 19) {
				for (SohilButton b : conference5) {
					if (b.isPointInside(mouseX, mouseY)) {
						activeButton = b;

					}
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

		if (!theOnceBoolean) {
			if (slide == 4) {
				for (AyushTextButton one : options) {
					if (!one.getBColor().equals(col2)) {
						if (one.isPointInButton(x, y)) {
							one.setBColor(col1);
						} else {
							one.setBColor(col3);
						}

					}
				}
			}
		} else {
			if (status == 20) {
				if (backtonats.isPointInside(mouseX, mouseY)) {
					backtonats.setColor(new Color(0, 191, 255));
				} else {
					backtonats.setColor(new Color(135, 206, 255));
				}
			} else if (status == 2) {

				if (player.getProgress()[5] < wronganswers.size()) {
					if (backtonats.isPointInside(mouseX, mouseY)) {
						backtonats.setColor(new Color(0, 191, 255));
					} else {
						backtonats.setColor(new Color(135, 206, 255));
					}
				} else {
					if (quit.isPointInside(mouseX, mouseY)) {
						quit.setColor(new Color(0, 191, 255));

					} else {
						quit.setColor(new Color(135, 206, 255));
					}
				}

			} else if (status == 7) {
				if (quit3.isPointInside(mouseX, mouseY)) {
					quit3.setColor(new Color(0, 191, 255));
				} else {
					quit3.setColor(new Color(135, 206, 255));
				}
			} else if (status == 8) {
				if (wronganswers.size() == 0) {
					if (quit3.isPointInside(mouseX, mouseY)) {
						quit3.setColor(new Color(0, 191, 255));

					} else {
						quit3.setColor(new Color(135, 206, 255));
					}
				} else {
					for (int i = 0; i < wronganswers.size(); i++) {
						SohilButton e = natsgames.get(i);
						if (e.isPointInside(mouseX, mouseY)) {
							e.setColor(new Color(0, 191, 255));

						} else {
							e.setColor(new Color(135, 206, 255));
						}

					}
					if (win.isPointInside(mouseX, mouseY)) {
						win.setColor(new Color(0, 191, 255));

					} else {
						win.setColor(new Color(135, 206, 255));
					}
				}

			} else if (status == 13) {
				if (backConference.isPointInside(mouseX, mouseY)) {
					backConference.setColor(new Color(0, 191, 255));
				} else {
					backConference.setColor(new Color(135, 206, 255));
				}

				int[] prog = player.getProgress();
				boolean hasPassedConfs = true;
				for (int i = 0; i < prog.length - 1; i++) {
					int e = prog[i];
					if (e < 4) {
						hasPassedConfs = false;
					}
				}
				if (hasPassedConfs) {
					if (proceedToNats.isPointInside(mouseX, mouseY)) {
						proceedToNats.setColor(new Color(0, 191, 255));
					} else {
						proceedToNats.setColor(new Color(135, 206, 255));
					}
				}
			} else if (status == 14) {
				for (SohilButton b : conferenceSelection) {
					if (b.isPointInside(mouseX, mouseY)) {
						b.setColor(new Color(0, 191, 255));
					} else {
						b.setColor(new Color(135, 206, 255));
					}
				}
			} else if (status == 15) {
				for (SohilButton b : conference1) {
					if (b.isPointInside(mouseX, mouseY)) {
						b.setColor(new Color(0, 191, 255));
					} else {
						b.setColor(new Color(135, 206, 255));
					}
				}
			} else if (status == 16) {
				for (SohilButton b : conference2) {
					if (b.isPointInside(mouseX, mouseY)) {
						b.setColor(new Color(0, 191, 255));
					} else {
						b.setColor(new Color(135, 206, 255));
					}
				}
			} else if (status == 17) {
				for (SohilButton b : conference3) {
					if (b.isPointInside(mouseX, mouseY)) {
						b.setColor(new Color(0, 191, 255));

					} else {
						b.setColor(new Color(135, 206, 255));
					}
				}
			} else if (status == 18) {
				for (SohilButton b : conference4) {
					if (b.isPointInside(mouseX, mouseY)) {
						b.setColor(new Color(0, 191, 255));

					} else {
						b.setColor(new Color(135, 206, 255));
					}
				}
			} else if (status == 19) {
				for (SohilButton b : conference5) {
					if (b.isPointInside(mouseX, mouseY)) {
						b.setColor(new Color(0, 191, 255));

					} else {
						b.setColor(new Color(135, 206, 255));
					}
				}
			}
		}

	}

	public void keyPressed() {
//
//		// press g to quickly pass all the games
//		if (key == 'g') {
//			player.passGame(0);
//			player.passGame(0);
//			player.passGame(0);
//			player.passGame(0);
//			player.passGame(1);
//			player.passGame(1);
//			player.passGame(1);
//			player.passGame(1);
//			player.passGame(2);
//			player.passGame(2);
//			player.passGame(2);
//			player.passGame(2);
//			player.passGame(3);
//			player.passGame(3);
//			player.passGame(3);
//			player.passGame(3);
//			player.passGame(4);
//			player.passGame(4);
//			player.passGame(4);
//			player.passGame(4);
//
//		} else if (key == 'h') {
//			wronganswers.add(new Question("test11", "test1", "test", "test", "test"));
//			wronganswers.add(new Question("test22", "test1", "test", "test", "test"));
//
//			// wronganswers.add(new Question("test", "test", "test", "test", "test"));
//
//		}
	}
}
