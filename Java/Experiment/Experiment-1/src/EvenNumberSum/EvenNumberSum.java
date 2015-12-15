package EvenNumberSum;

/**
 * Created on 2015/12/15 13:23
 */
public class EvenNumberSum{
	public static int EvenNumberSum(){
		int result = 0;

		for (int i = 100; i>1; i--){
			if (i%2 == 0){
				result += i;
			}
		}

		return result;
	}
}