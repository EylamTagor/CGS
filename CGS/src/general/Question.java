package general;

public class Question {
	private String question, correct, wrong1, wrong2, wrong3;

	public Question(String question, String correct, String wrong1, String wrong2, String wrong3) {
		this.question = question;
		this.correct = correct;
		this.wrong1 = wrong1;
		this.wrong2 = wrong2;
		this.wrong3 = wrong3;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public String getWrong1() {
		return wrong1;
	}

	public void setWrong1(String wrong1) {
		this.wrong1 = wrong1;
	}

	public String getWrong2() {
		return wrong2;
	}

	public void setWrong2(String wrong2) {
		this.wrong2 = wrong2;
	}

	public String getWrong3() {
		return wrong3;
	}

	public void setWrong3(String wrong3) {
		this.wrong3 = wrong3;
	}

	public String toString() {
		return question + "\n     " + correct + "     " + wrong1 + "     " + wrong2 + "     " + wrong3;
	}
}
