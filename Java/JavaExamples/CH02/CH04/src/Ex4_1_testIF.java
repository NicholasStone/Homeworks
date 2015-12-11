import java.util.Scanner;

public class Ex4_1_testIF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ÇëÊäÈë³É¼¨£º");
		int score = sc.nextInt();
		
		if(score >= 0 && score <= 100){
			System.out.println("³É¼¨£º" + score);
		}
		sc.close();
	}
}

