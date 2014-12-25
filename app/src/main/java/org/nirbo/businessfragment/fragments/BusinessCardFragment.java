package org.nirbo.businessfragment.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.maps.GoogleMap;

import org.nirbo.businessfragment.MainActivity;
import org.nirbo.businessfragment.R;
import org.nirbo.businessfragment.adapters.ServicesRecyclerAdapter;
import org.nirbo.businessfragment.utilities.ViewSize;
import org.nirbo.businessfragment.views.MapZoomBar;

public class BusinessCardFragment extends Fragment {

    public static final String FRAGMENT_TAG = "businessCard";

    private static FragmentManager fm;
    private Activity mContext;
    private GoogleMap mMap;
    private MapZoomBar mMapZoomBar;
    private LinearLayout mBusinessCardHandle;
    private RecyclerView mBusinessServices;

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

        mContext = getActivity();

        mMapZoomBar = (MapZoomBar) view.findViewById(R.id.map_zoom_bar);
        mBusinessCardHandle = (LinearLayout) view.findViewById(R.id.slider_layout_handle);
        mBusinessServices = (RecyclerView) view.findViewById(R.id.business_services);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initMap();
        initBusinessCardLayout();
        initServicesRecyclerView();
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
        ViewSize.setViewHeight(7, mBusinessCardHandle);

        ViewSize.setViewHeight(10, mBusinessServices);
        ViewSize.setViewWidth(85, mBusinessServices);
    }

    private void initServicesRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setOrientation(LinearLayout.HORIZONTAL);
        mBusinessServices.setLayoutManager(llm);
        mBusinessServices.setHasFixedSize(true);

        int[] serviceImages = populateServiceImages();
        ServicesRecyclerAdapter adapter = new ServicesRecyclerAdapter(serviceImages);
        mBusinessServices.setAdapter(adapter);
    }

    private int[] populateServiceImages() {
        int[] images = new int[]{
                android.R.drawable.btn_radio,
                android.R.drawable.btn_star,
                android.R.drawable.ic_delete,
                android.R.drawable.ic_dialog_alert,
                android.R.drawable.ic_dialog_dialer,
                android.R.drawable.ic_dialog_email,
                android.R.drawable.ic_dialog_info,
                android.R.drawable.ic_dialog_map,
                android.R.drawable.ic_input_add,
                android.R.drawable.ic_input_delete
        };

        return images;
    }

}
