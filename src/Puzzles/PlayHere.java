package Puzzles;

public class PlayHere {
	public static void main(String[] args) {
		Table t1 = new Table();
		Dealer d1 = new Dealer(t1);
		Player p1 = new Player(t1, 500, "Tarun");
		Player p2 = new Player(t1, 500, "Tyagi");
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.setDealer(d1);
		d1.playRound();
//		d1.playersTurn(t1.getPlayers());
//		p1.getChoice();
//		p2.getChoice();
//		p1.getChoice();
//		p1.raise(12);
//		p2.raise(3);
//		p1.call();
		System.out.println("---------------------------");
		System.out.println(t1);
		System.out.println(d1);
	}
}
