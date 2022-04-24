package Puzzles;

import java.util.ArrayList;

public class Table extends Puzzles
{
	private ArrayList<Player> players = new ArrayList<Player>();
	private Dealer dealer;
	
	private ArrayList<Boolean> isFolded = new ArrayList<Boolean>();
	private ArrayList<Boolean> playersChance = new ArrayList<Boolean>();
	
	private double currBet;
	
	private ArrayList<Card> flock;
	private Card turn;
	private Card river;
	private boolean showFlock = false, showTurn = false, showRiver = false;

	
	
	
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
		playersChance.add(false);
		isFolded.add(false);
	}
	
	public void addDealer(Dealer D)
	{
		dealer = D;
	}
	public void setMeFolded(Player p) {
		int index = players.indexOf(p);
		isFolded.set(index, true);
	}
	
	public void setPlayersChance(int i) {
		playersChance.set(i, true);
	}
	private void updateCurrBet(int raise) 
	{
		currBet += raise;
	}
	
	/**
	 *
	 */
	@Override
	public String toString() {
		return players.toString() + "\nFlock: " + flock + "\nTurn: " + turn + "\nRiver: " + river;
	}


	public static void main(String[] args) 
	{
		Table t1 = new Table();
		Dealer d1 = new Dealer(t1);
		Player p1 = new Player(t1, 500, "Tarun");
		Player p2 = new Player(t1, 500, "Tyagi");
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.addDealer(d1);
		d1.distCards(t1.getPlayers());
		System.out.println(t1);
	}

}
