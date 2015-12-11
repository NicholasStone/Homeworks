import java.util.*;

public class Ex13_10_CalendarDemo {
	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance();
		// 下面打印当前时间
		System.out.println(c1.get(c1.YEAR) + "年" + (c1.get(c1.MONTH) + 1) + "月"
				+ c1.get(c1.DAY_OF_MONTH) + "日" + c1.get(c1.HOUR) + ":"
				+ c1.get(c1.MINUTE) + ":" + c1.get(c1.SECOND));
		// 增加天数为230
		c1.add(c1.DAY_OF_YEAR, 230);

		// 下面打印的是230天后的时间
		System.out.println(c1.get(c1.YEAR) + "年" + (c1.get(c1.MONTH) + 1) + "月"
				+ c1.get(c1.DAY_OF_MONTH) + "日" + c1.get(c1.HOUR) + ":"
				+ c1.get(c1.MINUTE) + ":" + c1.get(c1.SECOND));
	}
}

