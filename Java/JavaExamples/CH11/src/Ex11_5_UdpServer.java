//����˳���Ex11_5_UdpServer.java
import java.io.*;
import java.net.*;
class Ex11_5_UdpServer{
public static void main(String[] args) throws IOException{
 System.out.println("Server starting��\n"); 
DatagramSocket s = new DatagramSocket(5555);
//����һ���󶨵�5555�˿ڵ����ݱ��׽���
byte[] data = new byte[200];
//����һ�����ڱ������ݰ����ֽ�����
DatagramPacket dgp = new DatagramPacket(data,data.length);
//����һ��DatagramPacket�����װ��һ��ָ���ֽ������Ŀ��ĵ�ַ//��Ϣ,���DatagramPacket����û�г�ʼ����ַ����Ϊ��������
//���Կͻ��˵ĵ�ַ��Ϣ
while(true){
s.receive(dgp);
//�ӿͻ��˽������ݰ�
System.out.println(new String(data));
//��ʾ���ݰ�������
s.send(dgp);
//��Ӧһ����Ϣ���ͻ���
}
}
}