package org.nirbo.businessfragment.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import org.nirbo.businessfragment.MainActivity;
import org.nirbo.businessfragment.R;
import org.nirbo.businessfragment.utilities.ViewSize;
import org.nirbo.businessfragment.views.MapZoomBar;

public class BusinessCardFragment extends Fragment {

    public static final String FRAGMENT_TAG = "businessCard";

    private static FragmentManager fm;
    private GoogleMap mMap;
    private MapZoomBar mMapZoomBar;
    private LinearLayout mBusinessCardHandle;

    // Default constructor
    public BusinessCardFragment() {
        super();
    }

    // newInstance method to instantiate new fragments
    public static BusinessCardFragment newInstance() {
        fm = MainActivity.fm;

        return new BusinessCardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.business_card_fragment, container, false);

        mMapZoomBar = (MapZoomBar) view.findViewById(R.id.map_zoom_bar);
        mBusinessCardHandle = (LinearLayout) view.findViewById(R.id.slider_layout_handle);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initMap();
        initBusinessCardLayout();
    }

    // Initialize Google Maps fragment
    private void initMap() {
        if (mMap == null) {
            NestedMapFragment mMapFragment = NestedMapFragment.newInstance();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.map, mMapFragment);
            ft.commit();
        }
    }

    // Set the Business Card views layout and sizes
    private void initBusinessCardLayout() {
        ViewSize.setViewHeight(90, mMapZoomBar);

        /* mBusinessCardHandle height must match the height defined by the 'sliderPanel.setPanelHeight' method
        In the MainActivity class  */
        ViewSize.setViewHeight(5, mBusinessCardHandle);
    }



}
