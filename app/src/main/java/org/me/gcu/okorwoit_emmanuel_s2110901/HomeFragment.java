package org.me.gcu.okorwoit_emmanuel_s2110901;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView locationListView;
    private HashMap<String, String> locationMap;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        // Initialize views
        locationListView = view.findViewById(R.id.locationListView);

        // Initialize location map
        locationMap = new HashMap<>();
        // Add locations to the map
        locationMap.put("Glasgow", "2648579");
        locationMap.put("London", "2643743");
        locationMap.put("New York", "5128581");
        locationMap.put("Oman", "287286");
        locationMap.put("Mauritius", "934154");
        locationMap.put("Bangladesh", "1185241");

        // Set up the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, new ArrayList<>(locationMap.keySet()));

        locationListView.setAdapter(adapter);
        locationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String locationName = (String) parent.getItemAtPosition(position);
                String locationId = locationMap.get(locationName);
                Log.d("MainActivity", "Selected location: " + locationName + " (ID: " + locationId + ")");
                Intent intent = new Intent(requireContext(), LocationDetailActivity.class);
                intent.putExtra("locationId", locationId);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("MainActivity", "Error starting LocationDetailActivity", e);
                }
            }
        });

        return view;
    }
}