package Puzzles;

public class Dealer extends Accounts {
	//Consider dealers account as pot
	private double currBet;
	private int startFromPlayerAtPos;
	
	public Dealer() {
		super(0, "Dealer");
		this.startFromPlayerAtPos = 1;
	}

	/**
	 * @return the currBet
	 */
	public double getCurrBet() {
		return currBet;
	}
	
	
	/**
	 * @param currBet the currBet to set
	 */
	public void setCurrBet(double currBet) {
		this.currBet = currBet;
	}

	private void distCards() {}
	private void waitForPlayerAtPos(int index) {}
	private void updateCurrBet() {}
	private void openFlock() {}
	private void openTurn() {}
	private void openRiver() {}
	private void finaliseRound() {}	//Check and distribute money.
}
