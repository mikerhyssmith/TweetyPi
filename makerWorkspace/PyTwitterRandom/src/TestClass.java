import java.util.Random;

import com.TweetyPi.PyTwitter.TwitterHandler.LocationHandler;
import com.TweetyPi.PyTwitter.TwitterHandler.NewsHandler;
import com.TweetyPi.PyTwitter.TwitterHandler.TrendHandler;


public class TestClass {
	
	public static void main(String[] args) throws Exception{
		String[] citys = {"London", "Manchester", "Toronto", "Cardiff", "Liverpool", "Pittsburgh", "New York", "Belfast", "Leeds","Bristol", "Chicago", "Jacksonville", "Boston","Baltimore", "Atlanta","Miami","Wigan","Coventry","Nottingham", "Edinburgh","Newcastle","Glasgow", "Sheffield","Bolton","York","Canberra","Sydney"};
		Random random = new Random();
		int cityNo = random.nextInt(citys.length);
		String city = citys[cityNo];
		LocationHandler lh = new LocationHandler();
		TrendHandler th = new TrendHandler();
		try {
			th.getTrends(lh.getWOEID(city));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NewsHandler nh = new NewsHandler();
		
		
	}

}
