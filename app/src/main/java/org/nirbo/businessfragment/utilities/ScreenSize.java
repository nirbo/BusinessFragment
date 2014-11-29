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

        return point.y;
    }

    public static int getDisplayWidth(final Display display) {
        final Point point = new Point();
        display.getSize(point);

        return point.x;
    }

    public static int getDisplaySeventyPercent(int screenHeight) {
        return (70 * screenHeight) / 100;
    }

}
