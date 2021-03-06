package com.TweetyPi.PyTwitter.TwitterHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;


public class NewsHandler {

	public String getHeadline(String search)  {
		String headline = "No headline found";
		String searchTerm = search.replaceAll("\\s","%20");
		URL url = null;
		try {
			url = new URL(
					"https://ajax.googleapis.com/ajax/services/search/news?"
							+ "v=1.0&q=" + searchTerm + "&userip=INSERT-USER-IP");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Connection Unavailable");
		}
		URLConnection connection = null;
		try {
			connection = url.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Google Not Reachable");
		}
		// connection.addRequestProperty("Referer", /* Enter the URL of your
		// site here */);

		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Cannot Get Headline");
		}
		try {
			while ((line = reader.readLine()) != null) {
				if (line.contains("titleNoFormatting")) {
					builder.append(line);
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("No Headlines");
		}
		try {
			JSONObject json = new JSONObject(builder.toString());
			//System.out.println(json.toString());
			// System.out.println(json.get("responseData"));
			String result = json.toString();
			result.toLowerCase();
			if(result.contains("titleNoFormatting")){
				int position = result.indexOf("titleNoFormatting");
				//System.out.println(position);
				int finals = position + 200;
				String end = result.substring(position, finals);
				//System.out.println(end);
				int endPos = end.indexOf(",");
				int start =  20;
				if(end.charAt(endPos +1) == '"'){
					headline = end.substring(start, endPos-1);
					headline = headline.replaceAll("&#39;"," ");
					
				}else{
					String second = end.substring(endPos);
					int nextComma = second.indexOf(",");
					try{
					headline = end.substring(start, nextComma-1);
					headline = headline.replaceAll("&#39;"," ");
					}catch(StringIndexOutOfBoundsException e){
						System.out.println("Wrong Headline Format/ No Headline");
					}
					
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Headline Unavailable");
		}
		return headline;
	}
	
	public static void main(String[] args){
		NewsHandler nh = new NewsHandler();
		
			System.out.println(nh.getHeadline("Zuma"));
		
			// TODO Auto-generated catch block
		
	}

}
