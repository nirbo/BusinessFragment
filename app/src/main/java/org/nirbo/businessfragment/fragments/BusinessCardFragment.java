package org.nirbo.businessfragment.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.nirbo.businessfragment.MainActivity;
import org.nirbo.businessfragment.R;

public class BusinessCardFragment extends Fragment {

    public static final String FRAGMENT_TAG = "businessCard";
    private FragmentManager fm;

    // Default constructor
    public BusinessCardFragment() {
        fm = MainActivity.fm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.business_card_fragment, container, false);

        return view;
    }



}
