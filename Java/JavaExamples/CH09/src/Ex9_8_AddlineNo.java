import java.io.*;
public class Ex9_8_AddlineNo {
	public static void main(String[] args) {
		String str=null;
		try{
			FileReader file=new FileReader(".\\src\\Ex9_8_AddlineNo.java");
			LineNumberReader in=new LineNumberReader(file);
			while((str=in.readLine())!=null)
				System.out.println(in.getLineNumber()+":"+str);
			in.close();
		}catch(IOException e){
			System.out.println("文件打不开或读文件错误！");
		}
	}
}
