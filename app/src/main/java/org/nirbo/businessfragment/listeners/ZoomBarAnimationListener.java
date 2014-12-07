package org.nirbo.businessfragment.listeners;

import android.view.View;
import android.view.animation.Animation;

import org.nirbo.businessfragment.views.MapZoomBar;

public class ZoomBarAnimationListener implements Animation.AnimationListener {

    private MapZoomBar mMapZoomBar;

    // Default Constructor
    public ZoomBarAnimationListener() {}

    // A constructor that accepts a referendce to the map zoom bar
    public ZoomBarAnimationListener(MapZoomBar zoomBar) {
        this.mMapZoomBar = zoomBar;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        mMapZoomBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
