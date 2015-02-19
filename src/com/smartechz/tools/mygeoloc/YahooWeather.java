package com.smartechz.tools.mygeoloc;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.smartechz.core.webserver.HTTPRequest;

public class YahooWeather {
	private Document xmlDoc = null;
	private String WOEID = null;

	public YahooWeather(String WOEID) throws MalformedURLException,
			IOException, ParserConfigurationException, SAXException {
		setWOEID(WOEID);
	}

	public void setWOEID(String WOEID) throws MalformedURLException,
			IOException, ParserConfigurationException, SAXException {
		this.WOEID = WOEID;
		refresh();
	}

	public void refresh() throws MalformedURLException, IOException,
			ParserConfigurationException, SAXException {
		xmlDoc = getFeed(WOEID);
	}

	public static Document getFeed(String WOEID) throws MalformedURLException,
			IOException, ParserConfigurationException, SAXException {
		String url = "http://weather.yahooapis.com/forecastrss?u=c&w=" + WOEID;
		return HTTPRequest.getXMLDoc(url);
	}

	private Element getElement(Document doc, int index, String root,
			String... tags) {
		Node node;
		Element elem = null;

		NodeList elmes = doc.getElementsByTagName(root);
		if (tags != null && tags.length > 0) {
			for (int i = 0; i < tags.length; i++) {
				node = elmes.item(0);
				if (node != null)
					elem = (Element) node;

				if (elem == null)
					return null;

				elmes = elem.getElementsByTagName(tags[i]);

			}
		}
		node = elmes.item(index);
		if (node != null)
			elem = (Element) node;

		return elem;
	}

	public String getTomorrowsCode() {
		return getElement(xmlDoc, 1, "yweather:forecast").getAttribute("code");
	}

	public String getTomorrowsText() {
		return getElement(xmlDoc, 1, "yweather:forecast").getAttribute("text");
	}

	public String getTomorrowsLow() {
		return getElement(xmlDoc, 1, "yweather:forecast").getAttribute("low");
	}

	public String getTomorrowsHigh() {
		return getElement(xmlDoc, 1, "yweather:forecast").getAttribute("high");
	}

	public String getTodaysCode() {
		return getElement(xmlDoc, 0, "yweather:forecast").getAttribute("code");
	}

	public String getTodaysText() {
		return getElement(xmlDoc, 0, "yweather:forecast").getAttribute("text");
	}

	public String getTodaysLow() {
		return getElement(xmlDoc, 0, "yweather:forecast").getAttribute("low");
	}

	public String getTodaysHigh() {
		return getElement(xmlDoc, 0, "yweather:forecast").getAttribute("high");
	}

	public String getTemprature() {
		return getElement(xmlDoc, 0, "yweather:condition").getAttribute("temp");
	}

	public String getCode() {
		return getElement(xmlDoc, 0, "yweather:condition").getAttribute("code");
	}

	public String getText() {
		return getElement(xmlDoc, 0, "yweather:condition").getAttribute("text");
	}

	public String getSunset() {
		return getElement(xmlDoc, 0, "yweather:astronomy").getAttribute(
				"sunset");
	}

	public String getSunrise() {
		return getElement(xmlDoc, 0, "yweather:astronomy").getAttribute(
				"sunrise");
	}

	public String getRising() {
		return getElement(xmlDoc, 0, "yweather:atmosphere").getAttribute(
				"rising");
	}

	public String getPressure() {
		return getElement(xmlDoc, 0, "yweather:atmosphere").getAttribute(
				"pressure");
	}

	public String getVisibility() {
		return getElement(xmlDoc, 0, "yweather:atmosphere").getAttribute(
				"visibility");
	}

	public String getHumidity() {
		return getElement(xmlDoc, 0, "yweather:atmosphere").getAttribute(
				"humidity");
	}

	public String getSpeed() {
		return getElement(xmlDoc, 0, "yweather:wind").getAttribute("speed");
	}

	public String getDirection() {
		return getElement(xmlDoc, 0, "yweather:wind").getAttribute("direction");
	}

	public String getChill() {
		return getElement(xmlDoc, 0, "yweather:wind").getAttribute("chill");
	}

	public String getSpeedUnit() {
		return getElement(xmlDoc, 0, "yweather:units").getAttribute("speed");
	}

	public String getPressureUnit() {
		return getElement(xmlDoc, 0, "yweather:units").getAttribute("pressure");
	}

	public String getDistanceUnit() {
		return getElement(xmlDoc, 0, "yweather:units").getAttribute("distance");
	}

	public String getTemperatureUnit() {
		return getElement(xmlDoc, 0, "yweather:units").getAttribute(
				"temperature");
	}

	public String getCountry() {
		return getElement(xmlDoc, 0, "yweather:location").getAttribute(
				"country");
	}

	public String getRegion() {
		return getElement(xmlDoc, 0, "yweather:location")
				.getAttribute("region");
	}

	public String getCity() {
		return getElement(xmlDoc, 0, "yweather:location").getAttribute("city");
	}

}
