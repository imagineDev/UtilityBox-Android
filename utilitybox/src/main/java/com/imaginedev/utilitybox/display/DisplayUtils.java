package com.imaginedev.utilitybox.display;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.InvocationTargetException;

import timber.log.Timber;

/**
 * Created by batman on 28/02/18.
 */

public final class DisplayUtils {

    /**
     * It converts Pixels to DIP
     *
     * @param px - target pixel size
     * @return size in dip
     **/
    public static float pxToDp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }


    /**
     * It converts dip to pixels
     *
     * @param dp - target size in DIP
     * @return size in pixels
     */
    public static int dpToPx(final Context context, final float dp) {
        if (context == null)
            return 0;
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }


    /**
     * @return size of the display in pixels.
     *         The size is adjusted based on the current rotation of the display. And it includes the system decoration items such as status bar
     * */
    public static Point getAppUsableScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    /**
     * Gets the real size of the display without including navigation bar size.
     * */
    public static Point getRealScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();

        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(size);
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                size.x = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
                size.y = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
            } catch (IllegalAccessException e) {
                Timber.e(e);
            } catch (InvocationTargetException e) {
                Timber.e(e);
            } catch (NoSuchMethodException e) {
                Timber.e(e);
            }
        }

        return size;
    }


    /**
     * @return device standard status bar height in pixels
     */
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }

        return 0;
    }


    /**
     * @return device standard toolbar bar height in pixels
     */
    public static int getDefaultToolbarHeight(Context context) {
        int actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }

        return actionBarHeight;
    }


    /**
     * @return true is soft navigation bar is enabled in system settings.
     *
     * */
    public static boolean isSoftNavigationBarVisible(Context context) {
        Resources resources = context.getResources();
        int id = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        return id > 0 && resources.getBoolean(id);
    }


    /**
     * If this DOES NOT work for you, try getNavigationBarSizeFix() method instead.
     * */
    public static int getDefaultNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }

        return 0;
    }

    /**
     * For some devices getting navigation bar height or availability from resource does not work.
     * Here we are calculating actual bar size visible on the screen.
     *
     * @return Point class representing navigation bar height
     *         returns a black point object if navigation bar is not present.
     *
     */
    public static Point getNavigationBarSizeFix(Context context) {
        Point appUsableSize = getAppUsableScreenSize(context);
        Point realScreenSize = getRealScreenSize(context);

        // navigation bar on the right
        if (appUsableSize.x < realScreenSize.x) {
            return new Point(realScreenSize.x - appUsableSize.x, appUsableSize.y);
        }

        // navigation bar at the bottom
        if (appUsableSize.y < realScreenSize.y) {
            return new Point(appUsableSize.x, realScreenSize.y - appUsableSize.y);
        }

        // navigation bar is not present
        return new Point();
    }


}
