public class Ex5_20_Static {

	public static void main(String[] args) {
		System.out.println(staticTestFunction.addUP(10, 5));// 正确，类方法可被类直接调用
		// System.out.println(staticTestFunction.sub());//错误 ，实例方法不能被类直接调用
		staticTestFunction test = new staticTestFunction();
		System.out.println(test.sub());
	}
}

class staticTestFunction {
	int x = 10, y = 6;
	static int z = 9;

	public static int addUP(int a, int b) { // 被声明为类方法
		return a + b + z;// 类方法中能使用类变量
	}

	public int sub() {
		return x - y;
	}

	public static int addUP() {
		return x + y;// 错误,类方法中不能使用实例变量
	}
}
