package MyThread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nicholas on 15-12-29.
 */
public class MyThread extends Thread{
    private String threadName;
    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    public MyThread(String name){
        threadName = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                System.out.println(threadName + "\t" + sdf.format(date));
                this.sleep( 500 );
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String args[]){
        new MyThread("Thread1").start();
        new MyThread("Thread2").start();
        new MyThread("Thread3").start();
    }
}
