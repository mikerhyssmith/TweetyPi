import com.TweetyPi.PyTwitter.TwitterHandler.LocationHandler;
import com.TweetyPi.PyTwitter.TwitterHandler.NewsHandler;
import com.TweetyPi.PyTwitter.TwitterHandler.TrendHandler;


public class TestClass {
	
	public static void main(String[] args) throws Exception{
		
		LocationHandler lh = new LocationHandler();
		TrendHandler th = new TrendHandler();
		try {
			th.getTrends(lh.getWOEID(lh.getLocation()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NewsHandler nh = new NewsHandler();
		
		
	}

}
