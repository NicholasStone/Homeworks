package Sort;

import java.util.Scanner;

/**
 * Created on 2015/12/15 18:49
 */
public class Sort{
	public static void Sort(){
		double numbers[] = new double[10];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type in 10 numbers");
		for(int i = 0; i < numbers.length;){
			try{
				numbers[i] = scanner.nextDouble();
				i++;
			}catch(Exception e){
				scanner.next();
				System.out.println("Please type in a number");
			}
		}
		for (int i = 0; i < numbers.length; i++){
			for(int j = 0; j < numbers.length - i - 1; j++){
				if(numbers[j] < numbers[j + 1]){
					double tmp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = tmp;
				}
			}
		}
		for(double n : numbers){
			System.out.print( n +"\t");
		}
	}
}
