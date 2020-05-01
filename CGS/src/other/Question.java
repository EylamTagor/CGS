package other;

/**
 * Represents a question from the database with four answers, one of which is
 * correct and three of which are incorrect
 */
public class Question {
	private String question, correct, wrong1, wrong2, wrong3;

	/**
	 * Creates a new Question object with the following parameters
	 * 
	 * @param question the text that is the actual question
	 * @param correct  the correct answer
	 * @param wrong1   one of the three incorrect answers
	 * @param wrong2   the second of the three incorrect answers
	 * @param wrong3   the third (and last) of the three incorrect answers
	 */
	public Question(String question, String correct, String wrong1, String wrong2, String wrong3) {
		this.question = question;
		this.correct = correct;
		this.wrong1 = wrong1;
		this.wrong2 = wrong2;
		this.wrong3 = wrong3;
	}

	/**
	 * @return the actual question as text
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Sets the actual question
	 * 
	 * @param question the new question as text
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the correct answer to the question
	 */
	public String getCorrect() {
		return correct;
	}

	/**
	 * Sets the correct answer to a new one as text
	 * 
	 * @param correct the new correct answer
	 */
	public void setCorrect(String correct) {
		this.correct = correct;
	}

	/**
	 * @return the first of the three incorrect answers
	 */
	public String getWrong1() {
		return wrong1;
	}

	/**
	 * Sets the first incorrect answer to a new one as text
	 * 
	 * @param wrong1 the new first incorrect answer
	 */
	public void setWrong1(String wrong1) {
		this.wrong1 = wrong1;
	}

	/**
	 * @return the second of the three incorrect answers
	 */
	public String getWrong2() {
		return wrong2;
	}

	/**
	 * Sets the second incorrect answer to a new one as text
	 * 
	 * @param wrong2 the new second incorrect answer
	 */
	public void setWrong2(String wrong2) {
		this.wrong2 = wrong2;
	}

	/**
	 * @return the third of the three incorrect answers
	 */
	public String getWrong3() {
		return wrong3;
	}

	/**
	 * Sets the third incorrect answer to a new one as text
	 * 
	 * @param wrong3 the new third incorrect answer
	 */
	public void setWrong3(String wrong3) {
		this.wrong3 = wrong3;
	}

	/**
	 * @return this Question object as text, showing the actual question followed by
	 *         the correct answer and then the three incorrect answers.
	 */
	public String toString() {
		return question + "\n     " + correct + "     " + wrong1 + "     " + wrong2 + "     " + wrong3;
	}
}
