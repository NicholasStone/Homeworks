import java.io.*;
public class Ex7_5_ThrowsException {
	public static int calc(int x) {
		int z=0;
		z=110/x;
		return z;	
	}
	public static void main(String[] args) {
		int a=0;
		try{
			a=calc(0);
			System.out.println("a="+a);
		}catch(ArithmeticException e){
			System.out.println("���÷���calcʱ�����쳣"+e.getMessage());
			e.printStackTrace();
		}
	}
}
