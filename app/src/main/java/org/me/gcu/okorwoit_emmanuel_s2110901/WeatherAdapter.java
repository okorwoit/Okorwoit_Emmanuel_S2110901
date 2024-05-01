package org.me.gcu.okorwoit_emmanuel_s2110901;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<Weather> weatherList;

    public WeatherAdapter(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        Weather weather = weatherList.get(position);
        // Set the weather icon based on the weather conditions
//        holder.weatherIcon.setImageResource(getWeatherIcon(weather));

        holder.date.setText(weather.getDate());
        holder.minTemp.setText(weather.getMinTemp());
        holder.maxTemp.setText(weather.getMaxTemp());
        holder.windDirection.setText(weather.getWindDirection());
        holder.windSpeed.setText(weather.getWindSpeed());
        holder.visibility.setText( weather.getVisibility());
        holder.pressure.setText( weather.getPressure());
        holder.humidity.setText( weather.getHumidity());
        holder.uvRisk.setText(weather.getUvRisk());
        holder.pollution.setText( weather.getPollution());
        holder.sunrise.setText( weather.getSunrise());
        holder.sunset.setText(weather.getSunset());
        holder.dayOfWeek.setText(weather.getDayOfWeek());
        holder.weatherClassification.setText(weather.getWeatherClassification());
        setIcon(holder.weatherIcon, weather.getWeatherClassification());
    }

    private int getWeatherIcon(Weather weather) {
        // for determining the weather icon based on the weather conditions.
        if (weather.getWindSpeed().contains("High")) {
            return R.drawable.wind;
        } else if (weather.getVisibility().contains("Low")) {
            return R.drawable.fog;
        } else {
            return R.drawable.day_clear;
        }
    }

    private void setIcon(ImageView weatherIcon, String weatherClassification) {
        // Set the weather icon based on the weather classification
        switch (weatherClassification) {
            case "Sunny":
                weatherIcon.setImageResource(R.drawable.day_clear);
                break;
            case "Partly Cloudy":
                weatherIcon.setImageResource(R.drawable.day_partial_cloud);
                break;
            case "Light Cloud":
                weatherIcon.setImageResource(R.drawable.day_partial_cloud);
                break;
            case "Cloudy":
                weatherIcon.setImageResource(R.drawable.cloudy);
                break;
            case "Light Rain":
                weatherIcon.setImageResource(R.drawable.day_rain);
                break;
            case "Light Rain Showers":
                weatherIcon.setImageResource(R.drawable.day_rain);
                break;
            case "Heavy rain":
                weatherIcon.setImageResource(R.drawable.rain_thunder);
                break;
            case "Thunderstorms":
                weatherIcon.setImageResource(R.drawable.thunder);
                break;
            case "Mist":
                weatherIcon.setImageResource(R.drawable.mist);
                break;
            case "Drizzle":
                weatherIcon.setImageResource(R.drawable.day_rain);
                break;
            default:
                weatherIcon.setImageResource(R.drawable.day_clear);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        public ImageView weatherIcon;
        public TextView date;
        public TextView minTemp;
        public TextView maxTemp;
        public TextView windDirection;
        public TextView windSpeed;
        public TextView visibility;
        public TextView pressure;
        public TextView humidity;
        public TextView uvRisk;
        public TextView pollution;
        public TextView sunrise;
        public TextView sunset;
        public TextView dayOfWeek;
        public TextView weatherClassification;

        public WeatherViewHolder(View view) {
            super(view);
            weatherIcon = view.findViewById(R.id.weatherIcon);
            date = view.findViewById(R.id.date);
            minTemp = view.findViewById(R.id.minTemp);
            maxTemp = view.findViewById(R.id.maxTemp);
            windDirection = view.findViewById(R.id.windDirection);
            windSpeed = view.findViewById(R.id.windSpeed);
            visibility = view.findViewById(R.id.visibility);
            pressure = view.findViewById(R.id.pressure);
            humidity = view.findViewById(R.id.humidity);
            uvRisk = view.findViewById(R.id.uvRisk);
            pollution = view.findViewById(R.id.pollution);
            sunrise = view.findViewById(R.id.sunrise);
            sunset = view.findViewById(R.id.sunset);
            dayOfWeek = view.findViewById(R.id.dayOfWeek);
            weatherClassification = view.findViewById(R.id.weatherClassification);
        }
    }
}