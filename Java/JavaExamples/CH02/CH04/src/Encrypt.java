// Program encrypts a four-digit number.
import java.awt.*;
import javax.swing.JOptionPane;

public class Encrypt {

   // JavaӦ�ó�������main()����
   public static void main( String args[] )
   {
      int number;          // �û��������λ��
      int[] digit;          // ��1λ��
      //int digit2;          // ��2λ��
      //int digit3;          // ��3λ��
      //int digit4;          // ��4λ��
      //int c;
      int encryptedNumber; // ���ܺ������
      
	  digit=new int[4];
	  
      // ����һ����λ���������ڱ���number��
      String inputNumber = 
         JOptionPane.showInputDialog( "Enter a four digit number: " );
      number = Integer.parseInt( inputNumber );

      // ����
      /* ��д���룬����λ���е�ÿһλ���������������еķ�ʽ���м������� */
      for(int i=0;i<inputNumber.length();i++){
      	digit[i]=Integer.parseInt((inputNumber.substring(i,i+1)));
      	digit[i]=(digit[i]+7)%10;
      }

      /* ��д���룬������1�����ֺ͵�3�����֡���2�����ֺ͵�4�����֣����ɼ��ܺ������ */
      //c=digit[0];digit[0]=digit[2];digit[2]=c;
      //c=digit[1];digit[1]=digit[3];digit[3]=c;
      encryptedNumber=Integer.parseInt((Integer.toString(digit[2])+Integer.toString(digit[3])+
        Integer.toString(digit[0])+Integer.toString(digit[1])));

      /* ��д���룬��message dialog��ʾ���ܵĽ�� */
      JOptionPane.showMessageDialog(null,number+"����֮���ǣ�"+encryptedNumber,
      "����",JOptionPane.INFORMATION_MESSAGE);

      System.exit( 0 );

   } // end method main

} // end class Encrypt
