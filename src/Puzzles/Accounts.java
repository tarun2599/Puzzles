package Puzzles;

public abstract class Accounts extends Puzzles{
	private int id;
	private double balance;
	private String name;
	
	/**
	 * @param balance
	 * @param name
	 */
	public Accounts(double balance, String name) {
		super();
		this.balance = balance;
		this.name = name;
		this.id = hashCode();
	}
	
	/**
	 * @param name
	 */
	public Accounts(String name) {
		super();
		this.balance = 0;
		this.name = name;
		this.id = hashCode();
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}	
	
	/**
	 * To credit money to the account
	 * @param amount Amount to be added.
	 */
	void credit(double amount) {
		if(amount < 0)
			throw new IllegalArgumentException();
		this.balance += amount;
	}
	
	/**
	 * To debit money from the account
	 * @param amount Amount to be removed.
	 */
	void debit(double amount) {
		if(amount < 0)
			throw new IllegalArgumentException();
		this.balance -= amount;
	}
	
}
