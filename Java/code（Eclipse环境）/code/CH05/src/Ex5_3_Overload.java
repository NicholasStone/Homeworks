
public class Ex5_3_Overload  {
	public static void main(String[] args){
	Student s1,s2;
	s1 = new Student();
	s2 = new Student();
	s1.setInfo("��ǿ","20100038","ɽ��̫ԭ");
	s2.setInfo(23.5f,"20100089");
	s2.getInfo(23.5f);
	s1.getInfo("ɽ��̫ԭ");	
    }
}

class Student {	
	public String name;       //����
	public String studentID;  //ѧ��	        
	private String address;   //סַ
	public String mobilePhone;//��ϵ�绰
	protected String major;  //רҵ
	private float gpa;      //ƽ���ɼ�����	
	
	public void register() {		
	}	
	//���ƽ���ɼ�����
	public float getgpa() {
		return gpa;	
	}
	
	//�޸�ƽ���ɼ�����
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
		System.out.println("ѧ�ţ�"+studentID+"\tƽ���ɼ�������"+g);	
	}
	public void getInfo(String add) {
		System.out.println("ѧ�ţ�"+studentID+"\t����:"+name+"\t��ַ��"+add);	
	}
}

