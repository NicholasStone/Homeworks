import java.io.*;
class EmployeeRecord {
	int id;
	String name;
	double salary;
	EmployeeRecord(int i,String n,double s){  //构造方法
		id=i;
		name=n;
		salary=s;
	}
	public void read(RandomAccessFile file)throws IOException { //读一条记录
		id=file.readInt();        //读一个int数据
		byte[] b=new byte[10];    //定义长度为10的字节数组b
		file.readFully(b);        //从文件读10个字节到数组b中
		name=new String(b);       //将b数组中的字节数据编码为字符串
		salary=file.readDouble(); //读一个double数据
	}
	public void write(RandomAccessFile file)throws IOException { //写一条记录
		file.writeInt(id);        //写一个int数据
		byte[] b=new byte[10];    //定义长度为10的字节数组b
		if(name!=null){
			byte[] temp=name.getBytes();  //将字符串转换为字节数据存储在temp数组中
			System.arraycopy(temp, 0, b, 0, temp.length);//temp数组复制到b数组
		}
		file.write(b);            //将b数组中的字节数据写入文件
		file.writeDouble(salary); //写一个double数据
	}
	public int size(){return 22;} //返回一个职工记录的长度(4+10+8=22Byte)
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
		EmployeeRecord e1 = new EmployeeRecord(1001,"张三",5678.50);
		EmployeeRecord e2 = new EmployeeRecord(1002,"李四",6758.60);		
		EmployeeRecord e3 = new EmployeeRecord(1003,"王五",5867.70);
		EmployeeRecord e4 = new EmployeeRecord(1004,"赵六",7865.80);		
		EmployeeRecord emp = new EmployeeRecord(0,"",0.0);
		try{
			file=new RandomAccessFile("Employee.dat","rw");  //打开随机文件
			e1.write(file);   //职工对象e1的数据记录写入文件
			e2.write(file);   //职工对象e2的数据记录写入文件
			e3.write(file);   //职工对象e3的数据记录写入文件
			file.seek(1*emp.size());  //移动文件读写指针到第2个记录
			emp.read(file);   //读第2个记录到对象emp中，指向第3个记录
			emp.setName("李宁");  //修改对象emp的姓名
			file.seek(1*emp.size());  //移动文件读写指针再次到第2个记录
			emp.write(file); //对象emp中的数据再次写入文件，第2条记录姓名被修改
			file.seek(file.length()); //移动文件读写指针至文件尾
			e4.write(file); //在文件尾写入职工对象e4的数据记录
			file.seek(0); //移动文件读写指针至文件开始
			while(file.getFilePointer()<file.length()){ //输出文件中的所有数据
				emp.read(file);
				System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getSalary());
			}
			file.close(); //关闭文件
		}catch(IOException e){
			System.out.println("文件打开或写文件或读文件失败："+e.toString());
			System.exit(1);
		}
	}
}

