//客户端代码，Ex11_5_UdpClient.java
import java.io.*;
import java.net.*;
class Ex11_5_UdpClient{
public static void main(String[] args){
String host = "localhost";//指定本机为主机
DatagramSocket datagramSocket = null;//定义数据包套接字
try{
datagramSocket = new DatagramSocket();
//客户端创建一个数据报套接字 ，由系统自动分配端口号
byte[] sendBuffer;
sendBuffer = new String("This is a datagram").getBytes();
//创建一个字节数组，用来保存数据包信息的数据部分 
//这个信息最初是字符串对象，在调用getBytes()方法之后，可以转换成字节序列
InetAddress address = InetAddress.getByName(host);
//将主机名转换成InetAddress对象
DatagramPacket datagramPacket = new DatagramPacket(sendBuffer,sendBuffer.length,address,5555);
//创建一个DatagramPacket 对象，它封装了对字节数组的引用和目标地址信息
datagramSocket.send(datagramPacket);
//通过socket发送数据包
byte[] receiveBuffer = new byte[200];
//创建一个字节数组保存服务器的返回
datagramPacket = new DatagramPacket(receiveBuffer,sendBuffer.length,address,5555);
//创建一个DatagramPacket对象，这个对象保存了服务器的返回值
datagramSocket.receive(datagramPacket);
//通过socket接受的数据包

System.out.println(new String(datagramPacket.getData()));
//打印服务器返回并保存在数据包中的值
}
catch (IOException e){
System.out.println(e.toString());
//打印出错信息
}
finally{
if (datagramSocket !=null){
datagramSocket.close();
}
}
}
}
