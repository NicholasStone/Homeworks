import java.util.Scanner;

public class Ex4_10_testBreak{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("������һ����������");
		int n = sc.nextInt();

boolean flag = true;
		for(int i=2; i<n; i++){
			if(n % i == 0){
				flag = false;
				break;
			}	
		}
		if( flag)
			System.out.print("������");
		else
			System.out.print("��������");
	}
}
