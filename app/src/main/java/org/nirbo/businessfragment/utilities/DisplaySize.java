package org.nirbo.businessfragment.utilities;

import android.graphics.Point;
import android.view.Display;

public class DisplaySize {

    public static Point getDisplaySize(final Display display) {
        final Point point = new Point();

        display.getSize(point);
        return point;
    }

    public static int getDisplayHeight(final Display display) {
        final Point point = new Point();
        display.getSize(point);

        return point.y;
    }

    public static int getDisplayWidth(final Display display) {
        final Point point = new Point();
        display.getSize(point);

        return point.x;
    }

    public static int getHeightPercent(int percentage, int screenHeight) {
        return (percentage * screenHeight) / 100;
    }

    public static int getWidthPercent(int percentage, int screenWidth) {
        return (percentage * screenWidth) / 100;
    }
}
