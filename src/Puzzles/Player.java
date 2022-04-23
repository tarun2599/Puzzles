package Puzzles;

public class Player extends Accounts{
	
	private double balanceForGame;
	private double amtKeptAtTable;
	
	public Player(double balance, String name) {
		super(balance, name);
		// TODO Auto-generated constructor stub
	}
	
	public Player(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param amount Buyin Amount
	 */
	
	public void buyIn(double amount) {
		if(amount > getMaxbuyIn()) 
			throw new IllegalArgumentException();
		this.balanceForGame = amount;
	}
	
	public void check() {
		if(amtKeptAtTable != Dealer.getCurrBet()) {
			//Can not do this
		}
	}
	public void raise(double amount) {
		if(amtKeptAtTable != Dealer.getCurrBet()) {
			//Check if you have enough balance else all in.
			//Add amount to table = (currBet - amtKeptAtTable) + raise
			//amtKeptAtTable = currBet  + raise ;
			//Send msg to dealer to increase currBet
		}
	}
	public void call() {
		//
	}
	public void fold() {
		//
	}
}
