import java.util.Date;
import java.util.Stack;

public class Ex13_6_TestStack{
	public static void main(String[] args) {
		Stack<String> s = new Stack<String> ();
		s.push("sun");
		s.push("tree");
		s.push("flower");  
		s.push("sky");
		
		System.out.println("��ջǰ:size=" + s.size());
		System.out.println(s.pop());
		System.out.println("��ջ��:size=" + s.size());
		System.out.println(s.peek());
		System.out.println("peek������:size=" + s.size());
		while(!s.isEmpty())
			System.out.println(s.pop());
	}
}
