package Puzzles;

public class Player extends Accounts{
	
	private double balanceForGame;
	private double amtKeptAtTable;
	private Dealer dealer;
	private boolean isFolded;
	
	public Player(Dealer d1,double balance, String name) {
		super(balance, name);
		this.dealer = d1;
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
		if(amtKeptAtTable != dealer.getCurrBet()) {
			//Can not do this
		}
	}
	public void raise(double amount) {
		if(this.amtKeptAtTable != dealer.getCurrBet()) {
			//Check if you have enough balance else all in.
			//Add amount to pot
			amtKeptAtTable = dealer.getCurrBet()  + amount ;
			//Send msg to dealer to increase currBet and move to next
		}
	}
	public void call() {
		amtKeptAtTable = dealer.getCurrBet();
		//Add Amount to pot
		//send msg to dealer to move to next
		
	}
	public void fold() {
		isFolded = true;
	}
}
