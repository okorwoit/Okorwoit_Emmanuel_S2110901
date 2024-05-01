package org.me.gcu.okorwoit_emmanuel_s2110901;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng glasgow = new LatLng(55.8, -4.2);
            googleMap.addMarker(new MarkerOptions().position(glasgow).title("Glasgow"));

            LatLng london = new LatLng(51.5, -0.1);
            googleMap.addMarker(new MarkerOptions().position(london).title("London"));

            LatLng newyork = new LatLng(43.0, 	-75.0);
            googleMap.addMarker(new MarkerOptions().position(newyork).title("New York"));

            LatLng oman = new LatLng(21.5, 55.9);
            googleMap.addMarker(new MarkerOptions().position(oman).title("Oman"));

            LatLng bangladesh = new LatLng(23.6, 90.3);
            googleMap.addMarker(new MarkerOptions().position(bangladesh).title("Bangladesh"));

            LatLng mauritius = new LatLng(-20.2, 57.6);
            googleMap.addMarker(new MarkerOptions().position(mauritius).title("Mauritius"));

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(glasgow));

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}