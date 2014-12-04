package org.nirbo.businessfragment.fragments;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.nirbo.businessfragment.R;
import org.nirbo.businessfragment.listeners.ZoomBarOnChangeListener;
import org.nirbo.businessfragment.views.VerticalSeekBar;

public class NestedMapFragment extends MapFragment {

    static NestedMapFragment fragment;
    private Activity mContext;
    private VerticalSeekBar mMapZoomBar;

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
        mMapZoomBar = (VerticalSeekBar) mContext.findViewById(R.id.map_zoom_bar);

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

        displayCurrentLocation(fragment);
    }

    private void displayCurrentLocation(MapFragment fragment) {
        Activity context = getActivity();
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null) {
            LatLng coordinates = new LatLng(location.getLatitude(), location.getLongitude());
            GoogleMap mMap = fragment.getMap();

            MarkerOptions markerOptions = new MarkerOptions()
                    .position(coordinates);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(coordinates)
                    .zoom(15)
                    .build();

            // TODO: FIX CAMERA ANIMATION WHEN SETTING ZOOMBAR PROGRESS
//            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            mMap.addMarker(markerOptions);

            setZoomBarToCurrentLevel(mMap);
            mMapZoomBar.setOnSeekBarChangeListener(new ZoomBarOnChangeListener(mMap));
        }
    }

    private void setZoomBarToCurrentLevel(GoogleMap map) {
        float zoomLevel = map.getCameraPosition().zoom;
        mMapZoomBar.setProgress((int) zoomLevel);
    }

}
