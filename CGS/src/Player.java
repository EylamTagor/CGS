public class Player {
	private int[] progress; // progress[conf #] = # games passed for that conf
	private int balance;
	private boolean jacket, shirt, slacks, shoes, belt, tie; // prices: 250, 75, 100, 75, 25, 50.

	public Player() {
		progress = new int[5];
		balance = 0;
		jacket = false;
		shirt = false;
		slacks = false;
		shoes = false;
		belt = false;
		tie = false;
	}

	public void obtainJacket() {
		balance -= 250;
		jacket = true;
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

	public boolean hasJacket() {
		return jacket;
	}

	public boolean hasShirt() {
		return shirt;
	}

	public boolean hasSlacks() {
		return slacks;
	}

	public boolean hasShoes() {
		return shoes;
	}

	public boolean hasBelt() {
		return belt;
	}

	public boolean hasTie() {
		return tie;
	}

	public void passGame(int currConf) {
		progress[currConf]++;
	}
}
