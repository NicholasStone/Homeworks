// Program decrypts a four-digit number.
import java.awt.*;
import javax.swing.JOptionPane;

public class Decrypt {
   // Java应用程序的入口：main()方法
   public static void main( String args[] )
   {
      int number;          // 密文
      int digit1;          // 第1位数
      int digit2;          // 第2位数
      int digit3;          // 第3位数
      int digit4;          // 第4位数
      int decryptedNumber; // 解密后的原文

      // 输入密文，保存到变量number中
      number = Integer.parseInt( JOptionPane.showInputDialog(
         "Enter a four digit number: " ) );

      // 解密
      /* 编写代码，先分离密文中的各位数字，然后对四位数中的每一位数进行解密运算 */

      /* 将解密后的各位数字连接形成原文 */

      /* 编写代码，用message dialog显示解密后的原文 */

      System.exit( 0 );

   } // end method main
   
} // end class decrypt
