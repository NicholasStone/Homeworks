/** 
 *����Ҫ���½�һ��600*600���ص�Ӧ�ó��򴰿ڣ����ڴ����л���5����ͬ��ɫ��ͬ��Բ�� 
 *����Բ�Ķ�����Ļ�����ĵ㣬��������Բֱ�ӵİ뾶���50���� 
 *Ч��ͼ����ͼ��ʾ����ɫ������ã���Դ���򱣴�ΪEx15_Circles.java�� 
 *���ܣ���ʾһ����5����ͬ��ɫ��ͬ��Բ 
 **/  
  
 import javax.swing.*;  
 import java.awt.*;  
 import java.awt.Color;  
 public class Ex15_Circles extends JFrame  
 {  
     int red,green,blue;  
     Color color;  
  
     public Ex15_Circles()  
     {  
         super("һ����5����ͬ��ɫ��ͬ��Բ");    //��ʾ��������   
         setSize(600,600);                      //���ô��ڴ�С   
         setVisible(true);                      //����Ϊ�ɼ�   
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڹرն���   
      
     }  
  
      
     public void paint(Graphics g)  
     {  
         //��һ��Բ   
        red=(int)(Math.random()*255);  
        green=(int)(Math.random()*255);  
        blue=(int)(Math.random()*255);  
        color=new Color(red,green,blue);  
        g.setColor(color);  
        g.fillOval(175,175,250,250);  
        //�ڶ���Բ   
        red=(int)(Math.random()*255);  
        green=(int)(Math.random()*255);  
        blue=(int)(Math.random()*255);  
        color=new Color(red,green,blue);  
        g.setColor(color);  
        g.fillOval(200,200,200,200);  
        //������Բ   
        red=(int)(Math.random()*255);  
        green=(int)(Math.random()*255);  
        blue=(int)(Math.random()*255);  
        color=new Color(red,green,blue);  
        g.setColor(color);  
        g.fillOval(225,225,150,150);  
        //���ĸ�Բ   
        red=(int)(Math.random()*255);  
        green=(int)(Math.random()*255);  
        blue=(int)(Math.random()*255);  
        color=new Color(red,green,blue);  
        g.setColor(color);  
        g.fillOval(250,250,100,100);  
        //�����Բ   
        red=(int)(Math.random()*255);  
        green=(int)(Math.random()*255);  
        blue=(int)(Math.random()*255);  
        color=new Color(red,green,blue);  
        g.setColor(color);  
        g.fillOval(275,275,50,50);  
  
     }         
      
     public static void main(String[] args)  
     {  
         Ex15_Circles e = new Ex15_Circles();       
     }  
  
 }  