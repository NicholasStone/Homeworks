//package SocketCommunication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Date;
public class MultiSocketClient implements ActionListener {
static PrintWriter os=null;
static BufferedReader is=null;
static BufferedReader sin=null;
static FormManagement frm=null;
static Socket server=null;
	public static void main(String s[])
	{
	    server=null;
		
		try{
	        
			server = new Socket ("127.0.0.1",4444);
			 frm=new FormManagement();
		  frm.creatForm("Client["+MultiSocketServer.sum+"]"+"server");   //客户机界面
	        
		  MultiSocketClient sendhandler=new MultiSocketClient();
	         frm.send.addActionListener(sendhandler);
	         frm.input.addKeyListener(new KeyAdapter(){
	         	public void keyPressed(KeyEvent e){
	        		
	        		if(e.getKeyCode()==KeyEvent.VK_ENTER)
	        			if(frm.input.getText()!=null&&! frm.input.getText().equals("quit"))
	        		    {
	        		    	os.println( frm.input.getText());
	        		    	os.flush();
	        		    	frm.input.setText("");
	        		  //  	frm.input.setText(sin.readLine());
	        		    } 
	        		else{
	        		    os.close();
	        		    try {
	        				is.close();
	        			} catch (IOException e2) {
	        				// TODO 自动生成的 catch 块
	        				System.out.println("4");
	        			}try {
	        				server.close();
	        			} catch (IOException e1) {
	        				// TODO 自动生成的 catch 块
	        				System.out.println("3");
	        			}
	        		    System.out.println("聊天结束.");
	        		    System.exit(0);
	        		}
	    }
	        });
		    
			sin = new BufferedReader (new InputStreamReader (System.in));
			 os =new PrintWriter(server.getOutputStream());
			 is = new BufferedReader(new InputStreamReader (server.getInputStream()));
		//    frm.input.setText(sin.readLine()) ;
		 
	while(true){	   try {
		Date now= new Date(System.currentTimeMillis());
		int hour=now.getHours();
		int minute=now.getMinutes();
		int second=now.getSeconds();
		
					frm.output.append(hour+"."+minute+"."+second+":"+"\r\n"+"    "+is.readLine()+"\r\n");
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					System.out.println("10");
				}
	}
		   
		}
		catch(UnknownHostException e)
		{
			System.out.println("2");
			
		}
		catch(IOException e)
		{
			System.out.println("1");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		if(frm.input.getText()!=null&&! frm.input.getText().equals("quit"))
		    {
		    	os.println( frm.input.getText());
		    	os.flush();
		    	frm.input.setText("");
		  //  	frm.input.setText(sin.readLine());
		    } 
		else{
		    os.close();
		    try {
				is.close();
			} catch (IOException e2) {
				// TODO 自动生成的 catch 块
				System.out.println("4");
			}try {
				server.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				System.out.println("3");
			}
		    System.out.println("聊天结束.");
		    System.exit(0);
		}
	}
}
