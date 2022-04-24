package Puzzles;

import java.util.ArrayList;

public class Player extends Accounts{
	
	private double balanceForGame;
	private double amtKeptAtTable;	//InOneRound
	private Dealer dealer;
	private boolean isFolded;
	private ArrayList<Card> inHandCards;
	public Player(Dealer d1,double balance, String name) {
		super(balance, name);
		this.dealer = d1;
	}
	
	public Player(String name) 
	{
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
	
	public void setInHandCards(ArrayList<Card> inHandCards) {
		this.inHandCards = inHandCards;
	}

	public void check() {
		if(amtKeptAtTable != dealer.getCurrBet()) {
			//throw new IllegalCheckException
		}
	}
	public void raise(double amount) {
		if(this.amtKeptAtTable != dealer.getCurrBet()) {
			//Check if you have enough balance else all in.
			double newBet = dealer.getCurrBet()  + amount;
			dealer.credit(newBet - amtKeptAtTable);//Add amount to pot
			debit(newBet - amtKeptAtTable);
			amtKeptAtTable = newBet;
			dealer.setCurrBet(newBet);
		}
	}
	public void call() {
		amtKeptAtTable = dealer.getCurrBet();
		dealer.credit(dealer.getCurrBet() - amtKeptAtTable);
		debit(dealer.getCurrBet() - amtKeptAtTable);
		
	}
	public void fold() {
		isFolded = true;
	}
}
