import java.util.Scanner;
public class Ex9_12_ScannerDelimiter {
	public static void main(String[] args){ 
        Scanner s = new Scanner("abcd efghijkl..mnop,qrst uvwxyz"); 
        //s.useDelimiter(" |,|\\.");  //���÷ָ���Ϊ�ո�򶺺Ż���
        while (s.hasNext()) { 
                System.out.println(s.next()); 
        } 
	}
}