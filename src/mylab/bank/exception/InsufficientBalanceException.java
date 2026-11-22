package mylab.bank.exception;

public class InsufficientBalanceException extends Exception {
	 public InsufficientBalanceException(String message) {
	        super(message);
	    }
	
	public InsufficientBalanceException(String message, double money) {
        super(message + money + "원");
    }
	
	
}



	
	
	
	