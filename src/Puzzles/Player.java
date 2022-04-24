package Puzzles;

import java.util.ArrayList;

public class Player extends Accounts{
	
	private double amtKeptAtTable;	//InOneRound
	private Table table;
	private ArrayList<Card> inHandCards;
	public Player(Table gameTable,double buyIn, String name) 
	{
		super(buyIn, name);
		this.table = gameTable;
		this.inHandCards = new ArrayList<Card>();
	}
	
	public Player(String name) 
	{
		super(name);
		this.inHandCards = new ArrayList<Card>();
	}
	
	public void setInHandCardOne(Card inHandCardOne) {
		this.inHandCards.add(inHandCardOne);
	}
	
	public void setInHandCardTwo(Card inHandCardTwo) {
		this.inHandCards.add(inHandCardTwo);
	}

	public void check() {
		if(amtKeptAtTable != table.getCurrBet()) {
			//throw new IllegalCheckException
		}
	}
	public void raise(double amount) {
		if(this.amtKeptAtTable != table.getCurrBet()) {
			//Check if you have enough balance else all in.
			double newBet = table.getCurrBet()  + amount;
			table.getDealer().credit(newBet - amtKeptAtTable);//Add amount to pot
			debit(newBet - amtKeptAtTable);
			amtKeptAtTable = newBet;
			table.setCurrBet(newBet);
		}
	}
	public void call() {
		amtKeptAtTable = table.getCurrBet();
		table.getDealer().credit(table.getCurrBet() - amtKeptAtTable);
		debit(table.getCurrBet() - amtKeptAtTable);
		
	}
	public void fold() {
		table.setMeFolded(this);
	}

	@Override
	public String toString() {
		return "\nName = " + this.getName() + "\n"+ inHandCards + "\n";
	}
	
}
