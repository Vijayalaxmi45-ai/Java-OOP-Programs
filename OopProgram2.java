abstract class Account
{
	private String accountNumber;
	private String holderName;
	private double balance;
	
	public void deposit(double amount)
	{
		balance += amount;
	}		
	public void withdraw(double amount)
	{
		balance -= amount;
	}
	public void displayInfo()
	{
		System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
	}
	public abstract void calculateInterest();
	protected double getBalance()
	{
		return balance;
	}
	protected void setBalance(double balance)
	{
		this.balance = balance;
	}
	public void setAccountNumber(String accNum) 
	{
		accountNumber = accNum; 
	}
    public void setHolderName(String name) 
	{
		holderName = name; 
	}
}
class SavingsAccount extends Account
{
	private double interestRate = 0.05;
	public void calculateInterest()
	{
		double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest added: " + interest);
	}
	public void withdraw(double amount)
	{
		 if (amount <= getBalance()) 
		 {
            setBalance(getBalance() - amount);
            System.out.println(amount + " withdrawn. Balance = " + getBalance());
		 } 
		 else 
		 {
            System.out.println("Insufficient balance!");
		 }
	}
}
class CurrentAccount extends Account
{
	double  overdraftLimit=1000;
	public void calculateInterest()
	{
		System.out.println("Current Account: No interest");
	}
	public void withdraw(double amount)
	{
		if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println(amount + " withdrawn. Balance = " + getBalance());
        } else {
            System.out.println("Exceeds overdraft limit!");
        }
	}
}
class FixedDepositAccount extends Account
{
	 private int tenureMonths = 12;
    private double interestRate = 0.08;
	public void calculateInterest()
	{
		double interest = getBalance() * interestRate * tenureMonths / 12;
        setBalance(getBalance() + interest);
        System.out.println("FD Interest added: " + interest);
	}
}
class AchievePoly
{
	public static void permit(Account ref, double depositAmount, double withdrawAmount)
	{
		 ref.deposit(depositAmount);
        ref.withdraw(withdrawAmount);
        ref.calculateInterest();
        ref.displayInfo();
		System.out.println("----------------------------");
	}
}
class OopProgram2
{
	public static void main(String args[])
	{
		SavingsAccount s = new SavingsAccount();
		CurrentAccount c = new CurrentAccount();
		FixedDepositAccount f = new FixedDepositAccount();
		
		AchievePoly.permit(s, 1000, 200);
        AchievePoly.permit(c, 2000, 500);
        AchievePoly.permit(f, 5000, 0);
	}
}