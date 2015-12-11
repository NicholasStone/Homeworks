import java.util.Set;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;

public class Ex13_8_TestHashMap{
	public static void main(String[] args) {
		HashMap<Integer, Ex13_1_Person> hm = new HashMap<Integer, Ex13_1_Person> ();
		hm.put(new Integer(1003),new Ex13_1_Person(1003,"张三",15));
		hm.put(new Integer(1008),new Ex13_1_Person(1008,"李四",25));
		hm.put(1015,new Ex13_1_Person(1015,"王五",73));   //自动封装
		hm.put(1001,new Ex13_1_Person(1001,"赵六",49));

		System.out.println("----检索单个元素----");
		Ex13_1_Person p = (Ex13_1_Person)hm.get(1008);
		System.out.println(p);
		
		System.out.println("----遍历所有\"键\"（元素名）----");
		Set names = hm.keySet();
		for(Object o : names){
			System.out.println(o);
		}
		
		System.out.println("----遍历所有\"值\"（元素值）----");
		Collection values = hm.values();
		for(Object o : values){
			System.out.println(o);
		}
	}
}
