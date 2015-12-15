/**
 * Created on 2015/12/15 18:48
 */
import MatrixSum.MatrixSum;
import Sort.Sort;

public class Lab{
	public static void main(String args[]){
		System.out.println("1.Sort");
		Sort.Sort();
		System.out.println("2.Sum of the diagonal elements of the matrix");
		double Matrix[][] = {
			{1,5,6},
			{9,4,7},
			{2,3,8}
		};
		for(double n[] : Matrix){
			for(double num : n){
				System.out.print(num+"\t");
			}
			System.out.println();
		}
		System.out.println("Result = " + MatrixSum.MatrixSum(Matrix));
	}
}
