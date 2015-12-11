public class Ex4_8_testForEach{
	public static void main(String args[]){
		int sum = 0;
		int[] a = {13,25,78,12};
		
		for(int i: a){
			sum += i;
		}	
		System.out.println(sum);
	}
}
