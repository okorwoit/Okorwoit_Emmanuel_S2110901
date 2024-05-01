package org.me.gcu.okorwoit_emmanuel_s2110901;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Weather implements Serializable {
    private String dayOfWeek;
    private String weatherClassification;
    private String minTemp;
    private String maxTemp;
    private String windDirection;
    private String windSpeed;
    private String visibility;
    private String pressure;
    private String humidity;
    private String uvRisk;
    private String pollution;
    private String sunrise;
    private String sunset;
    private String date;
    private String title;

    public Weather() {
        // Default constructor required for calls to DataSnapshot.getValue(Weather.class)
    }

    // Constructor
    public Weather(String dayOfWeek, String weatherClassification, String minTemp, String maxTemp, String windDirection, String windSpeed, String visibility, String pressure, String humidity, String uvRisk, String pollution, String sunrise, String sunset, String date, String title, String description) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.visibility = visibility;
        this.pressure = pressure;
        this.humidity = humidity;
        this.uvRisk = uvRisk;
        this.pollution = pollution;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.date = date;
        this.title = title;
    }

    // Getters
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public String getWeatherClassification() {
        return weatherClassification;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getDate() {
        return date;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getUvRisk() {
        return uvRisk;
    }

    public String getPollution() {
        return pollution;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    // Setters
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setWeatherClassification(String weatherClassification) {
        this.weatherClassification = weatherClassification;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setUvRisk(String uvRisk) {
        this.uvRisk = uvRisk;
    }

    public void setPollution(String pollution) {
        this.pollution = pollution;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public void setAttribute(String key, String value) {
        switch (key) {
            case "Day of the week":
                this.dayOfWeek = value;
                break;
            case "Weather Classification":
                this.weatherClassification = value;
                break;
            case "Minimum Temperature":
                this.minTemp = value;
                break;
            case "Maximum Temperature":
                this.maxTemp = value;
                break;
            case "Wind Direction":
                this.windDirection = value;
                break;
            case "Wind Speed":
                this.windSpeed = value;
                break;
            case "Visibility":
                this.visibility = value;
                break;
            case "Pressure":
                this.pressure = value;
                break;
            case "Humidity":
                this.humidity = value;
                break;
            case "UV Risk":
                this.uvRisk = value;
                break;
            case "Pollution":
                this.pollution = value;
                break;
            case "Sunrise":
                this.sunrise = value;
                break;
            case "Sunset":
                this.sunset = value;
                break;
            case "Title":
                this.title = value;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "Weather{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", weatherClassification='" + weatherClassification + '\'' +
                ", minTemp='" + minTemp + '\'' +
                ", maxTemp='" + maxTemp + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", visibility='" + visibility + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", uvRisk='" + uvRisk + '\'' +
                ", pollution='" + pollution + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    // Getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}

