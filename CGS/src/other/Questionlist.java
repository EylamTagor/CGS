package other;

import java.util.ArrayList;

/**
 * [TESTER CLASS] Initializes the database of all questions in FBLA Trivia
 * Tester
 */
public class Questionlist {

	/**
	 * Initializes the question database.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Question> bizcomm = new ArrayList<Question>();
		bizcomm.add(new Question(
				"\"The hamburger was piled high with juicy, red, thick-sliced tomatoes, crisp dark-red lettuce leaves, and perfect rounds of sliced onion.\" This is an example of what type of text?",
				"descriptive", "persuasive", "instructional", "informative"));
		bizcomm.add(new Question("Which plural of the word is not correct?", "ski--skiis", "witch -- witches",
				"cactus--cacti", "Jones--Joneses"));
		bizcomm.add(new Question(
				"What punctuation mark should be used after an interjection such as Hey used at the beginning of a sentence?",
				"exclamation mark", "period", "quotation marks", "question mark"));
		bizcomm.add(new Question(
				"There is always one group that opposes all suggestions. That ______ always resists change", "faction",
				"herd", "heard", "fraction"));
		bizcomm.add(new Question("Scatter, column, bar, and pie are types of:", "charts", "enumerations", "tables",
				"lists"));
		bizcomm.add(new Question(
				"Choose a linking verb to complete this sentence. Samantha Golden ____________________ a patient.",
				"has been", "helped", "called", "annoyed"));
		bizcomm.add(new Question("Select the word that means to quote or mention", "cite", "site", "sight", "might"));
		// bizcomm.addAll(new Question(""));

	}

}
