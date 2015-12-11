import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
public class Ex9_14_ScannerDataInputStream  {
	public static void main(String[] args) throws IOException{
		FileInputStream input=new FileInputStream("d:\\temp.txt");
		Scanner scan=new Scanner(input);
		int ii=scan.nextInt();
		long ll=scan.nextLong();
		float ff=scan.nextFloat();
		double dd=scan.nextDouble();
		String sstr=scan.next();
		scan.close();
		System.out.println(ii+"\n"+ll+"\n"+ff+"\n"+dd+"\n"+sstr);
	}
}
