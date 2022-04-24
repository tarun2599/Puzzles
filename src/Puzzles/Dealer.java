package Puzzles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Dealer extends Accounts 
{
	//Consider dealers account as pot
	private double currBet;
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
		
		public Card getRandomCard() {
			Collections.shuffle(deck);
			return deck.remove(deck.size()-1);
		} 
	}
	
	public Dealer() {
		super(0, "Dealer");
		this.startFromPlayerAtPos = 1;
	}

	/**
	 * @return the currBet
	 */
	public double getCurrBet() {
		return currBet;
	}
	
	
	/**
	 * @param currBet the currBet to set
	 */
	public void setCurrBet(double currBet) {
		this.currBet = currBet;
	}

	private void distCards() 
	{
		Deck d1 = new Deck();
		
	}
	private void waitForPlayerAtPos(int index) {}
	private void updateCurrBet() {}
	private void openFlock() {}
	private void openTurn() {}
	private void openRiver() {}
	private void finaliseRound() {}	//Check and distribute money.
	private void getRandomCard(Deck d) {
		
	}
	public static void main(String[] args) {
		Dealer D1 = new Dealer();
		Deck D = D1.new Deck();
		System.out.println(D.getRandomCard());
	}
}
