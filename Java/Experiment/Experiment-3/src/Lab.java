/**
 * Created on 2015/12/16 16:41
 */

import BankAccount.BankAccount;
import Complex.Complex;
import SuperMarket.SuperMarket;

public class Lab{
	public static void main(String args[]){
		System.out.println("1.Complex");
		System.out.println("The complex numbers is (3.2, 1.7) and (5.8, 6.6)");
		Complex c1 = new Complex(3.2, 1.7);
		Complex c2 = new Complex(5.8, 6.6);
		System.out.println("(3.2, 1.7) + (5.8, 6.6) = " + c1.plus(c1));
		System.out.println("(3.2, 1.7) + (5.8, 6.6) = " + c1.minus(c2));
		System.out.println("(3.2, 1.7) + (5.8, 6.6) = " + c1.times(c2));
		System.out.println("(3.2, 1.7) + (5.8, 6.6) = " + c1.divide(c2));
		System.out.println("2.Bank Account");
		BankAccount bankAccount = new BankAccount(0);
		System.out.println("Bank account has $0");
		bankAccount.deposit(100000);
		System.out.println("Deposit 10000,Bank account has $" + bankAccount.getBalance());
		bankAccount.withdraw(10000);
		System.out.println("Withdraw 1000,Bank account has $" + bankAccount.getBalance());
		System.out.println("3.Get max and min form an array:\n\tCannot show-how");
		System.out.println("4.SuperMarket");
		String GoodsName[] = {"DotA ", "WarCraft", "Call of Duty", "Crysis", "Red Alert", "FIFA", "2K  ", "Halo", "ArmA", "GTA ", "CS:GO"};
		String Producers[] = {"Valve", "Blizzard", "Activision", "Crytek Studios", "EA", "EA", "2K Sports", "Microsoft", "Bohemia", "RockstarGames", "Valve"};
		double Price[] = {0, 90, 286, 70, 99, 360, 285, 249, 319, 113, 48};
		int Count[] = {100000, 100000, 50000, 50000, 30000, 30000, 20000, 50000, 10000, 70000, 60000};
		SuperMarket superMarket  = new SuperMarket(GoodsName, Count, Price, Producers);
		superMarket.Check();
        System.out.println(superMarket.Query(360));
        System.out.println(superMarket.Query("EA",true));
        System.out.println(superMarket.Query("Crysis"));
    }
}
