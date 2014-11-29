package org.nirbo.businessfragment.utilities;

import android.graphics.Point;
import android.view.Display;

public class ScreenSize {

    public static Point getDisplaySize(final Display display) {
        final Point point = new Point();

        display.getSize(point);
        return point;
    }

    public static int getDisplayHeight(final Display display) {
        final Point point = new Point();

        display.getSize(point);
        int screenHeight = point.y;

        return screenHeight;
    }

    public static int getDisplayWidth(final Display display) {
        final Point point = new Point();

        display.getSize(point);
        int screenWidth = point.x;

        return screenWidth;
    }

    public static int getDisplaySeventyPercent(int screenHeight) {
        int seventyPercentScreenHeight = (70 * screenHeight) / 100;

        return seventyPercentScreenHeight;
    }

}
