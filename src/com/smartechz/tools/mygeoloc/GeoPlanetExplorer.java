package com.smartechz.tools.mygeoloc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.smartechz.core.stream.StreamReader;
import com.smartechz.core.webserver.HTTPRequest;

public class GeoPlanetExplorer {
	public static String getWOEID(String start) throws MalformedURLException,
			IOException {
		start = start.replaceAll("\\s", "%20").replaceAll(",", "%2C");
		String url = "http://isithackday.com/geoplanet-explorer/index.php?start="
				+ start;

		String regwoeid = "woeid=([\\da-zA-Z]*)";
		Pattern woeidPtrn = Pattern.compile(regwoeid);
		String res = null, line;

		StreamReader in = HTTPRequest.getStreamReader(url);
		while (in.hasNextLine()) {
			line = in.nextLine();
			Matcher woeidMatchr = woeidPtrn.matcher(line);
			if (woeidMatchr.find()) {
				res = woeidMatchr.group(1);
				break;
			}
		}
		in.close();
		return res;
	}
}
