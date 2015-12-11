import java.io.*;
class EmployeeRecord {
	int id;
	String name;
	double salary;
	EmployeeRecord(int i,String n,double s){  //���췽��
		id=i;
		name=n;
		salary=s;
	}
	public void read(RandomAccessFile file)throws IOException { //��һ����¼
		id=file.readInt();        //��һ��int����
		byte[] b=new byte[10];    //���峤��Ϊ10���ֽ�����b
		file.readFully(b);        //���ļ���10���ֽڵ�����b��
		name=new String(b);       //��b�����е��ֽ����ݱ���Ϊ�ַ���
		salary=file.readDouble(); //��һ��double����
	}
	public void write(RandomAccessFile file)throws IOException { //дһ����¼
		file.writeInt(id);        //дһ��int����
		byte[] b=new byte[10];    //���峤��Ϊ10���ֽ�����b
		if(name!=null){
			byte[] temp=name.getBytes();  //���ַ���ת��Ϊ�ֽ����ݴ洢��temp������
			System.arraycopy(temp, 0, b, 0, temp.length);//temp���鸴�Ƶ�b����
		}
		file.write(b);            //��b�����е��ֽ�����д���ļ�
		file.writeDouble(salary); //дһ��double����
	}
	public int size(){return 22;} //����һ��ְ����¼�ĳ���(4+10+8=22Byte)
	public void setId(int i){id=i;}
	public void setName(String n){name=n;}
	public void setSalary(double s){salary=s;}
	public int getId(){return id;}
	public String getName(){return name;}
	public double getSalary(){return salary;}
}

public class Ex9_9_RandFile {
	public static void main(String arg[]){
		RandomAccessFile file;
		EmployeeRecord e1 = new EmployeeRecord(1001,"����",5678.50);
		EmployeeRecord e2 = new EmployeeRecord(1002,"����",6758.60);		
		EmployeeRecord e3 = new EmployeeRecord(1003,"����",5867.70);
		EmployeeRecord e4 = new EmployeeRecord(1004,"����",7865.80);		
		EmployeeRecord emp = new EmployeeRecord(0,"",0.0);
		try{
			file=new RandomAccessFile("Employee.dat","rw");  //������ļ�
			e1.write(file);   //ְ������e1�����ݼ�¼д���ļ�
			e2.write(file);   //ְ������e2�����ݼ�¼д���ļ�
			e3.write(file);   //ְ������e3�����ݼ�¼д���ļ�
			file.seek(1*emp.size());  //�ƶ��ļ���дָ�뵽��2����¼
			emp.read(file);   //����2����¼������emp�У�ָ���3����¼
			emp.setName("����");  //�޸Ķ���emp������
			file.seek(1*emp.size());  //�ƶ��ļ���дָ���ٴε���2����¼
			emp.write(file); //����emp�е������ٴ�д���ļ�����2����¼�������޸�
			file.seek(file.length()); //�ƶ��ļ���дָ�����ļ�β
			e4.write(file); //���ļ�βд��ְ������e4�����ݼ�¼
			file.seek(0); //�ƶ��ļ���дָ�����ļ���ʼ
			while(file.getFilePointer()<file.length()){ //����ļ��е���������
				emp.read(file);
				System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getSalary());
			}
			file.close(); //�ر��ļ�
		}catch(IOException e){
			System.out.println("�ļ��򿪻�д�ļ�����ļ�ʧ�ܣ�"+e.toString());
			System.exit(1);
		}
	}
}

