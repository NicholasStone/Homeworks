import java.util.*;

public class Ex13_10_CalendarDemo {
	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance();
		// �����ӡ��ǰʱ��
		System.out.println(c1.get(c1.YEAR) + "��" + (c1.get(c1.MONTH) + 1) + "��"
				+ c1.get(c1.DAY_OF_MONTH) + "��" + c1.get(c1.HOUR) + ":"
				+ c1.get(c1.MINUTE) + ":" + c1.get(c1.SECOND));
		// ��������Ϊ230
		c1.add(c1.DAY_OF_YEAR, 230);

		// �����ӡ����230����ʱ��
		System.out.println(c1.get(c1.YEAR) + "��" + (c1.get(c1.MONTH) + 1) + "��"
				+ c1.get(c1.DAY_OF_MONTH) + "��" + c1.get(c1.HOUR) + ":"
				+ c1.get(c1.MINUTE) + ":" + c1.get(c1.SECOND));
	}
}

