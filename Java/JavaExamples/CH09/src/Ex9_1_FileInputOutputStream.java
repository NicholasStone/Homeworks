import java.io.*;
public class Ex9_1_FileInputOutputStream {
	public static void main(String[] args)throws IOException {
		FileOutputStream fos;
		fos=new FileOutputStream(".\\filestream.dat"); //���ļ������
		byte[] array={1,3,5,7,9,11,13,15,17,19};
		for(int i=0;i<array.length ;i++)
			fos.write(array[i]); //д���ݵ��ļ��������Ҳ����д���ļ�
		fos.close(); //�ر��ļ�����������ر��ļ�
		FileInputStream fis;
		fis=new FileInputStream(".\\filestream.dat"); //���ļ�������
		int value;
		while((value=fis.read())!=-1)  //���ļ������������ݣ�Ҳ���Ǵ��ļ�������
			System.out.print(value+" ");  
		fis.close(); //�ر��ļ������������ر��ļ�
	}
}
