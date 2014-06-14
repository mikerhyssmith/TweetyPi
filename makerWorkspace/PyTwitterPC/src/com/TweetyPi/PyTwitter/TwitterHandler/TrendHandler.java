package com.TweetyPi.PyTwitter.TwitterHandler;

import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class TrendHandler {

	public Trend[] getTrends(int locationID) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("DYV9WP2vbAVT8ydS6mSr9w")
		  .setOAuthConsumerSecret("K2QkNzscJd5Q60XE0rzmPkK13VKgO10BeZnAe2H8gs")
		  .setOAuthAccessToken("20921265-v1LmZfViPQPSxyHRtp0U5cd7R8bTZwqexbje5N2I0")
		  .setOAuthAccessTokenSecret("vzeEbwyC9YtQNomUmwBNfmTiBWjMdze52pAJxvG6VEGNv");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		Trend[] trendArray = null;
		try {
			ArrayList<String> trendList = new ArrayList<String>();
			Trends currentTrends = twitter.getPlaceTrends(locationID);
			trendArray = currentTrends.getTrends();
			for (Trend t : trendArray) {
				
				 trendList.add(t.getName());
				 System.out.println(t.getName());
				 if(t.getName().charAt(0) == '#'){
						String removeHash = t.getName().substring(1);
						GoogleSpeech GS = new GoogleSpeech();
						GS.textToSpeech(removeHash);
						NewsHandler nh = new NewsHandler();
						
						try {
							String result = nh.getHeadline(removeHash);
							System.out.println(result);
							GS.textToSpeech(result);
							Thread.sleep(8000);
							System.out.println(result);
						} catch (Exception e) {
							
							e.printStackTrace();
						}
						
					}else{
					
						String output = t.getName();
				 		GoogleSpeech GS = new GoogleSpeech();
				 		GS.textToSpeech(output);
				 		NewsHandler nh = new NewsHandler();
						
						try {
							String result = nh.getHeadline(t.getName());
							System.out.println(result);
							GS.textToSpeech(result);
							Thread.sleep(8000);
							System.out.println(result);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
			}
			//for(int i = 0; i < trendList.size(); i++){
				//System.out.println(trendList.get(i));
			//}

		} catch (TwitterException e) {
			System.out.println("Twitter Error");
			e.printStackTrace();
		} catch (JavaLayerException e1) {
			System.out.println("Google Speech Error");
		}
		return trendArray;
	}
}
