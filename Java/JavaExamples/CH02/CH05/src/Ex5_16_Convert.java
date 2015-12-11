public class Ex5_16_Convert {
	public static void main(String[] args) {
		C c = new D();// 父类引用指向子类对象
		c.n = 3.1415926;// 修改的是父类引用的被隐藏的变量
		// c.w = 300;//A 行，父类引用不能操作子类对象新增的成员变量该
		// c.cry();//B行,父类引用不能操作子类对象新增的成员方法
		c.m = 186;
		c.f();
		c.g();// c实际是一个子类对象，因此实际调用的是子类的g（）方法

		D d = (D) c;// 将c强制转换为子类对象
		d.n = 555;
		d.f();
		d.g();
		d.cry();
	}
}

class C {
	int m;
	double n;

	void f() {
		System.out.println("被子类继承的方法f()");
	}

	void g() {
		System.out.println("你好，n=" + n + "  m=" + m);
	}
}

class D extends C {
	int n = 12;
	int w;

	void g() {
		System.out.println("子类重写方法g(),n=" + n + "  m=" + m);
	}

	void cry() {
		System.out.println("子类新增的方法");
	}
}
