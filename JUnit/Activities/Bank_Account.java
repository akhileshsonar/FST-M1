package my_test_pack;


	
	public class Bank_Account {
	    private Integer balance;
	    
	    public Bank_Account(Integer initialBalance) {
	        balance = initialBalance;
	    }

	    public Integer withdraw(Integer amount) {
	        if (balance < amount) {
	            throw new NotEnoughFundsException(amount, balance);
	        }
	        balance -= amount;
	        System.out.println("available Balance is "+balance);
	        return balance;
	    }
}
	
