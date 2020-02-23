
public class SavingsAccount {
	public static double annualInterestRate;
	private double savingsBalance;
	
	public SavingsAccount(double balance)
	{
		if(balance < 0.00)
			throw new IllegalArgumentException("Invalid Amount, must be over 0.00");
		
		this.savingsBalance = balance;
	}
	
	public void modifyInterestRate(double newValue)
	{
		annualInterestRate = newValue;
	}
	
	public void calculateMonthlyInterest()
	{
		double interest = (this.savingsBalance * annualInterestRate) / 12;
		this.savingsBalance += interest;
	}
	
	public double getSavingsBalance()
	{return this.savingsBalance;}
}
