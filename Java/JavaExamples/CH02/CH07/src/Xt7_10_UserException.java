//Xt7_10_User_UserException.java
import java.io.*;
class MyException extends Exception{
	public String toString(){
		return "MyException";
	}
}
public class Xt7_10_UserException {
	static void action() throws MyException{
		String s=new String();
		if(s.equals(""))
			throw new MyException();
	}
	public static void main(String[] args) {
		try{
			action();
		}catch(MyException e){
			System.out.println(e);
		}
	}
}
