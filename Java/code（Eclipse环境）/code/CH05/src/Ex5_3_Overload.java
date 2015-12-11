
public class Ex5_3_Overload  {
	public static void main(String[] args){
	Student s1,s2;
	s1 = new Student();
	s2 = new Student();
	s1.setInfo("赵强","20100038","山西太原");
	s2.setInfo(23.5f,"20100089");
	s2.getInfo(23.5f);
	s1.getInfo("山西太原");	
    }
}

class Student {	
	public String name;       //姓名
	public String studentID;  //学号	        
	private String address;   //住址
	public String mobilePhone;//联系电话
	protected String major;  //专业
	private float gpa;      //平均成绩点数	
	
	public void register() {		
	}	
	//获得平均成绩点数
	public float getgpa() {
		return gpa;	
	}
	
	//修改平均成绩点数
	public void setgpa() {
		gpa=23.5f;	
	}
	public void setInfo(String n,String ID) {
		name=n;
		studentID=ID;	
	}	
	public void setInfo(String n,String ID,String add) {
		name=n;
		studentID=ID;
		address=add;	
	}
	public void setInfo(float g,String ID) {
		gpa=g;
		studentID=ID;	
	}
	public void getInfo(float g) {
		System.out.println("学号："+studentID+"\t平均成绩点数："+g);	
	}
	public void getInfo(String add) {
		System.out.println("学号："+studentID+"\t姓名:"+name+"\t地址："+add);	
	}
}

