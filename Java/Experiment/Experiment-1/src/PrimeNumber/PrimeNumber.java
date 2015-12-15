package PrimeNumber;

/**
 * Created on 2015/12/15 14:10
 */
public class PrimeNumber{
	public static int[] PrimeNumber(){
		int result[] = new int[30];
		int limit, index = 0;
		boolean isPrime;
		for(int i = 2; i < 98; i++){
			isPrime = true;
			limit = (int)Math.sqrt(i);
			for(int j = limit; j > 1 ;j--){
				if(i%j == 0){
					isPrime =false;
					break;
				}
			}
			if(isPrime){
				result[index] = i;
				index++;
			}
		}

		return result;
	}
}
