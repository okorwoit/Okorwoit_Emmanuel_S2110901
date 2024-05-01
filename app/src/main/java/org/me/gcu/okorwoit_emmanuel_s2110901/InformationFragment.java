package org.me.gcu.okorwoit_emmanuel_s2110901;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformationFragment newInstance(String param1, String param2) {
        InformationFragment fragment = new InformationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_information, container, false);

    // Bind the TextViews
    TextView titleTextView = view.findViewById(R.id.title);
    TextView infoTextView = view.findViewById(R.id.info);

    // Set the text of the TextViews
    String title = "About Our Weather App";
    String info = "Welcome to our weather app! Our goal is to provide you with accurate and up-to-date weather information so you can plan your day effectively.\n\nKey Features:\n\nReal-Time Updates: Get the latest weather conditions in real-time.\nHourly Forecasts: Plan your activities with hourly weather forecasts.\nDaily Forecasts: Stay prepared with detailed daily weather predictions.\nCustomizable Alerts: Set personalized weather alerts for your locations.\nInteractive Maps: Visualize weather patterns with interactive maps.\nWeather Notifications: Receive notifications for weather changes and alerts.\n\nWhy Choose Our App?\n\nAccuracy: Our app uses reliable weather data sources to provide accurate forecasts.\nUser-Friendly: Easy-to-use interface for effortless navigation and information access.\nCustomization: Tailor the app to your preferences with customizable settings.\nMulti-Language Support: Available in multiple languages for a global user base.\nFeedback: We value your feedback and continuously strive to improve the app.\n\nContact Us:\n\nIf you have any questions, feedback, or suggestions, please feel free to reach out to us at support@weatherapp.com. Your input helps us enhance your weather experience.\n\nThank you for choosing our weather app. Stay informed and stay prepared!";
    titleTextView.setText(title);
    infoTextView.setText(info);

    return view;
}
}