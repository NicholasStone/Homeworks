import java.io.*;
public class Ex6_3_MatrixMultiply{
  public static void main(String args[]) throws IOException
  {
    int j,k,m,aH=2,aL=3,bL=4,a[][],b[][],c[][];//暂设a数组大小为2×3，b数组为3×4
        
    a=new int[aH][aL];
    b=new int[aL][bL];
    c=new int[aH][bL];
    //随机产生两个数组的元素
    for(j=0;j<aH;j++)
      for(k=0;k<aL;k++){       
        a[j][k]=(int)(Math.random()*10);
      }
    
    for(j=0;j<aL;j++)
      for(k=0;k<bL;k++){        
        b[j][k]=(int)(Math.random()*10);
      }
    System.out.println("a矩阵元素如下：");
    for(j=0;j<aH;j++){
      for(k=0;k<aL;k++)
        System.out.print(a[j][k]+"\t");
      System.out.println();
    }
    System.out.println("b矩阵元素如下：");
    for(j=0;j<aL;j++){
      for(k=0;k<bL;k++)
        System.out.print(b[j][k]+"\t");
      System.out.println();
    }
    System.out.println("求出的(c=a×b)矩阵元素如下：");
    for(j=0;j<aH;j++){
      for(m=0;m<bL;m++){
        for(k=0;k<aL;k++)
          c[j][m]=c[j][m]+a[j][k]*b[k][m];//矩阵相乘计算关键算法
        System.out.print(c[j][m]+"\t\t");
      }
      System.out.println();
    }
  }
}
