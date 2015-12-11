import java.util.Scanner;

public class Ex4_3_testIfElseIF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入成绩：");
		int score = sc.nextInt();
		
		char grade;
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("成绩的等级是：" + grade);
		sc.close();
	}
}

