package other;

/**
 * Represents the player who plays FBLA Trivia Tester, and accounts for tracking
 * progress.
 */
public class Player {
	private int[] progress;
	// progress[conf #] = # games passed for that conf
	private int balance;
	private boolean jacket, shirt, slacks, shoes, belt, tie; // prices: 250, 75, 100, 75, 25, 50.

	/**
	 * Creates a new Player object, and initializes progress as none.
	 */
	public Player() {
		progress = new int[6];
		balance = 0;
		jacket = false;
		shirt = false;
		slacks = false;
		shoes = false;
		belt = false;
		tie = false;
	}

	/**
	 * [OBSOLETE FEATURE] Purchases jacket.
	 */
	public void obtainJacket() {
		balance -= 250;
		jacket = true;
	}

	/**
	 * [OBSOLETE FEATURE] Purchases shirt.
	 */
	public void obtainShirt() {
		balance -= 75;
		shirt = true;
	}

	/**
	 * [OBSOLETE FEATURE] Purchases slacks.
	 */
	public void obtainSlacks() {
		balance -= 100;
		slacks = true;
	}

	/**
	 * [OBSOLETE FEATURE] Purchases shoes.
	 */
	public void obtainShoes() {
		balance -= 75;
		shoes = true;
	}

	/**
	 * [OBSOLETE FEATURE] Purchases belt.
	 */
	public void obtainBelt() {
		balance -= 25;
		belt = true;
	}

	/**
	 * [OBSOLETE FEATURE] Purchases tie.
	 */
	public void obtainTie() {
		balance -= 50;
		tie = true;
	}

	/**
	 * [OBSOLETE FEATURE] Adds money to player's balance.
	 * 
	 * @param amount the amount of money to be added
	 */
	public void earn(int amount) {
		balance += amount;
	}

	/**
	 * [OBSOLETE FEATURE]
	 * 
	 * @return the player's balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * [OBSOLETE FEATURE]
	 * 
	 * @return true if the player had purchased the jacket, otherwise false
	 */
	public boolean hasJacket() {
		return jacket;
	}

	/**
	 * [OBSOLETE FEATURE]
	 * 
	 * @return true if the player had purchased the shirt, otherwise false
	 */
	public boolean hasShirt() {
		return shirt;
	}

	/**
	 * [OBSOLETE FEATURE]
	 * 
	 * @return true if the player had purchased the slacks, otherwise false
	 */
	public boolean hasSlacks() {
		return slacks;
	}

	/**
	 * [OBSOLETE FEATURE]
	 * 
	 * @return true if the player had purchased the shoes, otherwise false
	 */
	public boolean hasShoes() {
		return shoes;
	}

	/**
	 * [OBSOLETE FEATURE]
	 * 
	 * @return true if the player had purchased the belt, otherwise false
	 */
	public boolean hasBelt() {
		return belt;
	}

	/**
	 * [OBSOLETE FEATURE]
	 * 
	 * @return true if the player had purchased the tie, otherwise false
	 */
	public boolean hasTie() {
		return tie;
	}

	/**
	 * Increments the player's progress for a specific conference
	 * 
	 * @param currConf the conference to increment progress for
	 */
	public void passGame(int currConf) {
		progress[currConf]++;
	}

	/**
	 * @return the player's progress as an array, in which getProgress()[i] returns
	 *         the progress for conference i.
	 */
	public int[] getProgress() {
		return progress;
	}

	/**
	 * Sets the player's progress given a conference number and a value
	 * 
	 * @param conf the conference to set progress for
	 * @param val  the number to change conf's progress by
	 */
	public void setProgress(int conf, int val) {
		progress[conf] = val;
	}

}
