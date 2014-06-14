import java.io.BufferedReader;
import java.io.FileReader;

import com.TweetyPi.PyTwitter.TwitterHandler.LocationHandler;
import com.TweetyPi.PyTwitter.TwitterHandler.NewsHandler;
import com.TweetyPi.PyTwitter.TwitterHandler.TrendHandler;

public class TestClass {

	public static void main(String[] args) throws Exception {
		String[] twitterCred = new String[4];
		try {
			
			FileReader twitterFile = new FileReader(
					"C:\\Users\\mike\\Documents\\TwitterAuth\\TwitterAuth.txt");
			BufferedReader bufferReader = new BufferedReader(twitterFile);
			String line;
			int counter = 0;

			// Read file line by line and print on the console
			while ((line = bufferReader.readLine()) != null) {
				twitterCred[counter] = line;
				counter++;
			}
			// Close the buffer reader
			bufferReader.close();
		} catch (Exception e) {
			System.out.println("Error while reading file line by line:"
					+ e.getMessage());
		}

		LocationHandler lh = new LocationHandler();
		TrendHandler th = new TrendHandler(twitterCred[0],twitterCred[1],twitterCred[2],twitterCred[3]);
		try {
			th.getTrends(lh.getWOEID(lh.getLocation()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NewsHandler nh = new NewsHandler();

	}

}

