//�ͻ��˳���Ex11_3_Client.java
import java.io.*;
import java.net.*;

public class Ex11_3_Client {
	public static void main(String[] args) {
		Socket server = null;
		try {
			String inputString;
			server = new Socket("127.0.0.1", 4444);// �򱾻�4444�˿ڷ����ͻ�����
			System.out.println("��������Ϣ:");
			BufferedReader sin = new BufferedReader(new InputStreamReader(
					System.in));
			// ��ϵͳ��׼�����豸����BufferedReadder����
			PrintWriter os = new PrintWriter(server.getOutputStream());
			// ��Socket����õ��������������PrintWriter����
			BufferedReader is = new BufferedReader(new InputStreamReader(
					server.getInputStream()));
			// ��Socket����õ���������������BufferedReader����
			inputString = sin.readLine();// �ӱ�׼�������һ�ַ���
			while (inputString != null && !inputString.trim().equals("quit")) {// ������ַ���Ϊ"quit",��ֹͣѭ��
				os.println(inputString);// ��Server��������ַ���
				os.flush();// ˢ���������ʹServer�������յ����ַ���
				System.out.println("Client���͵���ϢΪ:" + inputString);
				// ����Ļ����ʾ������ַ���
				System.out.println("Server���͵���ϢΪ:" + is.readLine());
				// ��Server����һ�ַ���������ӡ����׼�����
				inputString = sin.readLine(); // ��ϵͳ��׼�������һ�ַ���
			}
			os.close();// �ر�Socket�����
			is.close();// �ر�Socket������
			server.close();// �ر�ServerSocket
			System.out.println("�������!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}// �ͻ��˳������

