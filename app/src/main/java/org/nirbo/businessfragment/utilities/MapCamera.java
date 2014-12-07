package org.nirbo.businessfragment.utilities;

import android.view.animation.Animation;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import org.nirbo.businessfragment.views.MapZoomBar;

public class MapCamera {

    public static void setInitialCameraPosition(GoogleMap map, LatLng coordinates, final MapZoomBar zoomBar, final Animation fadeIn) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(coordinates)
                .zoom(15)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                new GoogleMap.CancelableCallback() {

            @Override
            public void onFinish() {
                zoomBar.startAnimation(fadeIn);
            }

            @Override
            public void onCancel() {}
        });
    }

    public static void setCameraPositionAndZoom(GoogleMap map, LatLng coordinates, int zoomLevel) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(coordinates)
                .zoom(zoomLevel)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

}
