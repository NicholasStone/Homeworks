import java.io.*;
public class Ex9_6_1_InputInt {
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("输入一个整数：");
		String str=br.readLine();
		int x=Integer.parseInt(str);
		System.out.println("输入的整数是："+x);
	}
}