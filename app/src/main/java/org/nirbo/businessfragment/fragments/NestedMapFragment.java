package org.nirbo.businessfragment.fragments;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.nirbo.businessfragment.R;
import org.nirbo.businessfragment.listeners.CameraZoomChangeListener;
import org.nirbo.businessfragment.listeners.ZoomBarAnimationListener;
import org.nirbo.businessfragment.listeners.ZoomBarOnChangeListener;
import org.nirbo.businessfragment.utilities.MapCamera;
import org.nirbo.businessfragment.views.MapZoomBar;

public class NestedMapFragment extends MapFragment {

    private static NestedMapFragment fragment;
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
        displayCurrentLocation();
    }

    // Customize the map's functionality
    private void customizeMapOptions() {
        UiSettings settings = getMap().getUiSettings();

        settings.setRotateGesturesEnabled(false);
        settings.setMyLocationButtonEnabled(false);
        settings.setZoomControlsEnabled(false);
        settings.setIndoorLevelPickerEnabled(false);
    }

    private void displayCurrentLocation() {
        LatLng coordinates = getCurrentLocation();
        Animation fadeInAnim = initZoomBarAnimation();

        MarkerOptions markerOptions = new MarkerOptions()
                .position(coordinates);
        mMap.addMarker(markerOptions);

        MapCamera.setInitialCameraPosition(mMap, coordinates,mMapZoomBar, fadeInAnim);
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

    private Animation initZoomBarAnimation() {
        Animation fadeIn = AnimationUtils.loadAnimation(mContext, R.anim.zoom_bar_fade_in);
        fadeIn.setAnimationListener(new ZoomBarAnimationListener(mMapZoomBar));

        return fadeIn;
    }

    private void setZoomBarToCurrentLevel(GoogleMap map) {
        mMapZoomBar.setProgress((int) map.getCameraPosition().zoom);
    }

}