package org.nirbo.businessfragment.listeners;

import android.view.View;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class SlidingPanelListener implements SlidingUpPanelLayout.PanelSlideListener {

    private SlidingUpPanelLayout mSliderLayout;

    // Default constructor
    public SlidingPanelListener() {}

    // Constructor that accepts a reference to the Sliding Panel Layout
    public SlidingPanelListener(SlidingUpPanelLayout sliderLayout) {
        this.mSliderLayout = sliderLayout;
    }

    @Override
    public void onPanelSlide(View slidingPanel, float slideOffset) {

    }

    @Override
    public void onPanelCollapsed(View slidingPanel) {

    }

    @Override
    public void onPanelExpanded(View slidingPanel) {

    }

    @Override
    public void onPanelAnchored(View slidingPanel) {

    }

    @Override
    public void onPanelHidden(View slidingPanel) {

    }
}
