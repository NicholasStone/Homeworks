import java.io.*;
public class Ex9_3_FileAppendStream {
	public static void main(String[] args)throws IOException {
		String str="Welcom to Java!";
		FileWriter fw;
		fw=new FileWriter(".\\filestream.txt",true); //�������
		fw.write(str); //д�ַ������ļ������
		fw.close(); //�ر��ļ������
		FileReader fr;
		fr=new FileReader(".\\filestream.txt"); //��������
		int value;
		while((value=fr.read())!=-1)  //���ļ�������������
			System.out.print((char)value);  
		fr.close(); //�ر��ļ�������
	}
}