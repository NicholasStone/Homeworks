public class Ex5_15_super {
	public static void main(String[] args) {
		Doctor d = new Doctor("wang", 1, "wu");
		//Doctor d = new Specialist("wang", 1, "wu");
		//Specialist c = new Specialist();
	}
}

class Doctor {
	String name;
	int ID;
	String address;

	public Doctor(String name1, int ID1, String address1) {
		name = name1;
		ID = ID1;
		address = address1;

		System.out.println("����:" + name);
		System.out.println("���" + ID);
		System.out.println("��ַ" + address);
	}

	public Doctor() {// �����������޲ι��췽����������A����ʾ�﷨����
	}
}

class Specialist extends Doctor {
	public Specialist(String name1, int ID1, String address1) {
		super(name1, ID1, address1);
	}

	public Specialist() {
		
		super();// A�� ���ڸ����Ѿ��ṩ���вι��췽����ϵͳ�����ṩĬ�ϵ��޲ι��췽��
		name = "10";
	//	System.out.println("����:" + name);
	}
}