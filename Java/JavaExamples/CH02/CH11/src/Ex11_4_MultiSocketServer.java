//�������˳���Ex11_4_MultiSocketServer.java
import java.io.*;
import java.net.*;

public class Ex11_4_MultiSocketServer {
	static int num = 1;// �ͻ��˼���

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket client = null;
		while (true) {
			try {
				serverSocket = new ServerSocket(4444);// �󶨶˿�4444�����ͻ�����
			} catch (Exception e) {
				System.out.println("Error:" + e);// ��Ļ��ӡ������Ϣ
				System.exit(-1);
			}
			try {
				client = serverSocket.accept(); // ʹ��accept()�����ȴ��ͻ�����������ʱ
				// ����һ��Socket����
			} catch (Exception e) {
				System.out.println("��������ʧ��!");
				System.exit(-1);
			}
			System.out.println("Client[" + Ex11_4_MultiSocketServer.num
					+ "] ��¼...............");
			ServerThread st = new ServerThread(client);
			Thread t = new Thread(st);
			t.start();
			// �������ͻ����󣬾ݿͻ��������������̲߳�����
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("�ر�ʧ��!");
			}
			num++;// ���ӿͻ�����
		}
	}
}

class ServerThread implements Runnable {
	private Socket client;

	public ServerThread(Socket client) {
		this.client = client;// ��ʼ��client����
	}

	public void run() {// �߳�����
		try {// ʵ�����ݴ���
			BufferedReader is = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			// ��Socket����õ�����������������Ӧ��BufferedReader����
			PrintWriter os = new PrintWriter(client.getOutputStream());
			// ��Socket����õ��������������PrintWriter����
			BufferedReader sin = new BufferedReader(new InputStreamReader(
					System.in));
			// ��ϵͳ��׼�����豸����BufferedReader����
			System.out.println("Client:" + is.readLine()); // �ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
			String inputString = sin.readLine();// �ӱ�׼�������һ�ַ���
			while (inputString != null && !inputString.trim().equals("quit")) {// ���������ַ���Ϊ"quit"
				// ���˳�ѭ��
				os.println(inputString);// ��ͻ���������ַ���
				os.flush();// ˢ���������ʹ��client�����յ����ַ���
				System.out.println("Server���͵���ϢΪ:" + inputString);
				System.out.println("Client���͵���ϢΪ:" + is.readLine()); // �ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
				inputString = sin.readLine();// ��ϵͳ��׼�������һ�ַ���
			}// ����ѭ��
			os.close();// �ر�Socket�����
			is.close();// �ر�Socket������
			client.close();// �ر�Socket
			System.out.println("�������!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}