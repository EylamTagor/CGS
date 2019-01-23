
public class Player {
	private int[] progress; // progress[conf #] = # games passed for that conf
	private int balance;
	private boolean blazer, shirt, slacks, shoes, belt, tie; // prices: 250, 75, 100, 75, 25, 50.

	public Player() {
		progress = new int[5];
		balance = 0;
		blazer = false;
		shirt = false;
		slacks = false;
		shoes = false;
		belt = false;
		tie = false;
	}

	public void obtainBlazer() {
		balance -= 250;
		blazer = true;
	}

	public void obtainShirt() {
		balance -= 75;
		shirt = true;
	}

	public void obtainSlacks() {
		balance -= 100;
		slacks = true;
	}

	public void obtainShoes() {
		balance -= 75;
		shoes = true;
	}

	public void obtainBelt() {
		balance -= 25;
		belt = true;
	}

	public void obtainTie() {
		balance -= 50;
		tie = true;
	}

	public void earn(int amount) {
		balance += amount;
	}

	public int getBalance() {
		return balance;
	}

	public void passGame(int currConf) {
		progress[currConf]++;
	}
}
