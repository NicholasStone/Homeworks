import java.io.*;
public class Ex9_6_InputInt {
	public static void main(String[] args) throws IOException{
		DataInputStream din=new DataInputStream(System.in);
		System.out.print("����һ��������");
		int x=din.readInt();
		System.out.println("����������ǣ�"+x);
	}
}
