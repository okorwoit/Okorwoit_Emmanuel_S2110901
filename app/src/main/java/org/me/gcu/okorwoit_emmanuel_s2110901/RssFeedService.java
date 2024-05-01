package org.me.gcu.okorwoit_emmanuel_s2110901;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RssFeedService {
    public List<Weather> fetchWeatherData(String locationId) {
        List<Weather> weatherList = new ArrayList<>();
        HttpURLConnection connection = null;
        try {
            URL url = new URL(locationId);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();

            Log.d("RssFeedService", "Fetched weather data");
            weatherList = parseRssFeed(inputStream);
            //Log the returned list
            for (Weather weather : weatherList) {
                Log.d("RssFeedService", weather.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return weatherList;
    }

    private List<Weather> parseRssFeed(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser parser = Xml.newPullParser();
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(inputStream, null);
        List<Weather> weatherList = new ArrayList<>();
        int eventType = parser.getEventType();
        Weather currentWeather = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name;
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("item")) {
                        currentWeather = new Weather();
                    } else if (currentWeather != null) {
                        if (name.equals("title")) {
                            String title = parser.nextText();
                            String[] titleParts = title.split(", ");
                            for (String part : titleParts) {
                                String[] keyValue = part.split(": ");
                                if (keyValue.length == 2) {
                                    currentWeather.setAttribute(keyValue[0], keyValue[1]);
                                }
                            }
                            //Parse day of week and weather classification
                            String[] dayOfWeekAndWeather = titleParts[0].split(": ");
                            if (dayOfWeekAndWeather.length == 2) {
                                currentWeather.setDayOfWeek(dayOfWeekAndWeather[0]);
                                currentWeather.setWeatherClassification(dayOfWeekAndWeather[1]);
                            }

                        } else if (name.equals("description")) {
                            String description = parser.nextText();
                            String[] descriptionParts = description.split(", ");
                            for (String part : descriptionParts) {
                                String[] keyValue = part.split(": ");
                                if (keyValue.length == 2) {
                                    currentWeather.setAttribute(keyValue[0], keyValue[1]);
                                }
                            }
                        } else if (name.equals("dc:date")) {
                            currentWeather.setDate(parser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("item") && currentWeather != null) {
                        weatherList.add(currentWeather);
                    }
            }
            eventType = parser.next();
        }
        return weatherList;
    }
}