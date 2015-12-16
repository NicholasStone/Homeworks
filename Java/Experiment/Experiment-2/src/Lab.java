/**
 * Created on 2015/12/15 18:48
 */
import MatrixSum.MatrixSum;
import Sort.Sort;
import CountingWords.CountingWords;

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
		System.out.println("3.Counting words");
		String sentence = "Sentence:To be, or not to be: that is the question: Whether 'tis nobler in the mind to suffer.";
		System.out.println(sentence);
		System.out.println("The count of words of the sentence above is : " + CountingWords.CountingWords(sentence));
	}
}
