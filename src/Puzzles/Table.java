package Puzzles;

import java.util.ArrayList;

public class Table extends Puzzles
{
	private ArrayList<Card>[] flock;
	private Card turn;
	private Card river;
	private boolean showFlock = false, showTurn = false, showRiver = false;
	private ArrayList<Player> players;
	private Dealer dealer;
	
	public void addPlayer(Player P)
	{
		players.add(P);
	}
	
	Table(ArrayList<Player> players, Dealer d1)
	{
		this.players = players;
		this.dealer = d1;
	}
	public ArrayList<Card>[] getFlock() 
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
	public void setFlock(ArrayList<Card>[] flock) 
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
	 * @return the dealer
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	
	
	
}
