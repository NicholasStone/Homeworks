import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QHcard {
 public static void main(String[] args) {
  // TODO Auto-generated method stub

  CarD123 card1=new CarD123();
  card1.Out12();
 }

}

class CarD123{
 
 int f = 0;
 int i = 0, j = 0, k = 0;  
 int flag = 0;
 int card[][];
 

 //�������һ����
 Random r1;
 Random r2;
 
 public CarD123(){ //���췽�� 

  card= new int[4][13]; 
  r1 = new Random();
  r2 = new Random();
  
  for (i = 0; i < 4; i++){   // �Ѷ�ά�����ֵȫ��ֵΪ0��0��ʾ�ò������κ��ˣ�
   for (j = 0; j < 13; j++) {
    card[i][j] = 0;
   }
  }
 }
 
 public void OutZiMu(int d,String h){
  int j=d;
  String huase=h;
  if(j!=12&&j!=10&&j!=11&&j!=0&&j!=1)
   System.out.print(huase+(j+1)+"  ");
  else if(j==10)
   System.out.print(huase+'J'+"  ");
  else if(j==11)
   System.out.print(huase+'Q'+"  ");
  else if(j==12)
   System.out.print(huase+'K'+"  ");
  else if(j==0)
   System.out.print(huase+'A'+"  ");
  else if(j==1){
   System.out.print(huase+(j+1)+"  ");
   //System.out.print(System.getProperty("file.encoding"));
  }

 }
 public void OutHuaSe(int k,int d){
  int i=k;
  int p=d;
  String huase1="����";
  String huase2="����";
  String huase3="÷��";
  String huase4="����";
  if(i==0){
   OutZiMu(p,huase1);
  }else if(i==1){  
   OutZiMu(p,huase2);
  }else if(i==2){   
   OutZiMu(p,huase3);
  }else if(i==3){  
   OutZiMu(p,huase4);
  } 
 }
 
 public void Out12(){     
  //���Ʋ��֣����ĸ���ҷ��ƣ�KΪ������FΪ���1��2��3��4��ͨ��ͨ�����.card[i][j]��ֵ��������
  for (k = 0; k < 13; k++) {
   for (f = 1; f < 5; f++) {
    do {
     i = r1.nextInt(4);
     j = r2.nextInt(13);

     if (card[i][j] == 0) {
      card[i][j] = f;
      flag = 1;
     } else
      flag = 0;
    } while (flag == 0);
   }

  }
   
  System.out.println("  ���1:");
  for(i=0;i<4;i++){
   for(j=0;j<13;j++){
    if(card[i][j]==1){
     this.OutHuaSe(i,j); 
    }    
   }
  }
  
  System.out.println(" ");
  System.out.println(" ");
  System.out.println("  ���2:");
  for(i=0;i<4;i++){
   for(j=0;j<13;j++){
    if(card[i][j]==2){
     this.OutHuaSe(i,j); 
    }

    
   }
  }
  
  System.out.println(" ");
  System.out.println(" ");
  System.out.println("  ���3:");
  for(i=0;i<4;i++){
   for(j=0;j<13;j++){
    if(card[i][j]==3){
     this.OutHuaSe(i,j); 
    }   
   }
  }
  
  System.out.println(" ");
  System.out.println(" ");
  System.out.println("  ���4:");
  for(i=0;i<4;i++){
   for(j=0;j<13;j++){
    if(card[i][j]==4){
     this.OutHuaSe(i,j); 
    }   
   }
  }
 }
 
}

