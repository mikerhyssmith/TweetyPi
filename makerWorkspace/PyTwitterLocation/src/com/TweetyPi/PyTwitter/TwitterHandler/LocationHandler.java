package com.TweetyPi.PyTwitter.TwitterHandler;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.TweetyPi.Link.Connector;
import com.smartechz.tools.mygeoloc.GeoPlanetExplorer;
import com.smartechz.tools.mygeoloc.Geobytes;

public class LocationHandler {

	public LocationHandler() {

	}

	public String getLocation() throws IOException, IllegalArgumentException,IllegalAccessException, ParserConfigurationException, SAXException {
		// Geobytes
		//System.out.println("Continent : " + Geobytes.get(Geobytes.MapReference));
		//System.out.println("Country   : " + Geobytes.get(Geobytes.Country));
		//System.out.println("State     : " + Geobytes.get(Geobytes.Region));
		//System.out.println("City      : " + Geobytes.get(Geobytes.City));

		//System.out.println("\nMyLocation = " + Geobytes.getMyLocation());
		Connector connector = new Connector();
		try {
			connector.writeToScreen("City: " + Geobytes.get(Geobytes.City));
			String output = "You are located in " + Geobytes.get(Geobytes.City);
			GoogleSpeech GS = new GoogleSpeech();
			GS.textToSpeech(output);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// GeoPlanetExplorer
		

		return Geobytes.get(Geobytes.City);

	}
	
	public int getWOEID(String location) throws MalformedURLException, IllegalArgumentException, IllegalAccessException, IOException{
		String MyWOEID = GeoPlanetExplorer.getWOEID(Geobytes.get(Geobytes.City));
		//System.out.println("\nMyLocation's WOEID = " + MyWOEID);
		
		int woeid = Integer.parseInt(MyWOEID);
		return woeid;
		
		
	}
	}

