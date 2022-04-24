package Puzzles;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Accounts{
	
	private double amtKeptAtTable;	//InOneRound
	private Table table;
	private ArrayList<Card> inHandCards;
	private boolean isFolded;
	
	public Player(Table gameTable,double buyIn, String name) 
	{
		super(buyIn, name);
		this.table = gameTable;
		this.inHandCards = new ArrayList<Card>();
		this.amtKeptAtTable = 0;
		this.isFolded = false;
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
	
	/**
	 * @return the isFolded
	 */
	public boolean isFolded() {
		return isFolded;
	}
	
	
	/**
	 * @return the amtKeptAtTable
	 */
	public double getAmtKeptAtTable() {
		return amtKeptAtTable;
	}

	public void check() {
		if(amtKeptAtTable != table.getCurrBet()) {
			throw new IllegalCheckException("Please fold or raise");
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
		isFolded = true;
	}
	
	public void getChoice() {
		
		Scanner s = new Scanner(System.in);
		int choice;
		do{
			
			System.out.println(this.getName() + "'s Choice...");
			System.out.println("Current Bet: " + table.getCurrBet());
			System.out.println("Your money on table: " + amtKeptAtTable);
			System.out.println("0: Fold");
			System.out.println("1: Check");
			System.out.println("2: Call");
			System.out.println("3: Raise");
			choice  = s.nextInt();
		}while((!(choice == 0 || choice == 1 || choice == 2 || choice ==3)));
		try {
			switch(choice) {
				case 0: fold();
						break;
				case 1: check();
						break;
				case 2: call();
						break;
				case 3: System.out.println("Raise by amount: ");
						raise(s.nextInt());
						break;
			}
		}catch(IllegalCheckException e) {
			System.out.println(e.getMessage());
			getChoice();
		}finally {
			s.close();
		}
	}
	
	@Override
	public String toString() {
		return "\nName = " + this.getName() + "\n"+ inHandCards + "\n" + "balance: " + this.getBalance();
	}
}
