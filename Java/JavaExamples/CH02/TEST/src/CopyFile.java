import java.io.*;
public class CopyFile {
	public static void main(String[] args) throws Exception{
		if(args.length != 2){
			System.out.println("�����������ļ�����");
		}else{
			String infile = args[0];
			String outfile = args[1];
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(infile), "GBK"));
		String lineBuffer;
		lineBuffer = br.readLine();
		StringBuffer words = new StringBuffer();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile),"GBK"));
	    bw.write(words.toString());
	    bw.close();
	    
	    System.out.println("�����ļ�����"+infile);
	    System.out.println("����ļ�����"+outfile);
       }
		
	}

}
