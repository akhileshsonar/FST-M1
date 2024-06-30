package my_test_pack;

public class NotEnoughFundsException extends RuntimeException {
	
	    public NotEnoughFundsException(Integer amount, Integer balance) {
	        super("Attempted to withdraw " + amount + " with a balance of " + balance);
	    }

	}
