public class Ex5_14_SuperUse {
	public static void main(String[] args) {
		SubClass sc1 = new SubClass();//
		SubClass sc2 = new SubClass(400);
	}
}

class SuperClass {
	private int n;

	SuperClass() {
		System.out.println("SuperClass()");
	}

	SuperClass(int n) {
		System.out.println("SuperClass(" + n + ")");
		this.n = n;
	}
}

class SubClass extends SuperClass {
	private int n;

	SubClass(int n) {
		super();// A行，可以通过super调用父类构造方法
		System.out.println("SubClass(" + n + ")");
		this.n = n;
	}

	SubClass() {
		super(300); // B行，显式调用父类的特定构造方法
		System.out.println("SubClass()");
	}
}
