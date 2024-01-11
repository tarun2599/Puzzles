package Puzzles;


import java.util.ArrayList;
import java.util.Collections;

public class Hand
{
	ArrayList<Card> cards;
	
	public boolean isStraight()
	{
		cards.sort((Card a, Card b)->(a.getValue() - b.getValue()));
		
		if(cards.get(0).getValue() == 1)
		{
			if(cards.get(1).getValue() == 10 && cards.get(2).getValue() == 11
					&& cards.get(3).getValue() == 12 && cards.get(4).getValue() == 13)
			{
				return true;
			}
			else
				return false;
		}
		for(int i = 1; i < 5; i++)
		{
			if((cards.get(i).getValue() - cards.get(i-1).getValue()) != 1)
				return false;
		}
		return true;
	}
	
	public boolean isFlush()
	{
		
		String suit = cards.get(0).getSuit();
		for(int i = 1; i < 5; i++)
		{
			if(cards.get(i).getSuit().compareTo(suit) != 0)
				return false;
		}
		return true;
	}
	public boolean isFourOfAKind()
	{
		int[] mappingList = new int[14];
		for(int i = 0; i < 5; i++)
		{
			mappingList[cards.get(i).getValue()] = mappingList[cards.get(i).getValue()] + 1;
		}
		for(int i = 1; i < 14; i++)
		{
			if(mappingList[i] == 4)
				return true;
		}
		return false;
	}
	public boolean isPair()
	{
		int[] mappingList = new int[14];
		int count = 0;
		for(int i = 0; i < 5; i++)
		{
			mappingList[cards.get(i).getValue()] = mappingList[cards.get(i).getValue()] + 1;
		}
		for(int i = 1; i < 14; i++)
		{
			if(mappingList[i] == 2)
				count++;
		}
		if(count == 1)
			return true;
		return false;
	}
	public boolean isTwoPair()
	{
		int[] mappingList = new int[14];
		int count = 0;
		for(int i = 0; i < 5; i++)
		{
			mappingList[cards.get(i).getValue()] = mappingList[cards.get(i).getValue()] + 1;
		}
		for(int i = 1; i < 14; i++)
		{
			if(mappingList[i] == 2)
				count++;
		}
		if(count == 2)
			return true;
		return false;
	}
	public boolean isThreeOfAKind()
	{
		int[] mappingList = new int[14];
		int count = 0;
		for(int i = 0; i < 5; i++)
		{
			mappingList[cards.get(i).getValue()] = mappingList[cards.get(i).getValue()] + 1;
		}
		for(int i = 1; i < 14; i++)
		{
			if(mappingList[i] == 3)
				count++;
		}
		if(count == 1)
			return true;
		return false;
	}
	public boolean isFullHouse()
	{
		return (isTwoPair() && isThreeOfAKind());
	}
	
	public boolean isStraightFlush(ArrayList<Card> cards)
	{
		return (isFlush() && isStraight());
	}
	
	public boolean isRoyalFlush()
	{
		cards.sort((Card a, Card b)->(a.getValue() - b.getValue()));
		boolean flag = false;
		if(cards.get(0).getValue() != 1)
			return false;
		else
		{
			if(cards.get(1).getValue() == 10 && cards.get(2).getValue() == 11
					&& cards.get(3).getValue() == 12 && cards.get(4).getValue() == 13)
			{
				flag = true;
			}
			else
				flag = false;
		}
		return (flag && isFlush());
	}
}
