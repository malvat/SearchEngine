import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Class that helps find links from any URL
 * @author Anim Malvat
 *
 */
public class LinkGrabber {
	/**
	 * to test the code using google as base URL
	 */
	public static void test() {
		try {
			for(String link: findLinks("https://www.google.com")) {
				System.out.println(link);
			}
		} catch(Exception e) {
			System.out.println( "there was some error");
		}
	}
	
	/**
	 * finds links through the URL
	 * @param url	base URL of web	
	 * @return		set of links that can be found
	 * @throws IOException	input output exception
	 */
	public static Set<String> findLinks(String url) throws IOException {
		//using sets to eliminate repeating
		Set<String> links = new HashSet<>();
		//setting up the documents to receive document that is HTML page in our case
		try {
			Document doc = Jsoup.connect(url)
				.data("query", "Java")
				.userAgent("Mozilla")
				.cookie("auth", "token")
				.timeout(3000)
				.get();
			//select anchor tag to find various links from one web page
			Elements elements = doc.select("a[href]");
			for(Element element: elements) {
				links.add(element.attr("href"));
			}
		} catch(Exception e) {
			System.out.println("There was some problem with URL");
		}
		return links;
	}
}
