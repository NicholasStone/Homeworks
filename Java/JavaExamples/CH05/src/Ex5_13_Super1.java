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
	int a;//�븸��ĳ�Ա��������ͬ�����ڱ�����������
	
	public BClass(){
		a=10;
		a1=123.6f;
	}
	
	public void p1(){ //	�븸��ĳ�Ա������ͬ�����ڷ�����������	
		System.out.println("this is a method of  B ");
		System.out.println("a="+a);//�˴���a��BClass�ı���ֵ
		super.p1();//ͨ��super�ؼ��ֵ��ñ����ǵĸ����Ա����
		System.out.println("super.a="+super.a);//ͨ��super�ؼ��ַ��ʱ����صĸ����Ա����
	}
}
