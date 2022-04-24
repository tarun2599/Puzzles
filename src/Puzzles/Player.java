package Puzzles;

import java.util.ArrayList;

public class Player extends Accounts{
	
	private double amtKeptAtTable;	//InOneRound
	private Table table;
	private boolean isFolded;
	private ArrayList<Card> inHandCards;
	public Player(Table gameTable,double buyIn, String name) {
		super(buyIn, name);
		this.table = gameTable;
	}
	
	public Player(String name) 
	{
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	public void setInHandCards(ArrayList<Card> inHandCards) {
		this.inHandCards = inHandCards;
	}

	public void check() {
		if(amtKeptAtTable != table.getDealer().getCurrBet()) {
			//throw new IllegalCheckException
		}
	}
	public void raise(double amount) {
		if(this.amtKeptAtTable != table.getDealer().getCurrBet()) {
			//Check if you have enough balance else all in.
			double newBet = table.getDealer().getCurrBet()  + amount;
			table.getDealer().credit(newBet - amtKeptAtTable);//Add amount to pot
			debit(newBet - amtKeptAtTable);
			amtKeptAtTable = newBet;
			table.getDealer().setCurrBet(newBet);
		}
	}
	public void call() {
		amtKeptAtTable = table.getDealer().getCurrBet();
		table.getDealer().credit(table.getDealer().getCurrBet() - amtKeptAtTable);
		debit(table.getDealer().getCurrBet() - amtKeptAtTable);
		
	}
	public void fold() {
		isFolded = true;
	}
}
