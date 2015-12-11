import java.io.*;
public class Ex9_7_ObjectStream{
	public static void main(String arg[])throws Exception{
		Employee e1 = new Employee(1001,"Wang",5678.50);
		FileOutputStream fos = new FileOutputStream(".\\object.dat");
		ObjectOutputStream out = new ObjectOutputStream(fos); //�������������
		out.writeObject(e1); //д�����
		out.close();
		FileInputStream fis = new FileInputStream(".\\object.dat");
		ObjectInputStream in = new ObjectInputStream(fis);  //�������������
		Employee e2 = (Employee)in.readObject(); //��ȡ����
		System.out.println("Id: "+e2.id);
		System.out.println("Name: "+e2.name);
		System.out.println("Salary: "+e2.salary);
		in.close();
	}
}
class Employee  implements Serializable{ //����ʵ��Serializable�ӿ�
	int id;
	String name;
	double salary;
	Employee(int i,String n,double s)
	{
		id=i;
		name=n;
		salary=s;
	}
}
