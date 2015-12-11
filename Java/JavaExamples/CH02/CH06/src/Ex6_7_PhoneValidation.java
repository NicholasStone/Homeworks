import java.io.*;

public class Ex6_7_PhoneValidation {
	public static void main(String[] args) throws IOException {
		boolean contiGo = true;
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		// 定义表示手机号码的正则表达式
		String regex = "(13\\d|15[036-9]|18[689])\\d{8}";
		String phoneNumber = "";
		while (contiGo) {
			System.out.println("请输入手机号码");
			phoneNumber = buf.readLine();
			boolean match = phoneNumber.matches(regex);
			if (match) {
				System.out.println(phoneNumber + "是合法手机号码");
				break;
			} else
				System.out.println(phoneNumber + "不是合法手机号码");
		}
	}
}
