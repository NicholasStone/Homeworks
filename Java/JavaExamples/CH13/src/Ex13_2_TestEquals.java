public class Ex13_2_TestEquals {
   public static void main(String args[]){
	   String name1=new String("����");
	   String name2=new String("����");
	   String name3="����";
	   String name4="����";
	   System.out.println(name1.equals(name2));       //ֵ��ȣ���ַ��ͬ
	   System.out.println(name1.equals(name3));       //ֵ��ȣ���ַ��ͬ
	   System.out.println(name3.equals(name4));       //ֵ��ȣ���ַ��ͬ
	   System.out.println(name1==name2);            //ֵ��ȣ���ַ��ͬ
	   System.out.println(name1==name3);            //ֵ��ȣ���ַ��ͬ
	   System.out.println(name3==name4);            //ֵ��ȣ���ַ��ͬ
   }
}

