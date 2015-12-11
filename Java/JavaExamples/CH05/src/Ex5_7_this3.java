public class Ex5_7_this3 {
	public static void main(String[] args) {
		Dog tom = new Dog();
		System.out.println("新生的tom 身高:"+tom.height+"cm, 年龄:"+tom.age);
		tom=tom.grow();
		System.out.println("长大后的tom 身高:"+tom.height+"cm, 年龄:"+tom.age);
	}
}

class Dog{
	int age;
	float height;
	public Dog(){
		age=1;
		height=10;		
	}
	
	public Dog grow(){
		height = height+10;		
		age++;
		return this;
	}
}
