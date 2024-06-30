package my_test_pack;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class Junit_Activity_2 {
	Scanner input = new Scanner(System.in);
	int CRamount;
	int wdamount;
	@Test
	void notEnoughFunds() {
		System.out.println("Enter credit amount");
		CRamount= input.nextInt();
		Bank_Account account = new Bank_Account(CRamount);
		System.out.println("Amount is set for insufficient amount " + CRamount);
		System.out.println("Enter withdrawal amount");
		wdamount=input.nextInt();
		assertThrows(NotEnoughFundsException.class, () -> account.withdraw(wdamount), "No Sufficient balance");
	}

	@Test
	void enoughFunds() {
		System.out.println("Enter credit amount");
		CRamount = input.nextInt();
		Bank_Account account = new Bank_Account(CRamount);
		System.out.println("Amount is set available for withdrawal " + CRamount);
		System.out.println("Enter withdrawal amount");
		wdamount=input.nextInt();
		assertDoesNotThrow(() -> account.withdraw(wdamount));
	}

}
