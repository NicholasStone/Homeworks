package PaintingStars;

/**
 * Created on 2015/12/15 14:51
 */
public class PaintingStars{
	public static void PaintingStars(){
		int blanks = 3, stars = 1;
		for(int row = 0; row < 7; row++){
			for(int j = blanks; j > 0; j--){
				System.out.print("　");
			}
			for(int j = stars; j > 0; j--){
				System.out.print("☆");
			}
			System.out.println();
			if(row < 3){
				blanks --;
				stars += 2;
			} else {
				stars -= 2;
				blanks ++;
			}
		}
	}
}
