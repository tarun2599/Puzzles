package Puzzles;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Accounts{
	static Scanner s = new Scanner(System.in);
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
	
	/**
	 * Raise the bet. If you have not already met the current bet this 
	 * functions as call and raise. 
	 * @param amount Amount by which you want to raise the bet.
	 */
	public void raise(double amount) {
			//Check if you have enough balance else all in.
			double newBet = table.getCurrBet()  + amount;
			table.addMoneyToPot(newBet - amtKeptAtTable, this);//Add amount to pot
			amtKeptAtTable = newBet;
			table.setCurrBet(newBet);
			table.setRaisedBy(this);
	}
	
	/**
	 * Matches your bet to the current bet on table.
	 */
	public void call() {
		table.addMoneyToPot(table.getCurrBet() - amtKeptAtTable, this);
		amtKeptAtTable = table.getCurrBet();
	}
	
	
	public void fold() {
		isFolded = true;
	}
	
	/**
	 * Get choice from the player.
	 */
	public void getChoice() {
		int choice;
		do{
			
			System.out.println(this.getName() + "'s Choice...");
			System.out.println("Current Bet: " + table.getCurrBet());
			System.out.println("Your money on table: " + amtKeptAtTable);
			System.out.println("0: Fold");
			System.out.println("1: Check");
			System.out.println("2: Call");
			System.out.println("3: Raise");
			choice  = Integer.parseInt(s.next());
				
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
						raise(Integer.parseInt(s.next()));
						break;
			}
		}catch(IllegalCheckException e) {
			System.out.println(e.getMessage());
			getChoice();
		}finally {
			//s.close();
		}
	}
	
	@Override
	public String toString() {
		return "\nName = " + this.getName() + "\n"+ inHandCards + "\n" + "balance: " + this.getBalance();
	}
}
