package com.TweetyPi.PyTwitter.TwitterHandler;

import java.io.IOException;
import java.util.ArrayList;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.TweetyPi.Link.Connector;

public class TrendHandler {

	public Trend[] getTrends(int locationID) throws Exception{
		
		//Twitter twitter = TwitterFactory.getSingleton();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		Connector connector = new Connector();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("DYV9WP2vbAVT8ydS6mSr9w")
		  .setOAuthConsumerSecret("K2QkNzscJd5Q60XE0rzmPkK13VKgO10BeZnAe2H8gs")
		  .setOAuthAccessToken("20921265-v1LmZfViPQPSxyHRtp0U5cd7R8bTZwqexbje5N2I0")
		  .setOAuthAccessTokenSecret("vzeEbwyC9YtQNomUmwBNfmTiBWjMdze52pAJxvG6VEGNv");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		Trend[] trendArray = null;
		try {
			ArrayList trendList = new ArrayList();
			Trends currentTrends = twitter.getPlaceTrends(36758);
			trendArray = currentTrends.getTrends();
			for (Trend t : trendArray) {
				
				 trendList.add(t.getName());
				 connector.writeToScreen(t.getName());
				 if(t.getName().charAt(0) == '#'){
						String removeHash = t.getName().substring(1);
						GoogleSpeech GS = new GoogleSpeech();
						GS.textToSpeech(removeHash);
						NewsHandler nh = new NewsHandler();
						
						try {
							Connector c = new Connector();
							String result = nh.getHeadline(removeHash);
							c.writeToScreen(result);
							GS.textToSpeech(result);
							Thread.sleep(8000);
							System.out.println(result);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else{
					
						String output = t.getName();
				 		GoogleSpeech GS = new GoogleSpeech();
				 		GS.textToSpeech(output);
				 		NewsHandler nh = new NewsHandler();
						
						try {
							Connector c = new Connector();
							String result = nh.getHeadline(t.getName());
							c.writeToScreen(result);
							GS.textToSpeech(result);
							Thread.sleep(8000);
							System.out.println(result);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				
			}
			for(int i = 0; i < trendList.size(); i++){
				System.out.println(trendList.get(i));
			}

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trendArray;
	}
}