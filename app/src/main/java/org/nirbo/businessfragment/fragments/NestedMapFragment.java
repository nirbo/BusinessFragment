package org.nirbo.businessfragment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;

public class NestedMapFragment extends MapFragment {

    public NestedMapFragment() {
        super();
    }

    public static NestedMapFragment newInstance() {
        NestedMapFragment fragment = new NestedMapFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = super.onCreateView(inflater, viewGroup, bundle);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        customizeMapOptions();
    }

    // Customize the map's functionalities
    private void customizeMapOptions() {
        UiSettings settings = getMap().getUiSettings();

        settings.setRotateGesturesEnabled(false);
        settings.setMyLocationButtonEnabled(false);
        settings.setZoomControlsEnabled(false);
    }

}
