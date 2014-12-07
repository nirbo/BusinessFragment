package org.nirbo.businessfragment.utilities;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapCamera {

    public static void setCameraPositionAndZoom(GoogleMap map, LatLng coordinates, int zoomLevel) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(coordinates)
                .zoom(zoomLevel)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

}
