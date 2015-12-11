public class Ex13_1_Person{
	int No;
	public String name;
	public int age;

	public Ex13_1_Person(int No,String myName,int myAge){
		this.No=No;
		name = myName;
		age = myAge;
	}

	public void setName(String n){
		name = n;
	}	
	public String getName(){
		return name;	
	}	
	public void setAge(int a){
		if(a >= 0)
			age = a;	
	}
	public int getAge(){
		return age;	
	}
	
	public void sleep(){
		System.out.println(name + "在睡觉,呼噜噜!");	
	} 
	public String toString(){
		return "姓名：" + this.getName() + "年龄：" + this.getAge();
}

	public static void main(String[] args){
		Ex13_1_Person p = new Ex13_1_Person(1003,"张三",23);
		System.out.println(p);
	}
}
