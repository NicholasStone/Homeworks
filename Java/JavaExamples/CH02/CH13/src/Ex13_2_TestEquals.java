public class Ex13_2_TestEquals {
   public static void main(String args[]){
	   String name1=new String("张三");
	   String name2=new String("张三");
	   String name3="张三";
	   String name4="张三";
	   System.out.println(name1.equals(name2));       //值相等，地址不同
	   System.out.println(name1.equals(name3));       //值相等，地址不同
	   System.out.println(name3.equals(name4));       //值相等，地址相同
	   System.out.println(name1==name2);            //值相等，地址不同
	   System.out.println(name1==name3);            //值相等，地址不同
	   System.out.println(name3==name4);            //值相等，地址相同
   }
}

