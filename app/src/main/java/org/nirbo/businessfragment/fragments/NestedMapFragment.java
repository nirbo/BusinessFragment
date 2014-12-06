package org.nirbo.businessfragment.fragments;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.nirbo.businessfragment.R;
import org.nirbo.businessfragment.listeners.CameraZoomChangeListener;
import org.nirbo.businessfragment.listeners.ZoomBarOnChangeListener;
import org.nirbo.businessfragment.views.MapZoomBar;
import org.nirbo.businessfragment.views.VerticalSeekBar;

public class NestedMapFragment extends MapFragment {

    static NestedMapFragment fragment;
    private Activity mContext;
    private MapZoomBar mMapZoomBar;
    private GoogleMap mMap;

    // Default constructor
    public NestedMapFragment() {
        super();
    }

    // newInstance method to instantiate new fragments
    public static NestedMapFragment newInstance() {
        fragment = new NestedMapFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = super.onCreateView(inflater, viewGroup, bundle);

        mContext = getActivity();
        mMap = fragment.getMap();
        mMapZoomBar = (MapZoomBar) mContext.findViewById(R.id.map_zoom_bar);

        mMapZoomBar.setOnSeekBarChangeListener(new ZoomBarOnChangeListener(mMap, getCurrentLocation()));
        mMap.setOnCameraChangeListener(new CameraZoomChangeListener(mMapZoomBar, mMap));

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        customizeMapOptions();
    }

    // Customize the map's functionalities
    private void customizeMapOptions() {
        UiSettings settings = getMap().getUiSettings();

        settings.setRotateGesturesEnabled(false);
        settings.setMyLocationButtonEnabled(false);
        settings.setZoomControlsEnabled(false);

        displayCurrentLocation();
    }

    private void displayCurrentLocation() {
        LatLng coordinates = getCurrentLocation();
        
        MarkerOptions markerOptions = new MarkerOptions()
                .position(coordinates);
        mMap.addMarker(markerOptions);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(coordinates)
                .zoom(15)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        setZoomBarToCurrentLevel(mMap);
    }

    private LatLng getCurrentLocation() {
        LocationManager locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        LatLng coordinates;

        if (location != null) {
            coordinates = new LatLng(location.getLatitude(), location.getLongitude());
        /*
        TODO: This 'else' is for development purposes with an Android emulator ONLY; It is to be removed before going to production.
         */
        } else {
            coordinates = new LatLng(32.074323, 34.792266);
        }

        return coordinates;
    }

    private void setZoomBarToCurrentLevel(GoogleMap map) {
        mMapZoomBar.setProgress((int) map.getCameraPosition().zoom);
    }

}