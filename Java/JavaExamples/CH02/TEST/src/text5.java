import java.io.*;
public class text5 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int a[]=new int[100];
		int i;
		int c;
		int n,s=0;
         for( n=2;n<3;n++)
        	 for(i=2;i<=((n/2)+1);i++){
        		 if(n%i==0)
        			 break;
        	if(i>(n/2)){
        		a[s]=n;
        		s++;}
        	
//       FileOutputStream os=new FileOutputStream("D:\\Users\\PC\\Desktop\\mao.txt");
//       OutputStreamWriter or=new OutputStreamWriter(os); 	
//       
//       while(a[s]!=0){
//    	   or.write(a[s]);
//       s++;}
//       or.close();
//       os.close();

       FileInputStream is;
       InputStreamReader ir;
       is=new FileInputStream("D:\\mao.txt");
       ir=new InputStreamReader(is);
       while((c=ir.read())!=-1)
    	   System.out.print((char)c);
        	
	}

}
	
	
	
}