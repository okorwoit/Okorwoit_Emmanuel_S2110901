package org.me.gcu.okorwoit_emmanuel_s2110901;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocationDetailActivity extends AppCompatActivity {
    private RecyclerView weatherRecyclerView;
    private WeatherAdapter weatherAdapter;

    private RssFeedService rssFeedService;
    private List<Weather> weatherList;

    private LinearLayout progressBar;
    private LinearLayout weatherLatestObservationsLayout;
    private LinearLayout weatherForecastLayout;
    private TextView latestDate;

    private static final String WEATHER_URL = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);
        Log.d("LocationDetailActivity", "Activity created");

        progressBar = findViewById(R.id.progressBar);
        weatherLatestObservationsLayout = findViewById(R.id.observationLayout);
        weatherForecastLayout = findViewById(R.id.forecastLayout);

        Date currentDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String dateString = formatter.format(currentDate);

        latestDate = findViewById(R.id.date2);
        latestDate.setText(dateString);

        // Initialize RecyclerView
        weatherRecyclerView = findViewById(R.id.weatherRecyclerView);
        weatherRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize RssFeedService
        rssFeedService = new RssFeedService();

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Get the location ID from the intent
        String locationId = getIntent().getStringExtra("locationId");
        if (locationId == null) {
            Log.e("LocationDetailActivity", "No location ID provided");
            finish();
            return;
        }

        // Set the location name
        TextView locationNameTextView = findViewById(R.id.locationName);
        locationNameTextView.setText(getLocationName(locationId));

        // Fetch weather data
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            progressBar.setVisibility(View.VISIBLE);
            weatherLatestObservationsLayout.setVisibility(View.GONE);
            weatherForecastLayout.setVisibility(View.GONE);

            weatherList = rssFeedService.fetchWeatherData(WEATHER_URL + locationId);
            Log.d("LocationDetailActivity", "Fetched weather data, updating UI");
            runOnUiThread(() -> updateUI());
        });
    }

    private void updateUI() {
        if (weatherList == null || weatherList.isEmpty()) {
            Log.d("LocationDetailActivity", "Error fetching weather data");
            Toast.makeText(this, "Error fetching weather data", Toast.LENGTH_SHORT).show();
            return;
        }

        // Set the adapter for the RecyclerView
        weatherAdapter = new WeatherAdapter(weatherList);
        weatherRecyclerView.setAdapter(weatherAdapter);

        // Update the latest observations
        updateLatestObservations(weatherList.get(0));

        progressBar.setVisibility(View.GONE);
        weatherForecastLayout.setVisibility(View.VISIBLE);
        weatherLatestObservationsLayout.setVisibility(View.VISIBLE);

    }

    private String getLocationName(String locationId) {
        // for determining the location name based on the location ID.
        switch (locationId) {
            case "2648579":
                return "Glasgow";
            case "2643743":
                return "London";
            case "5128581":
                return "New York";
            case "287286":
                return "Oman";
            case "934154":
                return "Mauritius";
            case "1185241":
                return "Bangladesh";
            default:
                return "Unknown";
        }
    }

    private void updateLatestObservations(Weather latestWeather) {
        //Get the UI elements
        ImageView weatherIcon = findViewById(R.id.weatherIcon2);
        TextView weatherClassification = findViewById(R.id.weatherClassification2);
        TextView minTemp = findViewById(R.id.minTemp2);
        TextView maxTemp = findViewById(R.id.maxTemp2);
        TextView windDirection = findViewById(R.id.windDirection2);
        TextView windSpeed = findViewById(R.id.windSpeed2);
        TextView visibility = findViewById(R.id.visibility2);
        TextView pressure = findViewById(R.id.pressure2);
        TextView humidity = findViewById(R.id.humidity2);
        TextView uvRisk = findViewById(R.id.uvRisk2);
        TextView pollution = findViewById(R.id.pollution2);
        TextView sunrise = findViewById(R.id.sunrise2);
        TextView sunset = findViewById(R.id.sunset2);

        //Set the UI elements
        setIcon(weatherIcon, latestWeather.getWeatherClassification());
        weatherClassification.setText(latestWeather.getWeatherClassification());
        minTemp.setText(latestWeather.getMinTemp());
        maxTemp.setText(latestWeather.getMaxTemp());
        windDirection.setText(latestWeather.getWindDirection());
        windSpeed.setText(latestWeather.getWindSpeed());
        visibility.setText(latestWeather.getVisibility());
        pressure.setText(latestWeather.getPressure());
        humidity.setText(latestWeather.getHumidity());
        uvRisk.setText(latestWeather.getUvRisk());
        pollution.setText(latestWeather.getPollution());
        sunrise.setText(latestWeather.getSunrise());
        sunset.setText(latestWeather.getSunset());

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


   
}