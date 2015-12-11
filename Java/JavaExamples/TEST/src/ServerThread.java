//package SocketCommunication;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
   private  FormManagement frm=null;
   private	 Socket client=null;
   private PrintWriter os=null;
   private BufferedReader is=null;
  
   
   FormManagement  getfrm()
   {
	   return this.frm;
   }
   Socket getclient()
   {return this.client;}
   PrintWriter getos()
   {return this.os;}
   BufferedReader getis()
   {
	   return this.is;
   }
	public ServerThread(Socket client)
	{

		this.client=client;
		try{	this. frm=new FormManagement();
		    this. frm.creatForm("Client["+MultiSocketServer.sum+"]");   //主机界面;
		   
		    
		    this. os = new PrintWriter(this.client.getOutputStream());
		    
			this. is=new BufferedReader(new InputStreamReader(this.client.getInputStream())); 
		}
		catch(IOException e)
		{
			System.out.println("8");
		}
		
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
			
		    
		   
		 //   frm.input.setText(sin.readLine());
while(true)
{		    try {
	Date now= new Date(System.currentTimeMillis());
	int hour=now.getHours();
	int minute=now.getMinutes();
	int second=now.getSeconds();
				frm.output.append(hour+"."+minute+"."+second+":"+"\r\n"+"    "+this.is.readLine()+"\r\n");
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				System.out.println("9");
			}
}		   
		  
		//    System.out.println("聊天结束.");
		
		
	}

	
	
	

}


