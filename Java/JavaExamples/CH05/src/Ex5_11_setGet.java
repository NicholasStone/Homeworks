public class Ex5_11_setGet {
	public static void main(String[] args) {
		Student2 s1;
		s1 = new Student2();
		s1.setgpa(26.5f);
		s1.setInfo("��ǿ", "20100038", "ɽ��̫ԭ");
		s1.getInfo();
	}
}

class Student2 {
	public String name; // ����
	public String studentID; // ѧ��
	private String address; // סַ
	public String mobilePhone;// ��ϵ�绰
	protected String major; // רҵ
	private float gpa; // ƽ���ɼ�����

	// ���ƽ���ɼ�����
	public float getgpa() {
		return gpa;
	}

	// �޸�ƽ���ɼ�����
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
		System.out.println("ѧ�ţ�" + studentID + "\t����:" + name + "\t��ַ��"
				+ address + "\t��ѧ�ּ���:" + gpa);
	}
}
