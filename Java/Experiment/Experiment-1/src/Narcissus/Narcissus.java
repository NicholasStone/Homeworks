package Narcissus;

/**
 * Created on 2015/12/15 13:29
 */
public class Narcissus{
	public static int[] Narcissus(){
		int result[] = new int[4];
		int tmp,mask,sum = 0,index = 0;
		for(int i = 153; i < 999; i++){
			tmp = i;
			sum = 0;
			while(tmp != 0){
				mask = tmp % 10;
				sum += mask*mask*mask;
				tmp /=10;
			}
			if(sum == i){
				result[index] = i;
				index++;
			}
		}
		return result;
	}
}
