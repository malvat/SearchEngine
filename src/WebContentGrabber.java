import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;

/**
 * class that helps us grab the web content
 * @author Anim Malvat
 *
 */
public class WebContentGrabber {
	/**
	 * tests the content grabber
	 */
	public static void test() {
		String result = getContent("http://www.uwindsor.ca");
		System.out.println(result);
	}
	
	/**
	 * gets content of the web site from URL in plain text
	 * @param url	URL address of the web
	 * @return		plain text: content of the web site
	 */
	public static String getContent(String url) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			String line;
			URL urlObj = new URL(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlObj.openStream()));
			while((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
			}
		} catch (MalformedURLException e) {
			//System.out.println("URL is not in proper form");
		} catch (IOException e) {
			//System.out.println("There was problem reading from the url");
		} 
		String plainText = Jsoup.parse(stringBuilder.toString()).text();
		return plainText;
	}
}
