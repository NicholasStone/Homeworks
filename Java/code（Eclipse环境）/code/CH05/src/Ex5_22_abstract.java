public class Ex5_22_abstract {
	public static void main(String[] args) {
		// Animal a= new Animal();//A �У���ֹʵ����������
		Cat2 tom = new Cat2();
		tom.eat();
		tom.run();
	}
}

abstract class Animal {
	String eyeColor;
	String furColor;
	int age;

	public Animal() {
		age = 0;
	}

	abstract void eat();

	abstract void run();
}

class Cat2 extends Animal {
	void run() {
		System.out.println("è��");
	}

	void eat() {
		System.out.println("������");
	}
}
