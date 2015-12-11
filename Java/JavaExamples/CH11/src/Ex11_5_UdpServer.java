//服务端程序，Ex11_5_UdpServer.java
import java.io.*;
import java.net.*;
class Ex11_5_UdpServer{
public static void main(String[] args) throws IOException{
 System.out.println("Server starting…\n"); 
DatagramSocket s = new DatagramSocket(5555);
//创建一个绑定到5555端口的数据报套接字
byte[] data = new byte[200];
//创建一个用于保存数据包的字节数组
DatagramPacket dgp = new DatagramPacket(data,data.length);
//创建一个DatagramPacket对象封装了一个指向字节数组和目标的地址//信息,这个DatagramPacket对象没有初始化地址是因为它包含了
//来自客户端的地址信息
while(true){
s.receive(dgp);
//从客户端接受数据包
System.out.println(new String(data));
//显示数据包的内容
s.send(dgp);
//回应一个信息给客户端
}
}
}