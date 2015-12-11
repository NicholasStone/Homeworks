import java.util.Scanner;
public class Ex9_12_ScannerDelimiter {
	public static void main(String[] args){ 
        Scanner s = new Scanner("abcd efghijkl..mnop,qrst uvwxyz"); 
        //s.useDelimiter(" |,|\\.");  //设置分隔符为空格或逗号或句点
        while (s.hasNext()) { 
                System.out.println(s.next()); 
        } 
	}
}