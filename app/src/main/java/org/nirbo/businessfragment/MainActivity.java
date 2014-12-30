package org.nirbo.businessfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.nirbo.businessfragment.fragments.BusinessCardFragment;
import org.nirbo.businessfragment.listeners.SlidingPanelListener;
import org.nirbo.businessfragment.utilities.DisplaySize;

public class MainActivity extends ActionBarActivity {

    public static FragmentManager fm;
    public static int displayHeight;
    public static int displayWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        fm = getFragmentManager();
        getDisplayMeasures();

        hideStatusBar();
        initFragment();
    }

    @Override
    public void onStart() {
        super.onStart();

        initSlidingLayoutParams();
    }

    // Hides Android's statue bar - swiping down from the top will make it re-appear temporarily
    private void hideStatusBar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    // Initialize the view with the first Fragment that will be displayed upon activity launch
    private void initFragment() {
        replaceFragment(BusinessCardFragment.newInstance(), BusinessCardFragment.FRAGMENT_TAG, false);
    }

    private void getDisplayMeasures() {
        // Get current screen's height and width in pixels
        final Display display = getWindowManager().getDefaultDisplay();
        displayHeight = DisplaySize.getDisplayHeight(display);
        displayWidth = DisplaySize.getDisplayWidth(display);
    }

    // Static method that replaces the currently viewed Fragment with another Fragment.
    // Includes the option to add the Fragment to backStack if the boolean parameter is passed "true"
    public static void replaceFragment(Fragment fragment, String fragmentTag, boolean addToBackStack) {
        if (fragment != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_container, fragment, fragmentTag);
            if (addToBackStack) {
                ft.addToBackStack(fragmentTag);
            }
            ft.commit();
        }
    }

    // Customize the sliding layout's features and params
    private void initSlidingLayoutParams() {
        SlidingUpPanelLayout sliderPanel = (SlidingUpPanelLayout) findViewById(R.id.slider_layout);
        float anchorPoint = 0.3f;
        sliderPanel.setPanelSlideListener(new SlidingPanelListener(this, anchorPoint));

        // Set the anchor point of the sliding panel; measured by a float in percentage of the screen (0.0f to 1.0f)
        sliderPanel.setAnchorPoint(anchorPoint);

        // Set the "open" limit of the sliding panel, it can be expanded up to 100% of the screen from this point
        // And when swiping down to collapse it, it will collapse down to this percentage of the screen and expose the map fragment.
        sliderPanel.setPanelHeight(DisplaySize.getHeightPercent(6, displayHeight));
    }

}
