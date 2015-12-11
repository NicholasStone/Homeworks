import java.io.*;
public class Ex9_8_RandomAccess {
	final static int DoubleSize=8; //���峣��
	void randomFileTest(String filename)throws IOException{
		RandomAccessFile rf=new RandomAccessFile(filename,"rw"); //������ļ�
		for(int i=0;i<5;i++)
			rf.writeDouble(i*10.0);  //д��5������
		rf.seek(2*DoubleSize); //�ļ�λ��ָ�붨λ�����ļ���ʼ16�ֽڴ�,����3�����ݿ�ʼ��
		rf.writeDouble(110.0001); //���ļ�λ��ָ�봦д���µ�����
		rf.seek(0); //�ƶ��ļ�λ��ָ�����ļ���ʼ
		for(int i=0;i<5;i++)
			System.out.println("Value "+i+": "+rf.readDouble());
		rf.close();
	}
	public static void main(String[] args) {
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String fileName=null;
		Ex9_8_RandomAccess obj=null;
		try{
			System.out.print("����һ���ļ�����");
			fileName=stdin.readLine(); //�Ӽ��������ļ���
			obj=new Ex9_8_RandomAccess();
			obj.randomFileTest(fileName);
		}catch(IOException e){
			System.out.println("�ļ��Ҳ�����"+e);
			e.printStackTrace();
		}
	}
}
