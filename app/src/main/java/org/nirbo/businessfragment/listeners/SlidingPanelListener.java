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
    private FrameLayout mMapRootView;
    private MapZoomBar mMapZoomBar;
    private boolean mAnchorFlag;

    // Default Constructor
    public SlidingPanelListener() {}

    // A constructor that accepts that context of the activity and the selected anchorPoint
    public SlidingPanelListener(Activity context, float anchorPoint) {
        this.mContext = context;
        this.mAnchorPoint = anchorPoint;
        this.mAnchorFlag = false;
    }

    @Override
    public void onPanelSlide(View slidingPanel, float slideOffset) {

    }

    @Override
    public void onPanelCollapsed(View slidingPanel) {
        if (mAnchorFlag) {
            mAnchorFlag = false;
            restoreFullMapView();
        }
    }

    @Override
    public void onPanelExpanded(View slidingPanel) {

    }

    @Override
    public void onPanelAnchored(View slidingPanel) {
        mAnchorFlag = true;
        adjustMapView();
    }

    @Override
    public void onPanelHidden(View slidingPanel) {

    }

    // Re-adjusts the map view's height when the sliding panel is anchored and released from anchor
    private void adjustMapView() {
        mMapRootView = (FrameLayout) mContext.findViewById(R.id.map_root_view);
        mMapZoomBar = (MapZoomBar) mContext.findViewById(R.id.map_zoom_bar);

        float newMapViewSize = (1.0f - mAnchorPoint);
        int newMapViewSizePercent = (int) (newMapViewSize * 100);
        ViewSize.setViewHeight((newMapViewSizePercent + 2), mMapRootView);
        ViewSize.setViewHeight((newMapViewSizePercent - 5), mMapZoomBar);
    }

    // Restore the map views to 100% of the screen upon panel collapse
    private void restoreFullMapView() {
        ViewSize.setViewHeight(100, mMapRootView);
        ViewSize.setViewHeight(90, mMapZoomBar);
    }
}
