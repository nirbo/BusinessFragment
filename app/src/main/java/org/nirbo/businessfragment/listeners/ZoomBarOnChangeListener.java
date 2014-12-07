package org.nirbo.businessfragment.listeners;

import android.widget.SeekBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import org.nirbo.businessfragment.utilities.MapCamera;

public class ZoomBarOnChangeListener implements SeekBar.OnSeekBarChangeListener {

    private GoogleMap mMap;
    private LatLng mCoordinates;

    // Default Constructor
    public ZoomBarOnChangeListener() {}

    // A constructor that accepts a reference to the GoogleMap and a LatLng coordinates object, to update when onProgressChanged fires.
    public ZoomBarOnChangeListener(GoogleMap map, LatLng coordinates) {
        this.mMap = map;
        this.mCoordinates = coordinates;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            MapCamera.setCameraPositionAndZoom(mMap, mCoordinates, progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
