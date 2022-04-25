package Puzzles;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends Accounts 
{
	//Consider dealers account as pot
	private Table table;
	private int startFromPlayerAtPos;
	private class Deck
	{
		private ArrayList<Card> deck;
		public Deck()
		{
			deck = new ArrayList<Card>(52);
			for(int i = 0; i < 13; i++)
			{
				deck.add(new Card(i+1, "Spades"));
				deck.add(new Card(i+1, "Clubs"));
				deck.add(new Card(i+1, "Diamonds"));
				deck.add(new Card(i+1, "Hearts"));
			}
		}
		
		public Card getNextCard() {
			return deck.remove(deck.size()-1);
		}
		
		public void shuffle() {
			Collections.shuffle(deck);
		}
	}
	
	public Dealer(Table table) {
		super(0, "Dealer");
		this.startFromPlayerAtPos = 1;
		this.table = table;
	}

	public void distCards(ArrayList<Player> playersList) 
	{
		Deck dealersDeck = new Deck();
		dealersDeck.shuffle();
		
		//Distribute first card to all the players.
		for(int i = startFromPlayerAtPos - 1; i < playersList.size() + startFromPlayerAtPos - 1;i++) {
			playersList.get(i % playersList.size()).setInHandCardOne(dealersDeck.getNextCard());
		}
		
		//Distribute second card to all the players.
		
		for(int i = startFromPlayerAtPos -1 ; i < playersList.size() + startFromPlayerAtPos - 1; i++) {
			playersList.get(i % playersList.size()).setInHandCardTwo(dealersDeck.getNextCard());
		}
		
		
		dealersDeck.getNextCard();	//Skip One Card and distribute flock
		ArrayList<Card> flock = new ArrayList<Card>();
		for(int i =0; i < 3; i++)
			flock.add(dealersDeck.getNextCard());
		table.setFlock(flock);

		dealersDeck.getNextCard();	//Skip One Card and distribute turn
		table.setTurn(dealersDeck.getNextCard());
		
		dealersDeck.getNextCard();	//Skip One Card and distribute river
		table.setRiver(dealersDeck.getNextCard());
	}
	
	
	private void openFlock() 
	{
		table.setShowFlock();
	}
	private void openTurn() 
	{
		table.setShowTurn();
	}
	private void openRiver() 
	{
		table.setShowRiver();
	}
	
	public void playRound() {
		ArrayList<Player> pList = table.getPlayers();
		distCards(pList);
		System.out.println(pList);
		
		System.out.println("Pre Flock Betting: ");
		playersTurn(pList);
		System.out.println(pList);
		System.out.println("Amount in pot: " + this.getBalance());
		openFlock();
		System.out.println("Flock: " + table.getFlock());
		
		System.out.println("Pre Turn Betting: ");
		playersTurn(pList);
		System.out.println(pList);
		System.out.println("Amount in pot: " + this.getBalance());
		openTurn();
		System.out.println("Turn: " + table.getTurn());
		
		
		System.out.println("Pre River Betting: ");
		playersTurn(pList);
		System.out.println(pList);
		System.out.println("Amount in pot: " + this.getBalance());
		openRiver();
		System.out.println("River: " + table.getRiver());
		
		System.out.println("Final Betting: ");
		playersTurn(pList);
		System.out.println(pList);
		System.out.println("Amount in pot: " + this.getBalance());
	}
	
	private void playersTurn(ArrayList<Player> pList) {
		Player p = null;
		int i = startFromPlayerAtPos -1;
		while(table.getRaisedBy() == null || table.getRaisedBy() != p) {
			p = pList.get(i%pList.size());
			if(!p.isFolded()) {
				p.getChoice();
			}
			i = (i+1);
		}
	}
	private void finaliseRound() {
		startFromPlayerAtPos = (startFromPlayerAtPos+1)%table.getNumberOfPlayers();
	}	//Check and distribute money.
}
