public class Ex5_11_setGet {
	public static void main(String[] args) {
		Student2 s1;
		s1 = new Student2();
		s1.setgpa(26.5f);
		s1.setInfo("赵强", "20100038", "山西太原");
		s1.getInfo();
	}
}

class Student2 {
	public String name; // 姓名
	public String studentID; // 学号
	private String address; // 住址
	public String mobilePhone;// 联系电话
	protected String major; // 专业
	private float gpa; // 平均成绩点数

	// 获得平均成绩点数
	public float getgpa() {
		return gpa;
	}

	// 修改平均成绩点数
	public void setgpa(float gpa) {
		this.gpa = gpa;
	}

	public void setInfo(String n, String ID, String add) {
		name = n;
		studentID = ID;
		address = add;
	}

	public void setInfo(float g, String ID) {
		gpa = g;
		studentID = ID;
	}

	public void getInfo() {
		System.out.println("学号：" + studentID + "\t姓名:" + name + "\t地址："
				+ address + "\t总学分绩点:" + gpa);
	}
}
