import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ex7_7_1_ThrowsException {
	public static void main(String args[]){
		System.out.println("����һ���ı�:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader inputReader = new BufferedReader(isr);
		try{
			String inputLine = inputReader.readLine();
			System.out.println("������ı���:" + inputLine);
		}catch(IOException e){
			System.out.println("�����쳣:" + e);
		}
	}
}