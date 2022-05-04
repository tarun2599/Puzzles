package Puzzles;

import java.time.zone.ZoneRules;
import java.util.ArrayList;

public class PlayHere {
	public static void main(String[] args) {
		//Table t1 = new Table();
		//Dealer d1 = new Dealer(t1);
		//Player p1 = new Player(t1, 500, "Tarun");
		//Player p2 = new Player(t1, 500, "Tyagi");
		//t1.addPlayer(p1);
		//t1.addPlayer(p2);
		//t1.setDealer(d1);
		//d1.playRound();
//		d1.playersTurn(t1.getPlayers());
//		p1.getChoice();
//		p2.getChoice();
//		p1.getChoice();
//		p1.raise(12);
//		p2.raise(3);
//		p1.call();
		//System.out.println("---------------------------");
		//System.out.println(t1);
		//System.out.println(d1);
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(10, "Spades"));
		cards.add(new Card(13, "Spades"));
		cards.add(new Card(9, "Spades"));
		cards.add(new Card(11, "Spades"));
		cards.add(new Card(12, "Spades"));
		System.out.println(Hand.isStraight(cards));
		System.out.println(Hand.isFlush(cards));
		System.out.println(Hand.isFourOfAKind(cards));
		System.out.println(Hand.isPair(cards));
		System.out.println(Hand.isTwoPair(cards));
		System.out.println(Hand.isThreeOfAKind(cards));
		System.out.println(Hand.isFullHouse(cards));
		System.out.println(Hand.isStraightFlush(cards));
		System.out.println(Hand.isRoyalFlush(cards));
		
		
		
	}
}
