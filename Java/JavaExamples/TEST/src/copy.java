import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class copy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2)
		       System.out.println("�����������ļ�������");
		     else
		     {
		    	 String infile  = args[0];
		    	 String outfile = args[1];
		    	 try{
		    		 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(infile),"GBK"));
		    		 String lineBuffer;
		    		 StringBuffer words = new StringBuffer();
		    		 while(null != (lineBuffer = br.readLine())){
		    			 String[] word = lineBuffer.split("\r\n");
		    			 for(int i=0;i<word.length;i++)
		    				 if(word[i].trim().length()>0)
		    					 words.append(word[i]+"\r\n");
		    		}
		    		 FileOutputStream fos = new FileOutputStream(outfile);
		    		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"GBK"));
		    		 bw.write(words.toString());
		    		 bw.close();
		    	   } catch (Exception e){
		    		   System.out.println("�ļ����������󣡣���");
		    		   System.out.println("�����ļ�����"+infile);
		    		   System.out.println("�����ļ�����"+outfile);
		    		   System.out.println("������Ϣ��"+e.getMessage());
		    		   
		    	   }
	}

	}

}

