package Puzzles;

import java.util.Scanner;

public class PlayHere {
	public static void main(String[] args) {
		Table t1 = new Table();
		Dealer d1 = new Dealer(t1);
		Player p1 = new Player(t1, 500, "Tarun");
		Player p2 = new Player(t1, 500, "Tyagi");
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.addDealer(d1);
		d1.distCards(t1.getPlayers());
		System.out.println(p1);
		System.out.println(p2);
		
		//System.out.println(t1);
	}
	
	public static void getChoice(Player p) {
		
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		while(!(choice == 0 || choice == 1 || choice == 2 || choice ==3)) {
			System.out.println("0: Fold");
			System.out.println("1: Check");
			System.out.println("2: Call");
			System.out.println("3: Raise");
			s.nextInt();
		}
		switch(choice) {
			case 0: p.fold();
					break;
			case 1: p.check();
					break;
			case 2: p.call();
					break;
			case 3: System.out.println("Amount: ");
					p.raise(s.nextInt());
					break;
		}
	}
}
