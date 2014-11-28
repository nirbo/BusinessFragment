package org.nirbo.businessfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import org.nirbo.businessfragment.fragments.BusinessCardFragment;
import org.nirbo.businessfragment.fragments.NestedMapFragment;

public class MainActivity extends ActionBarActivity {

    public static FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        fm = getFragmentManager();
        hideStatusBar();
        initFragment();
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

    // Static method that replaces the currently viewed Fragment with another Fragment.
    // Includes the option to add the Fragment to backStack if the boolean parameter is passed "true"
    public static void replaceFragment(Fragment fragment, String fragmentTag, boolean addToBackStack) {
        if (fragment != null) {
            FragmentTransaction ft = fm.beginTransaction();
//            ft.setCustomAnimations(R.anim.fade_in_fragment, R.anim.fade_out_fragment);
            ft.replace(R.id.main_container, fragment, fragmentTag);
            if (addToBackStack) {
                ft.addToBackStack(fragmentTag);
            }
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
