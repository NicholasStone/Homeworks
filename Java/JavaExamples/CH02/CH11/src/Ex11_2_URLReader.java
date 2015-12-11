//Ex11_2_URLReader.java
import java.io.*;
import java.net.*;

public class Ex11_2_URLReader {
	// ����main�����׳���������
	public static void main(String[] args) throws Exception {
		// ����һ��URL ����
		URL urlSina = new URL("http://www.sina.com.cn/");
		// ʹ��openStream�õ�һ���������ɴ˹���һ��BufferedReader����
		BufferedReader in = new BufferedReader(new InputStreamReader(
				urlSina.openStream()));
		String inputLine;
		// �����������ϵĶ����ݣ�ֱ������Ϊֹ
		while ((inputLine = in.readLine()) != null)
			// �Ѷ�������ݴ�ӡ����Ļ��
			System.out.println(inputLine);
		// �ر�������
		in.close();
	}
}
