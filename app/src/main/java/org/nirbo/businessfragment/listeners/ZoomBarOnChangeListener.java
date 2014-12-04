package org.nirbo.businessfragment.listeners;

import android.widget.SeekBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;

public class ZoomBarOnChangeListener implements SeekBar.OnSeekBarChangeListener {

    private GoogleMap mMap;

    // Default Constructor
    public ZoomBarOnChangeListener() {}

    // Constructor that accepts the current zoom level of the map and sets the zoom bar accordingly
    public ZoomBarOnChangeListener(GoogleMap map) {
        this.mMap = map;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
