package MatrixSum;

/**
 * Created on 2015/12/15 23:14
 */
public class MatrixSum{
	public static double MatrixSum(double Matrix[][]){
		double result = 0;
		for(int row = 0, head = 0, rear = Matrix[0].length - 1; row < Matrix.length; row++, head++, rear--){
			result += (head == rear) ? (Matrix[row][head] + Matrix[row][rear]) : Matrix[row][head];
		}
		return result;
	}
}
