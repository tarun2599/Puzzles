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
	}
}
