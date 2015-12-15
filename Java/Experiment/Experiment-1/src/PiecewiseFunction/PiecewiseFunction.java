package PiecewiseFunction;

/**
 * Created on 2015/12/15 14:38
 */
public class PiecewiseFunction{
	public static double PiecewiseFunction(double x){
		return x >= 1 ? (x >= 10 ? 4 * x : 3*x - 2) : x;
	}
}
