import java.util.ArrayList;

public class Test {
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
		parlibb.add(new Question("Which article in the FBLA bylaws describes the information about FBLA dues?",
				"Article IV", "Article III", "Artivle VI", "Artivle V"));
		parlibb.add(new Question("Viva voce means:", "voice vote", "for motion", "no objection", "objection"));
		parlibb.add(new Question("Rescind means:", "cancel", "consideration", "give way to", "no objection"));
		parlibb.add(new Question(
				"The secretary must apply at least _____ copies of the minutes to the necessary authorities", "two",
				"four", "three", "one"));
		infotechbb.add(new Question("Compressed files, or _____ files, usually have a _____ extension", "zipped; .zip",
				"tipped; .tip", "joint; .jnt", "dipped; .dip"));
		infotechbb.add(new Question("A(n) _____ allows you to create, update, and administer a relational database.",
				"RDBMS", "XML DBMS", "OODBMS", "ERD"));
		infotechbb.add(
				new Question("Communication between all of the different devices on the Internet is mad possible by:",
						"TCP/IP", "HTTP", "FTP", "AT&T"));
		infotechbb.add(new Question("Some search engines use _ instead of the word NOT.", "-", "=", "*", "^"));
		bizprobb.add(new Question("If something is at the tertiary level, it appears:", "third", "thirteenth", "first",
				"second"));
		bizprobb.add(new Question("What ratio should be determined t calculate the earning power of a business?",
				"profitability", "quick", "earnings", "expenditure"));
		bizprobb.add(new Question(
				"A(n) ______________ is a good opportunity to ask specific questions about the job\r\n"
						+ "opening, career paths, and the company.",
				"interview", "phone call", "career day", "job app session"));
		bizprobb.add(new Question("The easiest way to become a business owner is to:", "buy stock",
				"purchase franchise", "start one", "find partner(s)"));
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
				"A parliamentary procedure team can have ______ repeat members from a previous National\r\n"
						+ "Leadership Conference team.",
				"two", "one", "three", "none"));
		fblabb.add(new Question("Handbooks for officers can be puchased from:", "MarketPlace", "Barnes & Noble",
				"NAP Committee", "board of directors"));
		fblabb.add(new Question("The Chapter Management Handbook updates are revised and distributed:", "annually",
				"as needed", "biannually", "every 2yrs"));
		fblabb.add(new Question("FBLA-PBL week is the second week in:", "Feb.", "Jan.", "Mar.", "Apr."));
		mathbb.add(new Question("If 80% > 0.75, then:", "4/5 > 3/4", "4/5 < 3/4", "80% = 0.75", "80% = 3/4"));
		mathbb.add(new Question("The area of a circle with a diameter of 6 in. is approximately:", "28.26 in.^2",
				"56.54 in^2", "28.26 in.", "56.54 in."));
		mathbb.add(new Question("Determine the average of 90, 66, 84, 72, 98.", "82", "90", "102", "80"));
		mathbb.add(new Question("The best way to depict a future prediction is by using a:", "line chart", "bar chart",
				"histogram", "pie chart"));

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
		parlips.add(new Question("Which article in the FBLA bylaws describes the information about FBLA dues?",
				"Article IV", "Article III", "Artivle VI", "Artivle V"));
		parlips.add(new Question("Viva voce means:", "voice vote", "for motion", "no objection", "objection"));
		parlips.add(new Question("Rescind means:", "cancel", "consideration", "give way to", "no objection"));
		parlips.add(new Question(
				"The secretary must apply at least _____ copies of the minutes to the necessary authorities", "two",
				"four", "three", "one"));
		infotechps.add(new Question("Compressed files, or _____ files, usually have a _____ extension", "zipped; .zip",
				"tipped; .tip", "joint; .jnt", "dipped; .dip"));
		infotechps.add(new Question("A(n) _____ allows you to create, update, and administer a relational database.",
				"RDBMS", "XML DBMS", "OODBMS", "ERD"));
		infotechps.add(
				new Question("Communication between all of the different devices on the Internet is mad possible by:",
						"TCP/IP", "HTTP", "FTP", "AT&T"));
		infotechps.add(new Question("Some search engines use _ instead of the word NOT.", "-", "=", "*", "^"));
		bizprops.add(new Question("If something is at the tertiary level, it appears:", "third", "thirteenth", "first",
				"second"));
		bizprops.add(new Question("What ratio should be determined t calculate the earning power of a business?",
				"profitability", "quick", "earnings", "expenditure"));
		bizprops.add(new Question(
				"A(n) ______________ is a good opportunity to ask specific questions about the job\r\n"
						+ "opening, career paths, and the company.",
				"interview", "phone call", "career day", "job app session"));
		bizprops.add(new Question("The easiest way to become a business owner is to:", "buy stock",
				"purchase franchise", "start one", "find partner(s)"));
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
				"A parliamentary procedure team can have ______ repeat members from a previous National\r\n"
						+ "Leadership Conference team.",
				"two", "one", "three", "none"));
		fblaps.add(new Question("Handbooks for officers can be puchased from:", "MarketPlace", "Barnes & Noble",
				"NAP Committee", "board of directors"));
		fblaps.add(new Question("The Chapter Management Handbook updates are revised and distributed:", "annually",
				"as needed", "biannually", "every 2yrs"));
		fblaps.add(new Question("FBLA-PBL week is the second week in:", "Feb.", "Jan.", "Mar.", "Apr."));
		mathps.add(new Question("If 80% > 0.75, then:", "4/5 > 3/4", "4/5 < 3/4", "80% = 0.75", "80% = 3/4"));
		mathps.add(new Question("The area of a circle with a diameter of 6 in. is approximately:", "28.26 in.^2",
				"56.54 in^2", "28.26 in.", "56.54 in."));
		mathps.add(new Question("Determine the average of 90, 66, 84, 72, 98.", "82", "90", "102", "80"));
		mathps.add(new Question("The best way to depict a future prediction is by using a:", "line chart", "bar chart",
				"histogram", "pie chart"));

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
		parlid.add(new Question("Which article in the FBLA bylaws describes the information about FBLA dues?",
				"Article IV", "Article III", "Artivle VI", "Artivle V"));
		parlid.add(new Question("Viva voce means:", "voice vote", "for motion", "no objection", "objection"));
		parlid.add(new Question("Rescind means:", "cancel", "consideration", "give way to", "no objection"));
		parlid.add(new Question(
				"The secretary must apply at least _____ copies of the minutes to the necessary authorities", "two",
				"four", "three", "one"));
		infotechd.add(new Question("Compressed files, or _____ files, usually have a _____ extension", "zipped; .zip",
				"tipped; .tip", "joint; .jnt", "dipped; .dip"));
		infotechd.add(new Question("A(n) _____ allows you to create, update, and administer a relational database.",
				"RDBMS", "XML DBMS", "OODBMS", "ERD"));
		infotechd.add(
				new Question("Communication between all of the different devices on the Internet is mad possible by:",
						"TCP/IP", "HTTP", "FTP", "AT&T"));
		infotechd.add(new Question("Some search engines use _ instead of the word NOT.", "-", "=", "*", "^"));
		bizprod.add(new Question("If something is at the tertiary level, it appears:", "third", "thirteenth", "first",
				"second"));
		bizprod.add(new Question("What ratio should be determined t calculate the earning power of a business?",
				"profitability", "quick", "earnings", "expenditure"));
		bizprod.add(new Question(
				"A(n) ______________ is a good opportunity to ask specific questions about the job\r\n"
						+ "opening, career paths, and the company.",
				"interview", "phone call", "career day", "job app session"));
		bizprod.add(new Question("The easiest way to become a business owner is to:", "buy stock", "purchase franchise",
				"start one", "find partner(s)"));
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
				"A parliamentary procedure team can have ______ repeat members from a previous National\r\n"
						+ "Leadership Conference team.",
				"two", "one", "three", "none"));
		fblad.add(new Question("Handbooks for officers can be puchased from:", "MarketPlace", "Barnes & Noble",
				"NAP Committee", "board of directors"));
		fblad.add(new Question("The Chapter Management Handbook updates are revised and distributed:", "annually",
				"as needed", "biannually", "every 2yrs"));
		fblad.add(new Question("FBLA-PBL week is the second week in:", "Feb.", "Jan.", "Mar.", "Apr."));
		mathd.add(new Question("The area of a circle with a diameter of 6 in. is approximately:", "28.26 in.^2",
				"56.54 in^2", "28.26 in.", "56.54 in."));
		mathd.add(new Question("Determine the average of 90, 66, 84, 72, 98.", "82", "90", "102", "80"));
		mathd.add(new Question("The best way to depict a future prediction is by using a:", "line chart", "bar chart",
				"histogram", "pie chart"));

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
		parlis.add(new Question("Which article in the FBLA bylaws describes the information about FBLA dues?",
				"Article IV", "Article III", "Artivle VI", "Artivle V"));
		parlis.add(new Question("Viva voce means:", "voice vote", "for motion", "no objection", "objection"));
		parlis.add(new Question("Rescind means:", "cancel", "consideration", "give way to", "no objection"));
		parlis.add(new Question(
				"The secretary must apply at least _____ copies of the minutes to the necessary authorities", "two",
				"four", "three", "one"));
		infotechs.add(new Question("Compressed files, or _____ files, usually have a _____ extension", "zipped; .zip",
				"tipped; .tip", "joint; .jnt", "dipped; .dip"));
		infotechs.add(new Question("A(n) _____ allows you to create, update, and administer a relational database.",
				"RDBMS", "XML DBMS", "OODBMS", "ERD"));
		infotechs.add(
				new Question("Communication between all of the different devices on the Internet is mad possible by:",
						"TCP/IP", "HTTP", "FTP", "AT&T"));
		infotechs.add(new Question("Some search engines use _ instead of the word NOT.", "-", "=", "*", "^"));
		bizpros.add(new Question("If something is at the tertiary level, it appears:", "third", "thirteenth", "first",
				"second"));
		bizpros.add(new Question("What ratio should be determined t calculate the earning power of a business?",
				"profitability", "quick", "earnings", "expenditure"));
		bizpros.add(new Question(
				"A(n) ______________ is a good opportunity to ask specific questions about the job\r\n"
						+ "opening, career paths, and the company.",
				"interview", "phone call", "career day", "job app session"));
		bizpros.add(new Question("The easiest way to become a business owner is to:", "buy stock", "purchase franchise",
				"start one", "find partner(s)"));
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
				"A parliamentary procedure team can have ______ repeat members from a previous National\r\n"
						+ "Leadership Conference team.",
				"two", "one", "three", "none"));
		fblas.add(new Question("Handbooks for officers can be puchased from:", "MarketPlace", "Barnes & Noble",
				"NAP Committee", "board of directors"));
		fblas.add(new Question("The Chapter Management Handbook updates are revised and distributed:", "annually",
				"as needed", "biannually", "every 2yrs"));
		fblas.add(new Question("FBLA-PBL week is the second week in:", "Feb.", "Jan.", "Mar.", "Apr."));
		maths.add(new Question("If 80% > 0.75, then:", "4/5 > 3/4", "4/5 < 3/4", "80% = 0.75", "80% = 3/4"));
		maths.add(new Question("The area of a circle with a diameter of 6 in. is approximately:", "28.26 in.^2",
				"56.54 in^2", "28.26 in.", "56.54 in."));
		maths.add(new Question("Determine the average of 90, 66, 84, 72, 98.", "82", "90", "102", "80"));
		maths.add(new Question("The best way to depict a future prediction is by using a:", "line chart", "bar chart",
				"histogram", "pie chart"));
	}
}
