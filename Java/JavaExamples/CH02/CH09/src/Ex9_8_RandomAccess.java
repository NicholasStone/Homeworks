import java.io.*;
public class Ex9_8_RandomAccess {
	final static int DoubleSize=8; //定义常量
	void randomFileTest(String filename)throws IOException{
		RandomAccessFile rf=new RandomAccessFile(filename,"rw"); //打开随机文件
		for(int i=0;i<5;i++)
			rf.writeDouble(i*10.0);  //写入5个数据
		rf.seek(2*DoubleSize); //文件位置指针定位至距文件开始16字节处,即第3个数据开始处
		rf.writeDouble(110.0001); //在文件位置指针处写入新的数据
		rf.seek(0); //移动文件位置指针至文件开始
		for(int i=0;i<5;i++)
			System.out.println("Value "+i+": "+rf.readDouble());
		rf.close();
	}
	public static void main(String[] args) {
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String fileName=null;
		Ex9_8_RandomAccess obj=null;
		try{
			System.out.print("输入一个文件名：");
			fileName=stdin.readLine(); //从键盘输入文件名
			obj=new Ex9_8_RandomAccess();
			obj.randomFileTest(fileName);
		}catch(IOException e){
			System.out.println("文件找不到："+e);
			e.printStackTrace();
		}
	}
}
