//管道流PipedInputStream和PipedOutputStream应用。
import java.io.*;
public class Xt9_9_PipeDemo {
	public static void main(String args[])throws Exception{
		PipedInputStream pis;
		PipedOutputStream pos;
		byte b;
		pis=new PipedInputStream();
		pos=new PipedOutputStream(pis); 
		pos.write('a');
		pos.write('b'); 
		b=(byte)pis.read();
		System.out.println(b);
		b=(byte)pis.read();  
		System.out.println(b);
	}
}

