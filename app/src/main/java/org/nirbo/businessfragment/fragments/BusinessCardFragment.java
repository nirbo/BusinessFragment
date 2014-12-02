package org.nirbo.businessfragment.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.nirbo.businessfragment.MainActivity;
import org.nirbo.businessfragment.R;
import org.nirbo.businessfragment.utilities.ViewSize;

public class BusinessCardFragment extends Fragment {

    public static final String FRAGMENT_TAG = "businessCard";

    private static FragmentManager fm;
    private GoogleMap mMap;
    private ImageView mBusinessPhoto;

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

        mBusinessPhoto = (ImageView) view.findViewById(R.id.business_photo);

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
        ViewSize.setViewHeight(20, mBusinessPhoto);
    }

}
