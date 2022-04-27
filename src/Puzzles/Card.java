package Puzzles;

public class Card extends Puzzles
{
	private int value;
	private String suit;
	
	Card(int value, String suit)
	{
		this.value = value;
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}
	
	public String getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return "|" + value + ":" + suit + "|";
	}
	
}
