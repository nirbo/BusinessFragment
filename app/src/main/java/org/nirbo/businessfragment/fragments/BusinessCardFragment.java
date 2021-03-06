package org.nirbo.businessfragment.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import org.nirbo.businessfragment.MainActivity;
import org.nirbo.businessfragment.R;
import org.nirbo.businessfragment.adapters.BeersRecyclerAdapter;
import org.nirbo.businessfragment.adapters.OffersRecyclerAdapter;
import org.nirbo.businessfragment.adapters.ServicesRecyclerAdapter;
import org.nirbo.businessfragment.utilities.ViewSize;
import org.nirbo.businessfragment.views.MapZoomBar;

import java.util.Arrays;
import java.util.List;

public class BusinessCardFragment extends Fragment {

    public static final String FRAGMENT_TAG = "businessCard";

    private static FragmentManager fm;
    private Activity mContext;
    private GoogleMap mMap;
    private MapZoomBar mMapZoomBar;
    private RelativeLayout mBusinessCardHandleContainer;
    private RecyclerView mBusinessServices;
    private TextView mOffersTitle;
    private RecyclerView mOffersContainer;
    private RecyclerView mDrinks;

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
        mBusinessCardHandleContainer = (RelativeLayout) view.findViewById(R.id.slider_layout_handle_container);
        mBusinessServices = (RecyclerView) view.findViewById(R.id.business_services);
        mOffersTitle = (TextView) view.findViewById(R.id.offers_title);
        mOffersContainer = (RecyclerView) view.findViewById(R.id.offers_container);
        mDrinks = (RecyclerView) view.findViewById(R.id.drinks);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initMap();
        initBusinessCardLayout();
        initServicesRecyclerView();
        initOffersRecyclerView();
        initDrinksRecyclerView();
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

        // mBusinessCardHandleContainer height must match the height defined by the 'sliderPanel.setPanelHeight' method un the MainActivity class
        ViewSize.setViewHeight(6, mBusinessCardHandleContainer);

        // Set dimensions for the business services RecyclerView
        ViewSize.setViewHeight(10, mBusinessServices);
        ViewSize.setViewWidth(85, mBusinessServices);

        // Set dimensions for the Offers RecyclerView and its title TextView
        ViewSize.setViewWidth(85, mOffersTitle);
        ViewSize.setViewHeight(40, mOffersContainer);
        ViewSize.setViewWidth(85, mOffersContainer);

        // Set dimensions for the Drinks RecyclerView
        ViewSize.setViewHeight(10, mDrinks);
        ViewSize.setViewWidth(85, mDrinks);
    }

    private void initServicesRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setOrientation(LinearLayout.HORIZONTAL);
        mBusinessServices.setLayoutManager(llm);
        mBusinessServices.setHasFixedSize(true);

        int[] serviceImages = populateServiceImages();
        ServicesRecyclerAdapter adapter = new ServicesRecyclerAdapter(serviceImages, mContext);
        mBusinessServices.setAdapter(adapter);
    }

    private int[] populateServiceImages() {
        return new int[] {
                android.R.drawable.ic_lock_idle_lock,
                android.R.drawable.ic_menu_call,
                android.R.drawable.ic_delete,
                android.R.drawable.ic_dialog_alert,
                android.R.drawable.ic_dialog_dialer,
                android.R.drawable.ic_dialog_email,
                android.R.drawable.ic_dialog_info,
                android.R.drawable.ic_dialog_map,
                android.R.drawable.ic_input_add,
                android.R.drawable.ic_input_delete
        };
    }

    private void initOffersRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mOffersContainer.setLayoutManager(llm);
        mOffersContainer.setHasFixedSize(true);

        Resources res = getResources();
        String[] offers = res.getStringArray(R.array.offersPlaceholder);
        List<String> offersList = Arrays.asList(offers);

        OffersRecyclerAdapter adapter = new OffersRecyclerAdapter(offersList, mContext);
        mOffersContainer.setAdapter(adapter);
    }

    private void initDrinksRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setOrientation(LinearLayout.HORIZONTAL);
        mDrinks.setLayoutManager(llm);
        mDrinks.setHasFixedSize(true);

        int[] beerLogos = populateBeerLogos();
        BeersRecyclerAdapter adapter = new BeersRecyclerAdapter(beerLogos, mContext);
        mDrinks.setAdapter(adapter);
    }

    private int[] populateBeerLogos() {
        return new int[] {
            R.drawable.carlsberg,
            R.drawable.budweiser,
            R.drawable.maccabee,
            R.drawable.leffe,
            R.drawable.barbar,
            R.drawable.becks,
            R.drawable.chang,
            R.drawable.duvel,
            R.drawable.guinness,
            R.drawable.kilkenny
        };
    }

}
