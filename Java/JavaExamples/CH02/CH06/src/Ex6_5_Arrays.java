
import java.util.Arrays;
public class Ex6_5_Arrays {
	public static void main(String[] args) {		
		 int k,baka[]=new int[11],a[]={19,22,15,13,1,0,10,8,2,4,36};
		    System.out.println("\t\t����ǰa�����Ԫ��Ϊ��");
		    for(k=0;k<a.length;k++)    {
		      System.out.print(a[k]+"\t");
		      baka[k]=a[k];
		    }
		    
		    
		    System.out.println();
		    Arrays.sort(a);
		    System.out.println("\t\t��ȫ�����a�����Ԫ��Ϊ��");
		    for(k=0;k<a.length;k++)
		      System.out.print(a[k]+"\t");
		    System.out.println();
		    
		    int key=Arrays.binarySearch(a,10);
		    System.out.println("����ǰ��10λ��a�����"+key+"��Ԫ��");
		    
		    for(k=0;k<baka.length;k++)    {
		      a[k]=baka[k];
		    }
		    
		    Arrays.sort(a,3,8);
		    System.out.println("����(��3������7��Ԫ��)�����a�����Ԫ��Ϊ��");
		    for(k=0;k<a.length;k++)
		      System.out.print(a[k]+"\t");
		    System.out.println();
		    
		    
		    
		  }
		}

