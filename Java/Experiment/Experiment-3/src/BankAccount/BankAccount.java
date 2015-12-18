package BankAccount;

/**
 * Created on 2015/12/16 16:56
 */
public class BankAccount{
	private double Balance;

	public BankAccount(double money){
		Balance = money;
	}

	public void deposit(double money){
		Balance += money;
	}

	public void withdraw(double money){
		if(Balance < money){
			System.out.println("Your account has not enough balance");
		}else{
			Balance -= money;
		}
	}

	public double getBalance(){
		return Balance;
	}
}
