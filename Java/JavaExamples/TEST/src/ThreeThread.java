//package ThreeThread;
import java.util.*;
public class ThreeThread extends Thread{
        private String name=null;
        private Date day=null;
        ThreeThread(String s)
        {
        	this.name=s;
        	this.day=new Date(System.currentTimeMillis());
        }
        public void run()
        {
        	while (true)
        	{
        		try
        		{
        			Date now=new Date(System.currentTimeMillis());
       
        			int nowhour=now.getHours();
                    int nowminute=now.getMinutes();
                    int nowsecond=now.getSeconds();
                    nowhour=nowhour-this.day.getHours();
                    nowminute=nowminute-this.day.getMinutes();
                    nowsecond=nowsecond-this.day.getSeconds();
                    if(nowsecond<0)
                    {
                    	nowsecond=nowsecond+60;
                    	nowminute--;
                    }
                    if(nowminute<0)
                    {
                    	nowminute=nowminute+60;
                    	nowhour--;
                    }
        			 System.out.println(name+": "+"hour: "+nowhour+" minute: "+nowminute+" second:" +nowsecond);
        			   Thread.sleep(1000);
        		}
        		catch(Exception e)
        		{
        			System.out.println(name+"线程出错");
        		}
        	}
        }
        
 
        public static void main(String []j)
        {
        	Thread main = Thread.currentThread();
        	main.setPriority(1);
        	ThreeThread thread1=new ThreeThread("thread1");thread1.start();
        	
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
       	ThreeThread thread2=new ThreeThread("thread2");thread2.start();
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        	ThreeThread thread3=new ThreeThread("thread3");thread3.start();   
        }
}
