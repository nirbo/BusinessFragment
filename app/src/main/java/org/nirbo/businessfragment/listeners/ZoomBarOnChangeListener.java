package org.nirbo.businessfragment.listeners;

import android.widget.SeekBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class ZoomBarOnChangeListener implements SeekBar.OnSeekBarChangeListener {

    private GoogleMap mMap;
    private LatLng mCoordinates;

    // Default Constructor
    public ZoomBarOnChangeListener() {}

    // A constructor that accepts a reference to the GoogleMap object
    public ZoomBarOnChangeListener(GoogleMap map, LatLng coordinates) {
        this.mMap = map;
        this.mCoordinates = coordinates;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(mCoordinates)
                    .zoom(progress)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
