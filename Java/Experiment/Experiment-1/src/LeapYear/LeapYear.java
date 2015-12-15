package LeapYear;

/**
 * Created on 2015/12/15 18:17
 */
public class LeapYear{
	public static void LeapYear(){
		for(int year = 1900, columns = 0; year < 2100; year++){
			if(year % 4 == 0){
				if(year % 100 == 0){
					continue;
				}else{
					System.out.print(year + "\t");
					columns++;
					if(columns % 5 == 0){
						columns = 0;
						System.out.println();
					}
				}
			}
		}
	}
}
