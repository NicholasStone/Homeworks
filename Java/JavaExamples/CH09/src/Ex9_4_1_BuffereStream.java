import java.io.*;
public class Ex9_4_1_BuffereStream {
	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStream os=new FileOutputStream(".\\buffer.bin");//���ֽ��ļ�д
		OutputStreamWriter fout = new OutputStreamWriter(os);//�ֽ���ת���ַ���
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
		InputStream is=new FileInputStream(".\\buffer.bin");//���ֽ��ļ���
		InputStreamReader fin = new InputStreamReader(is);//�ֽ���ת���ַ���
		BufferedReader bin=new BufferedReader(fin);//�ַ���ת��Ϊ������	
		while((str=bin.readLine())!=null)//���ļ��ж�һ���ַ�
			System.out.println(str); //��ʾ
		bin.close();
	}
}
