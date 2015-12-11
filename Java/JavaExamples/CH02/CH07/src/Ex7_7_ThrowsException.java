import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Ex7_7_ThrowsException {
	public static void main(String args[]) throws IOException{
		System.out.println("输入一行文本:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader inputReader = new BufferedReader(isr);
		String inputLine = inputReader.readLine();
		System.out.println("输入的文本是:" + inputLine);
	}
}
