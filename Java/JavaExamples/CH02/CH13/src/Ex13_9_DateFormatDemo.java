import java.text.*;
import java.util.Date;

public class Ex13_9_DateFormatDemo {
	public static void main(String[] args) {
		SimpleDateFormat sp1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sp2 = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
		try {
			Date d = sp1.parse("2014-3-6 18:30:38");
			System.out.println(sp2.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

