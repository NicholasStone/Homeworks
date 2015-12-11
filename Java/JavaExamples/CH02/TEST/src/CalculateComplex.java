public class CalculateComplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex com1,com2,com3,temp;
		//float a,b;
		//String str1,str2;
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		com1=new Complex(1f,4f);
		com2=new Complex(-2f,-5f);
		com3=new Complex();
		temp=new Complex();
		temp=temp.complexAdd(com1,com2);
		temp.tostring();
		System.out.println();
		temp.complexSubtract(com1,com2);
		temp.tostring();
		System.out.println();
		temp.complexMul(com1,com2);
		temp.tostring();
		System.out.println();
		

	}

}
