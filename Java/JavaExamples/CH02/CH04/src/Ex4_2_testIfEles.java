import java.util.Scanner;

public class Ex4_2_testIfEles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ɼ���");
		int score = sc.nextInt();
		
		if(score >= 0 && score <= 100){
			System.out.println("�ɼ���" + score);
		}
		else{
			System.out.println("����ĳɼ�Ӧ����0~100֮�䣡");
		}
		sc.close();
	}
}
