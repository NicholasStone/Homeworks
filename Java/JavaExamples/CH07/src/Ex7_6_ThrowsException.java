import java.io.*;
public class Ex7_6_ThrowsException {
	public static int calc(int x) throws Exception{
		int z=0;
		if(x==0)
			throw new Exception("除数为零！");
		z=110/x;
		return z;	
	}
	public static void main(String[] args) {
		int a=0;
		try{
			a=calc(0);
			System.out.println("a="+a);
		}catch(Exception e){
			System.out.println("调用方法calc时发生异常:"+e.getMessage());
			e.printStackTrace();
		}
	}
}
