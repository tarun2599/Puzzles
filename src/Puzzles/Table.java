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
	 */
	@Override
	public String toString() {
		return players.toString() + "\nFlock: " + flock + "\nTurn: " + turn + "\nRiver: " + river;
	}

}
