import java.io.*;
public class Ex9_2_FileReaderWriterStream {
	public static void main(String[] args)throws IOException {
		FileWriter fw;
		fw=new FileWriter(".\\filestream.txt"); //���ļ������
		char array[]={'��','��','��','��','��','��','ʾ','��','��'};
		for(int i=0;i<array.length ;i++)
			fw.write(array[i]); //д���ݵ��ļ��������Ҳ����д���ļ�
		fw.close(); //�ر��ļ�����������ر��ļ�
		FileReader fr;
		fr=new FileReader(".\\filestream.txt"); //���ļ�������
		int value;
		while((value=fr.read())!=-1)  //���ļ������������ݣ�Ҳ���Ǵ��ļ�������
			System.out.print((char)value);  
		fr.close(); //�ر��ļ������������ر��ļ�
	}
}