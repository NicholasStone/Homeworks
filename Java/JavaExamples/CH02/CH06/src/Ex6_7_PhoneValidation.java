import java.io.*;

public class Ex6_7_PhoneValidation {
	public static void main(String[] args) throws IOException {
		boolean contiGo = true;
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		// �����ʾ�ֻ������������ʽ
		String regex = "(13\\d|15[036-9]|18[689])\\d{8}";
		String phoneNumber = "";
		while (contiGo) {
			System.out.println("�������ֻ�����");
			phoneNumber = buf.readLine();
			boolean match = phoneNumber.matches(regex);
			if (match) {
				System.out.println(phoneNumber + "�ǺϷ��ֻ�����");
				break;
			} else
				System.out.println(phoneNumber + "���ǺϷ��ֻ�����");
		}
	}
}
