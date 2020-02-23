
public class SavingsAccountTest {

	public static void main(String[] args) {
		//Creation of SavingsAccount objects
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		//Setting annualInterestRate to 4%
		saver1.modifyInterestRate(.04);
		saver2.modifyInterestRate(.04);
		
		//Calculates monthly interest and adds it to the monthly balance
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		//Prints results
		System.out.printf("Results are rounded to the nearest cent...\n");
		System.out.printf("Saver 1 - Monthly Balance: %.02f\n", saver1.getSavingsBalance());
		System.out.printf("Saver 2 - Monthly Balance: %.02f\n", saver2.getSavingsBalance());
		
		//Setting annualInterestRate to 5%
		saver1.modifyInterestRate(.05);
		saver2.modifyInterestRate(.05);
		
		//Calculates new monthly interest anda dd its to the monthly balance
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		//Prints results
		System.out.printf("\n\nResults are rounded to the nearest cent...\n");
		System.out.printf("Saver 1 - Edited Monthly Balance: %.02f\n", saver1.getSavingsBalance());
		System.out.printf("Saver 2 - Edited Monthly Balance: %.02f\n", saver2.getSavingsBalance());
		
	}

}
