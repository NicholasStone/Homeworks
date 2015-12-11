import java.io.*;
public class Ex9_4_BuffereStream {
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		FileWriter fout = new FileWriter(".\\buffer.txt");//���ı��ļ�д
		BufferedWriter bout=new BufferedWriter(fout);//�ַ���ת��Ϊ������
		String str;
		while(true){
			str=br.readLine(); //�Ӽ��̶�һ���ַ�
			if(str.equals("end"))
				break;
			bout.write(str); //��������ַ�д���ļ���
			bout.newLine(); //д�зָ������ļ���
		}
		bout.close(); //�ر��ļ�
		FileReader fin=new FileReader(".\\buffer.txt");//���ı��ļ���
		BufferedReader bin=new BufferedReader(fin);//�ַ���ת��Ϊ������	
		while((str=bin.readLine())!=null)//���ļ��ж�һ���ַ�
			System.out.println(str); //��ʾ
		bin.close();
	}
}