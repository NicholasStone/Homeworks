public class Ex7_3_CatchException {
	public static void main(String args[]){
		int a,b,c;
		a=9;
		b=0;
		try{
			c=a/b;
			System.out.println(a+"/"+b+"="+c);
		}catch(ArithmeticException e){
			System.out.println("���ֱ�0�����쳣���");
		}catch(Exception e){
			System.out.println("�쳣����Ϊ"+e);
		}finally{
			System.out.println("����="+a);
			System.out.println("������="+b);
		}
		a=9;
		b=3;
		try{
			c=a/b;
			System.out.println(a+"/"+b+"="+c);
		}catch(ArithmeticException e){
			System.out.println("���ֱ�0�����쳣���");
		}catch(Exception e){
			System.out.println("�쳣����Ϊ"+e);
		}finally{
			System.out.println("����="+a);
			System.out.println("������="+b);
		}
	}
}
