import java.util.Set;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;

public class Ex13_8_TestHashMap{
	public static void main(String[] args) {
		HashMap<Integer, Ex13_1_Person> hm = new HashMap<Integer, Ex13_1_Person> ();
		hm.put(new Integer(1003),new Ex13_1_Person(1003,"����",15));
		hm.put(new Integer(1008),new Ex13_1_Person(1008,"����",25));
		hm.put(1015,new Ex13_1_Person(1015,"����",73));   //�Զ���װ
		hm.put(1001,new Ex13_1_Person(1001,"����",49));

		System.out.println("----��������Ԫ��----");
		Ex13_1_Person p = (Ex13_1_Person)hm.get(1008);
		System.out.println(p);
		
		System.out.println("----��������\"��\"��Ԫ������----");
		Set names = hm.keySet();
		for(Object o : names){
			System.out.println(o);
		}
		
		System.out.println("----��������\"ֵ\"��Ԫ��ֵ��----");
		Collection values = hm.values();
		for(Object o : values){
			System.out.println(o);
		}
	}
}
