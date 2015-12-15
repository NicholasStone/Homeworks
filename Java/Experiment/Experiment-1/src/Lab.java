/**
 * Created on 2015/12/15 13:23
 */
import EvenNumberSum.EvenNumberSum;
import LeapYear.LeapYear;
import Narcissus.Narcissus;
import PrimeNumber.PrimeNumber;
import PiecewiseFunction.PiecewiseFunction;
import PaintingStars.PaintingStars;

public class Lab{
	public static void main(String args[]){
		System.out.println("1.Sum of Even numbers no greater than 100");
		System.out.println(EvenNumberSum.EvenNumberSum());
		System.out.println("2.Narcissus Numbers");
		for(int n : Narcissus.Narcissus()){
			System.out.println(n);
		}
		System.out.println("3.Prime Numbers");
		int limit = 0;
		for(int i : PrimeNumber.PrimeNumber()){
			if(i != 0){
				System.out.print(i+"\t");
				limit++;
				if(limit % 5 == 0){
					System.out.println();
				}
			}
		}
		System.out.println("4.Piecewise Function");
		System.out.println("Input:-3.5\t"+PiecewiseFunction.PiecewiseFunction(-3.5));
		System.out.println("Input:6.7\t"+PiecewiseFunction.PiecewiseFunction(6.7));
		System.out.println("Input:27\t"+PiecewiseFunction.PiecewiseFunction(27));
		System.out.println("5.Painting Stars");
		PaintingStars.PaintingStars();
		System.out.println("6.Leap years");
		LeapYear.LeapYear();
	}
}
