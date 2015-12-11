public class Ex5_13_Super1 {
	public static void main(String[] args) {
	AClass aClass = new  AClass();
	BClass bClass = new  BClass();
	
	aClass.p1();
	bClass.p1();
	}
}

class AClass{
	int a;
	float a1;
	
	public AClass(){
		a=50;
		a1=99.99f;
	}	
	public void p1(){
		System.out.println("this is a method of  A ");
		System.out.println("a="+a);
	}	
}

class BClass extends AClass{
	int a;//与父类的成员变量名相同，属于变量隐藏现象
	
	public BClass(){
		a=10;
		a1=123.6f;
	}
	
	public void p1(){ //	与父类的成员方法相同，属于方法覆盖现象	
		System.out.println("this is a method of  B ");
		System.out.println("a="+a);//此处的a是BClass的变量值
		super.p1();//通过super关键字调用被覆盖的父类成员方法
		System.out.println("super.a="+super.a);//通过super关键字访问被隐藏的父类成员变量
	}
}
