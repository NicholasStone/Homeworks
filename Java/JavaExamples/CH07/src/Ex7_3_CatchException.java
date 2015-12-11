public class Ex7_3_CatchException {
	public static void main(String args[]){
		int a,b,c;
		a=9;
		b=0;
		try{
			c=a/b;
			System.out.println(a+"/"+b+"="+c);
		}catch(ArithmeticException e){
			System.out.println("出现被0除的异常情况");
		}catch(Exception e){
			System.out.println("异常类型为"+e);
		}finally{
			System.out.println("除数="+a);
			System.out.println("被除数="+b);
		}
		a=9;
		b=3;
		try{
			c=a/b;
			System.out.println(a+"/"+b+"="+c);
		}catch(ArithmeticException e){
			System.out.println("出现被0除的异常情况");
		}catch(Exception e){
			System.out.println("异常类型为"+e);
		}finally{
			System.out.println("除数="+a);
			System.out.println("被除数="+b);
		}
	}
}
