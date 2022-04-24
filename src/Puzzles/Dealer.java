package Puzzles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

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

	private void distCards(ArrayList<Player> playersList) 
	{
		Deck dealersDeck = new Deck();
		dealersDeck.shuffle();
		
		//Distribute first card to all the players.
		for(int i = startFromPlayerAtPos - 1; i < playersList.size();i++) {
			playersList.get(i).setInHandCardOne(dealersDeck.getNextCard());
		}
		for(int i = 0; i < startFromPlayerAtPos -1; i++) {
			playersList.get(i).setInHandCardOne(dealersDeck.getNextCard());
		}
		//Distribute second card to all the players.
		for(int i = startFromPlayerAtPos; i < playersList.size();i++) {
			playersList.get(i).setInHandCardTwo(dealersDeck.getNextCard());
		}
		for(int i = 0; i < startFromPlayerAtPos -1; i++) {
			playersList.get(i).setInHandCardTwo(dealersDeck.getNextCard());
		}
		
		dealersDeck.getNextCard();	//Skip One Card and distribute flock
		ArrayList<Card> flock = new ArrayList<Card>(3);
		for(int i =0; i<3;i++)
			flock.set(i, dealersDeck.getNextCard());
		table.setFlock(flock);

		dealersDeck.getNextCard();	//Skip One Card and distribute turn
		table.setTurn(dealersDeck.getNextCard());
		
		dealersDeck.getNextCard();	//Skip One Card and distribute river
		table.setRiver(dealersDeck.getNextCard());
		table.setPlayersChance(startFromPlayerAtPos);
	}
	
	private void waitForPlayerAtPos(int index) {}
	private void updateCurrBet() {}
	private void openFlock() {}
	private void openTurn() {}
	private void openRiver() {}
	private void finaliseRound() {}	//Check and distribute money.
}
