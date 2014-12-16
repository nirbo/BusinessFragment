package org.nirbo.businessfragment.listeners;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.nirbo.businessfragment.R;
import org.nirbo.businessfragment.utilities.ViewSize;
import org.nirbo.businessfragment.views.MapZoomBar;

public class SlidingPanelListener implements SlidingUpPanelLayout.PanelSlideListener {

    private Activity mContext;
    private float mAnchorPoint;
    private FrameLayout mapRootView;
    private MapZoomBar mapZoomBar;

    // Default Constructor
    public SlidingPanelListener() {}

    // A constructor that accepts that context of the activity and the selected anchorPoint
    public SlidingPanelListener(Activity context, float anchorPoint) {
        this.mContext = context;
        this.mAnchorPoint = anchorPoint;
    }

    @Override
    public void onPanelSlide(View slidingPanel, float slideOffset) {

    }

    @Override
    public void onPanelCollapsed(View slidingPanel) {
        restoreFullMapView();
    }

    @Override
    public void onPanelExpanded(View slidingPanel) {

    }

    @Override
    public void onPanelAnchored(View slidingPanel) {
        adjustMapView();
    }

    @Override
    public void onPanelHidden(View slidingPanel) {

    }

    // Re-adjusts the map view's height when the sliding panel is anchored and released from anchor
    private void adjustMapView() {
        mapRootView = (FrameLayout) mContext.findViewById(R.id.map_root_view);
        mapZoomBar = (MapZoomBar) mContext.findViewById(R.id.map_zoom_bar);

        float newMapViewSize = (1.0f - mAnchorPoint);
        int newMapViewSizePercent = (int) (newMapViewSize * 100);
        ViewSize.setViewHeight((newMapViewSizePercent + 2), mapRootView);
        ViewSize.setViewHeight((newMapViewSizePercent - 5), mapZoomBar);
    }

    // Restore the map views to 100% of the screen upon panel collapse
    private void restoreFullMapView() {
        ViewSize.setViewHeight(100, mapRootView);
        ViewSize.setViewHeight(90, mapZoomBar);
    }
}
