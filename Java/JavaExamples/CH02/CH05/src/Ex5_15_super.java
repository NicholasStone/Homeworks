public class Ex5_15_super {
	public static void main(String[] args) {
		Doctor d = new Doctor("wang", 1, "wu");
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

		System.out.println("名字:" + name);
		System.out.println("编号" + ID);
		System.out.println("地址" + address);
	}

	public Doctor() {// 如果不定义该无参构造方法，将导致A行提示语法错误
	}
}

class Specialist extends Doctor {
	public Specialist(String name1, int ID1, String address1) {
		super(name1, ID1, address1);
	}

	public Specialist() {
		super();// A行 由于父类已经提供了有参构造方法，系统不再提供默认的无参构造方法
		name = "10";
	}
}
