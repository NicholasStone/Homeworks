package CountingWords;

/**
 * Created on 2015/12/16 12:27
 */
public class CountingWords{
	public static int CountingWords(String sentence){
		int result = 0;

		for(int i = 0; i<sentence.length(); i++){
			if(sentence.charAt(i) == ' ' && sentence.charAt(i+1) != ' '){
				result ++;
			}
		}

		return ++result;
	}
}
