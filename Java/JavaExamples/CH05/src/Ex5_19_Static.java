public class Ex5_19_Static {
	public static void main(String[] args) {
		System.out.println("Ŀǰ����������:" + Person.totalNum);

		Person wang = new Person("Wang");
		//System.out.println("Ŀǰ����������:" + wang.totalNum);
		Person liu = new Person("Liu");
		Person zhao = new Person("Zhao");

		System.out.println("Ŀǰ����������:" + Person.totalNum);
		System.out.println("Ŀǰ����������:" + wang.totalNum);
	}
}

class Person {
	static long totalNum = 10000;
	int age;
	String name;
	String id;

	public Person(String name) {
		totalNum++;
		this.name = name;
		age = 1;
	}
}