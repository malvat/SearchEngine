import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * class that runs the application
 * @author Anim Malvat
 *
 */
public class Runner {
	/**
	 * this is where program starts
	 * @param args	command line arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// default string
		String query = "and";
		String base = "https://www.google.com";
		while(query != "exit") {
			System.out.println("-".repeat(42) + " search engine " + "-".repeat(42));
			System.out.println("-".repeat(100));
			System.out.println("URL form (default = https://www.google.com) & Avoid spelling errors");
			System.out.print("Please enter the base URL : ");
			base = scanner.nextLine();
			base.strip();
			if(base.compareTo("") == 0) {
				base = "https://www.google.com";
			}
			System.out.print("Please enter the query : ");
			query = scanner.nextLine();
			if(query.compareTo("exit")==0) {
				break;
			}
			String[] querySplits = query.split(" ");
			HashMap<String, String> data = getContentFromVarious(base);
			HashMap<String, Float> search = new HashMap<String, Float>();
			float score = 0.0f;
			ArrayList<Float> scores = new ArrayList<Float>();
			for(String key: data.keySet()) {
				scores.clear();
				for(String q: querySplits) {
					score = SearchText.getNormalizedScore(data.get(key), q);
					scores.add(score);
				}
				score = Collections.max(scores);
				if(score != 0.0f && score != -1.0f) {
					search.put(key, score);				
				}
			}
			System.out.println("\n"+ "-".repeat(40) + " search results " + "-".repeat(40));
			if(search.isEmpty()) {
				System.out.println("Sorry, no results could be found");
			} else {
				search = Utils.sortByValue(search);
				for(String key: search.keySet()) {
					System.out.println(key);
					System.out.println("Normalized Score: " + search.get(key));
					System.out.println("-".repeat(100));
				}			
			}		
		}
		System.out.println("Thank you for using our search engine");
		scanner.close();
	}
	
	/**
	 * get content from various
	 * @param url	base URL for searching
	 * @return		returns list of links 
	 */
	public static HashMap<String, String> getContentFromVarious(String url) {
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			Set<String> links = LinkGrabber.findLinks(url);
			for(String link: links) {
				data.put(link, WebContentGrabber.getContent(link));
			}
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
		return data;
	}
}