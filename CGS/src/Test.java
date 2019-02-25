import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Test {
	private static Player player;

	private static ArrayList<Question> parlibb;
	private static ArrayList<Question> bizcommbb;
	private static ArrayList<Question> bizprobb;
	private static ArrayList<Question> infotechbb;
	private static ArrayList<Question> mathbb;
	private static ArrayList<Question> fblabb;
	private static ArrayList<Question> bizbb;
	private static ArrayList<Question> parlips, bizcommps, bizprops, infotechps, mathps, fblaps, bizps;
	private static ArrayList<Question> parlis, bizcomms, bizpros, infotechs, maths, fblas, bizs;
	private static ArrayList<Question> parlid, bizcommd, bizprod, infotechd, mathd, fblad, bizd;

	public static void main(String[] args) {
		initQuestions();

//		to test where to put \n
//		drawDrivingGame(bizd.get(3));
	}

	public static void initQuestions() {
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
		bizs.add(new Question("Spending a few hours observing\nsomeone in your chosen occupation is called job _____",
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

	public static void drawBirdBlunderGame(Question q) {
		final int birdspersec = 3;
		BirdBlunder drawing = new BirdBlunder(q, birdspersec, 0, player, null, null, 3);
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

	public static void drawSpaceGame(Question q) {
		final int speed = 1;
		Space drawing = new Space(q, player, 0, speed, null, null, 0);
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

	public static void drawDrivingGame(Question q) {
		final int speed = 10;
		Driving drawing = new Driving(q, player, 0, speed, null, null, 1);
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

	public static void drawPsychoSearchGame(Question q) {
		final int seconds = 30;
		PsychoSearch drawing = new PsychoSearch(q, seconds, player, 0, null, null, 2);
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
}
