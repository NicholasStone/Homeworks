import java.io.*;
public class Ex9_6_1_InputInt {
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("����һ��������");
		String str=br.readLine();
		int x=Integer.parseInt(str);
		System.out.println("����������ǣ�"+x);
	}
}