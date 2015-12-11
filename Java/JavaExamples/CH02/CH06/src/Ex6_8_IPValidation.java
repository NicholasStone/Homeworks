
import java.io.*;
public class Ex6_8_IPValidation {
	public static void main(String[] args) throws Exception {
		boolean contiGo = true;
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		String number = "((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))";
		String regex = "(" + number + "\\.){3}" + number;// 定义表示IP的正则表达式
		String ipNumber = "";
		while (contiGo) {
			System.out.println("请输入IP地址");
			ipNumber = buf.readLine();
			boolean match = ipNumber.matches(regex);
			if (match) {
				System.out.println(ipNumber + "是合法IP地址");
				break;
			} else
				System.out.println(ipNumber + "\n不是合法IP地址");
		}
	}
}

