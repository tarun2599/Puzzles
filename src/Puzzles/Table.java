package Puzzles;

import java.util.ArrayList;

public class Table extends Puzzles
{
	private ArrayList<Player> players;
	private Dealer dealer;
	
	private ArrayList<Boolean> isFolded;
	private ArrayList<Boolean> playersChance;
	
	private double currBet;
	
	private ArrayList<Card> flock;
	private Card turn;
	private Card river;
	private boolean showFlock = false, showTurn = false, showRiver = false;

	
	Table(ArrayList<Player> players, Dealer d1)
	{
		this.players = players;
		this.dealer = d1;
		this.playersChance = new ArrayList<Boolean>(players.size());
		this.isFolded = new ArrayList<Boolean>(players.size());
		
		for(int i =0; i < players.size(); i++) {
			playersChance.set(i, false);
			isFolded.set(i, false);
		}
		
	}
	
	/**
	 * @return the dealer
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	
	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
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
	
	public void addPlayer(Player P)
	{
		players.add(P);
	}
	
	public void setMeFolded(Player p) {
		int index = players.indexOf(p);
		isFolded.set(index, true);
	}
	
	public void setPlayersChance(int i) {
		playersChance.set(i, true);
	}
}
