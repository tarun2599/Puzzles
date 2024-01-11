package Puzzles;

public class IllegalCheckException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IllegalCheckException(String message){
		super(message);
	}
}
