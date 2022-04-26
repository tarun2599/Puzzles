package Puzzles;

import java.util.ArrayList;

public class Table extends Puzzles
{
	private ArrayList<Player> players = new ArrayList<Player>();
	private Dealer dealer;
	
	private double currBet;
	private ArrayList<Card> flock;
	private Card turn;
	private Card river;
	private boolean showFlock = false, showTurn = false, showRiver = false;
	private int numberOfPlayers = 0;
	private Player raisedBy;
	private int numberOfFolded;
	
	/**
	 * @return the dealer
	 */
	public Dealer getDealer() 
	{
		return dealer;
	}
	
	
	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	
	/**
	 * @return the numberOfPlayers
	 */
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}


	/**
	 * @return the numberOfFolded
	 */
	public int getNumberOfFolded() {
		numberOfFolded = 0;
		for(Player p:players) {
			if(p.isFolded()) {
				numberOfFolded++;
			}
		}
		return numberOfFolded;
	}


	/**
	 * @return the currBet
	 */
	public double getCurrBet() {
		return currBet;
	}
	
	public ArrayList<Card> getFlock() 
	{	
		if(showFlock == false)
		{
			return null;
		}
		return flock;
	}
	public Card getTurn() 
	{
		if(showTurn == false)
			return null;
		return turn;
	}
	public Card getRiver() 
	{
		if(showRiver == false)
			return null;
		return river;
	}
	
	
	public void setFlock(ArrayList<Card> flock) 
	{
		this.flock = flock;
	}
	public void setTurn(Card turn) {
		this.turn = turn;
	}
	public void setRiver(Card river) {
		this.river = river;
	}
	public void setShowFlock() {
		this.showFlock = true;
	}
	public void setShowTurn() {
		this.showTurn = true;
	}
	public void setShowRiver() {
		this.showRiver = true;
	}
	
	/**
	 * @param currBet the currBet to set
	 */
	public void setCurrBet(double currBet) {
		this.currBet = currBet;
	}
	
	public void addPlayer(Player P){
		players.add(P);
		numberOfPlayers++;
	}
	
	public void setDealer(Dealer D){
		if(dealer == null)
			dealer = D;
	}
	/**
	 * 
	 * @param amount Amount to be added to the pot
	 */
	public void addMoneyToPot(double amount, Player p) {
		dealer.credit(amount);
		p.debit(amount);
	}
	
	public Player getRaisedBy() {
		return raisedBy;
	}


	public void setRaisedBy(Player raisedBy) {
		this.raisedBy = raisedBy;
	}
	
	

	/**
	 *
	 */
	@Override
	public String toString() {
		String str = players.toString();
		str += "\nFlock: " + flock + "\nTurn: " + turn + "\nRiver: " + river;
		str += "\nRaised by: " + raisedBy;
		str += "\nCurrent Bet: " + currBet;
		return str;
	}

}
