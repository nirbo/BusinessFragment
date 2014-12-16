package org.nirbo.businessfragment.utilities;

import android.view.View;
import android.view.ViewGroup;

import org.nirbo.businessfragment.MainActivity;

public class ViewSize {

    public static void setViewHeight(int percentage, View view) {
        view.getLayoutParams().height = DisplaySize.getHeightPercent(percentage, MainActivity.displayHeight);
        view.requestLayout();
    }

    public static void setViewWidth(int percentage, View view) {
        view.getLayoutParams().width = DisplaySize.getWidthPercent(percentage, MainActivity.displayWidth);
        view.requestLayout();
    }

}
