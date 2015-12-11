import java.util.Scanner;
public class Ex7_8_DefineException {
	public static void main(String[] args) {
		final int MIN=25,MAX=40;
		Scanner scan=new Scanner(System.in);
		OutOfRangException problem=new OutOfRangException();
		System.out.print("����"+MIN+"��"+MAX+"֮���������");
		try{
			int value=scan.nextInt();
			if(value<MIN||value>MAX)
				throw problem;                  //�׳��Զ����쳣
		}catch(OutOfRangException e){
			System.out.println(e.toString());
		}
		System.out.println("����������.");
	}
}
//�Զ���һ���쳣�࣬����Ϊ��OutOfRangException
class OutOfRangException extends Exception{
	OutOfRangException(){
		super("�������ݳ�����Χ��");
	}
}
