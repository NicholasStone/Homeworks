//�ͻ��˴��룬Ex11_5_UdpClient.java
import java.io.*;
import java.net.*;
class Ex11_5_UdpClient{
public static void main(String[] args){
String host = "localhost";//ָ������Ϊ����
DatagramSocket datagramSocket = null;//�������ݰ��׽���
try{
datagramSocket = new DatagramSocket();
//�ͻ��˴���һ�����ݱ��׽��� ����ϵͳ�Զ�����˿ں�
byte[] sendBuffer;
sendBuffer = new String("This is a datagram").getBytes();
//����һ���ֽ����飬�����������ݰ���Ϣ�����ݲ��� 
//�����Ϣ������ַ��������ڵ���getBytes()����֮�󣬿���ת�����ֽ�����
InetAddress address = InetAddress.getByName(host);
//��������ת����InetAddress����
DatagramPacket datagramPacket = new DatagramPacket(sendBuffer,sendBuffer.length,address,5555);
//����һ��DatagramPacket ��������װ�˶��ֽ���������ú�Ŀ���ַ��Ϣ
datagramSocket.send(datagramPacket);
//ͨ��socket�������ݰ�
byte[] receiveBuffer = new byte[200];
//����һ���ֽ����鱣��������ķ���
datagramPacket = new DatagramPacket(receiveBuffer,sendBuffer.length,address,5555);
//����һ��DatagramPacket����������󱣴��˷������ķ���ֵ
datagramSocket.receive(datagramPacket);
//ͨ��socket���ܵ����ݰ�

System.out.println(new String(datagramPacket.getData()));
//��ӡ���������ز����������ݰ��е�ֵ
}
catch (IOException e){
System.out.println(e.toString());
//��ӡ������Ϣ
}
finally{
if (datagramSocket !=null){
datagramSocket.close();
}
}
}
}
