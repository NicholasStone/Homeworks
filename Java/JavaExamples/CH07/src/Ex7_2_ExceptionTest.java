public class Ex7_2_ExceptionTest {
	public static void main(String[] args) {
		int i=0;
		String str[]={"One","Two","Three"};
		try{
			while(i<=3){
				System.out.println(str[i]);
				i++;
			}
		}catch(java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println("�����±�Խ���쳣��");
		}finally{
			System.out.println("finally i="+i);
		}
		System.out.println("������������");
	}
}
