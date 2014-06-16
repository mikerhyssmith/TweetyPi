package com.TweetyPi.PyTwitter.TwitterHandler;
import java.io.BufferedReader;
import java.io.FileReader;

public class TweetyPi {
	public static TrendHandler th;
	public static LocationHandler lh;

	public TweetyPi() throws Exception {
		String[] twitterCred = new String[4];
		try {
			
			FileReader twitterFile = new FileReader("C:\\Users\\mike\\Documents\\TwitterAuth\\TwitterAuth.txt");
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
			System.out.println("Error while reading file line by line:" + e.getMessage());
		}

		lh = new LocationHandler();
		th = new TrendHandler(twitterCred[0],twitterCred[1],twitterCred[2],twitterCred[3]);
		
		NewsHandler nh = new NewsHandler();

	}

}
