import java.util.ArrayList;
/**
 * searches text through the content 
 * @author Anim Malvat
 *
 */
public class SearchText {
	/**
	 * get amount of words form the content
	 * @param content	content of a web site
	 * @param word		word to search
	 * @return			number of words that matched
	 */
	public static int getAmountOfWords(String content, String word) {
		KMP_String_Matching kmp = new KMP_String_Matching();
		ArrayList<Integer> words = kmp.KMPSearch(word, content);
		return words.size();
	}
	
	/**
	 * normalizing the search results
	 * @param content	content of a web
	 * @param word		word to search
	 * @return			normalized score
	 */
	public static float getNormalizedScore(String content, String word) {
		if(content.length()!=0) {			
			return (float) getAmountOfWords(content, word)/ (float) content.length();
		} else {
			return -1.0f;
		}
	}
}
