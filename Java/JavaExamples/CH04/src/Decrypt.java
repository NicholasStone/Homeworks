// Program decrypts a four-digit number.
import java.awt.*;
import javax.swing.JOptionPane;

public class Decrypt {
   // JavaӦ�ó������ڣ�main()����
   public static void main( String args[] )
   {
      int number;          // ����
      int digit1;          // ��1λ��
      int digit2;          // ��2λ��
      int digit3;          // ��3λ��
      int digit4;          // ��4λ��
      int decryptedNumber; // ���ܺ��ԭ��

      // �������ģ����浽����number��
      number = Integer.parseInt( JOptionPane.showInputDialog(
         "Enter a four digit number: " ) );

      // ����
      /* ��д���룬�ȷ��������еĸ�λ���֣�Ȼ�����λ���е�ÿһλ�����н������� */

      /* �����ܺ�ĸ�λ���������γ�ԭ�� */

      /* ��д���룬��message dialog��ʾ���ܺ��ԭ�� */

      System.exit( 0 );

   } // end method main
   
} // end class decrypt
