package org.nirbo.businessfragment.listeners;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;

import org.nirbo.businessfragment.views.MapZoomBar;

public class CameraZoomChangeListener implements GoogleMap.OnCameraChangeListener {

    private MapZoomBar mMapZoomBar;
    private GoogleMap mMap;

    // Default Constructor
    public CameraZoomChangeListener() {}

    // A constructor that accepts a reference to the map zoom bar in order to update the zoom progress onCameraChange event.
    public CameraZoomChangeListener(MapZoomBar mapZoomBar, GoogleMap map) {
        this.mMapZoomBar = mapZoomBar;
        this.mMap = map;
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        mMapZoomBar.setProgressAndThumb((int) mMap.getCameraPosition().zoom);
    }
}
