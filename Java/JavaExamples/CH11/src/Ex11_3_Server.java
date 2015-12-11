//����˳���Ex11_3_Server.java
import java.io.*;
import java.net.*;

public class Ex11_3_Server {
	public static void main(String args[]) {
		try {
			ServerSocket server = null;
			try {
				server = new ServerSocket(4444); // ����һ��ServerSocket�ڶ˿�4444�����ͻ�����
			} catch (Exception e) {
				System.out.println("Error:" + e);// ��Ļ��ӡ������Ϣ
				System.exit(-1);
			}
			Socket client = null;
			try {
				client = server.accept(); // ʹ��accept()�����ȴ��ͻ������пͻ�����
				// ���������һ��Socket����
			} catch (Exception e) {
				System.out.println("��������ʧ��!");
				System.exit(-1);
			}
			String inputString;
			BufferedReader is = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			// ��Socket����õ�����������������Ӧ��BufferedReader����
			PrintWriter os = new PrintWriter(client.getOutputStream());
			// ��Socket����õ��������������PrintWriter����
			BufferedReader sin = new BufferedReader(new InputStreamReader(
					System.in));
			// ��ϵͳ��׼�����豸����BufferedReader����
			System.out.println("Client���͵���ϢΪ:" + is.readLine()); // �ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
			inputString = sin.readLine(); // �ӱ�׼�������һ�ַ���
			while (inputString != null && !inputString.trim().equals("quit")) {// ������ַ���Ϊ"quit",��ֹͣѭ��
				os.println(inputString); // ��ͻ���������ַ���
				os.flush(); // ˢ���������ʹClient�����յ����ַ���
				System.out.println("Server���͵���ϢΪ:" + inputString); // ����Ļ����ʾ������ַ���
				System.out.println("Client���͵���ϢΪ:" + is.readLine()); // ��Client����һ�ַ���������ӡ����׼�����
				inputString = sin.readLine(); // ��ϵͳ��׼�������һ�ַ���
			} // ����ѭ��
			os.close(); // �ر�Socket�����
			is.close(); // �ر�Socket������
			client.close(); // �ر�Socket
			server.close(); // �ر�ServerSocket
			System.out.println("�������!");
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
}// �������˳������
