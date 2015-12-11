// Program encrypts a four-digit number.
import java.awt.*;
import javax.swing.JOptionPane;

public class Encrypt {

   // Java应用程序的入口main()方法
   public static void main( String args[] )
   {
      int number;          // 用户输入的四位数
      int[] digit;          // 第1位数
      //int digit2;          // 第2位数
      //int digit3;          // 第3位数
      //int digit4;          // 第4位数
      //int c;
      int encryptedNumber; // 加密后的数字
      
	  digit=new int[4];
	  
      // 输入一个四位数，保存在变量number中
      String inputNumber = 
         JOptionPane.showInputDialog( "Enter a four digit number: " );
      number = Integer.parseInt( inputNumber );

      // 加密
      /* 编写代码，对四位数中的每一位数按照问题描述中的方式进行加密运算 */
      for(int i=0;i<inputNumber.length();i++){
      	digit[i]=Integer.parseInt((inputNumber.substring(i,i+1)));
      	digit[i]=(digit[i]+7)%10;
      }

      /* 编写代码，交换第1个数字和第3个数字、第2个数字和第4个数字，生成加密后的数字 */
      //c=digit[0];digit[0]=digit[2];digit[2]=c;
      //c=digit[1];digit[1]=digit[3];digit[3]=c;
      encryptedNumber=Integer.parseInt((Integer.toString(digit[2])+Integer.toString(digit[3])+
        Integer.toString(digit[0])+Integer.toString(digit[1])));

      /* 编写代码，用message dialog显示加密的结果 */
      JOptionPane.showMessageDialog(null,number+"加密之后是："+encryptedNumber,
      "密文",JOptionPane.INFORMATION_MESSAGE);

      System.exit( 0 );

   } // end method main

} // end class Encrypt
