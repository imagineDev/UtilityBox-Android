package com.imaginedev.utilitybox.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

/**
 * To check and handle Runtime permissions in marshmallow and above android versions.
 */
public final class PermissionUtils {


    /**
     * Check whether device is marshmallow or not
     *
     * @return true if device's version is equal to marshmallow or greater else false.
     */
    public static boolean checkIsMarshMallowVersion() {
        int sdkVersion = Build.VERSION.SDK_INT;
        return sdkVersion >= Build.VERSION_CODES.M;

    }

    public static boolean checkVideoCameraPermission(Context mContext) {
        int result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA);
        int result2 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED;

    }

    public static boolean checkCallPermission(Context mContext) {
        int result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE);
        return result == PackageManager.PERMISSION_GRANTED;

    }

    /**
     * Checks at runtime if camera permission is provided to the app or not
     *
     * @param mContext = context
     * @return 'true' if provided else 'false'
     */
    public static boolean checkCameraPermission(Context mContext) {
        int result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;

    }

    /**
     * Checks at runtime if contacts permission is provided to the app or not
     *
     * @param mContext = context
     * @return 'true' if provided else 'false'
     */
    public static boolean checkContactsPermission(Context mContext) {
        int result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_CONTACTS);
        int result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_CONTACTS);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Checks at runtime if locations permission is provided to the app or not
     *
     * @param mContext = context
     * @return 'true' if provided else 'false'
     */
    public static boolean checkLocationPermission(Context mContext) {
        int result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION);
        int result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;

    }

    /**
     * Requests camera permission on run time (Activity Specific).
     *
     * @param activity    = calling activity
     * @param requestCode = request code to process request
     */
    public static void requestCameraPermission(Activity activity, int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, requestCode);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, requestCode);

        }
    }

    /**
     * Requests camera permission on run time (Fragment Specific).
     *
     * @param fragment    = calling fragment
     * @param requestCode = request code to process request
     */
    public static void requestCameraPermission(Fragment fragment, int requestCode) {
        if (fragment.shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                || fragment.shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            fragment.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, requestCode);
        } else {
            fragment.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, requestCode);

        }
    }

    /**
     * Requests video camera permission on run time (Activity Specific).
     *
     * @param activity    = calling activity
     * @param requestCode = request code to process request
     */
    public static void requestVideoCameraPermission(Activity activity, int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, requestCode);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, requestCode);

        }
    }

    /**
     * Requests camera permission on run time (Activity Specific).
     *
     * @param activity    = calling activity
     * @param requestCode = request code to process request
     */
    public static void requestContactsPermission(Activity activity, int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CONTACTS)) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_CONTACTS}, requestCode);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_CONTACTS}, requestCode);
        }
    }

    /**
     * Requests camera permission on run time (Fragment Specific).
     *
     * @param fragment    = calling fragment
     * @param requestCode = request code to process request
     */
    public static void requestContactsPermission(Fragment fragment, int requestCode) {
        if (fragment.shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS) || fragment.shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
            fragment.requestPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS}, requestCode);
        } else {
            fragment.requestPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS}, requestCode);
        }
    }

    /**
     * Requests Location permission on run time (Activity Specific).
     *
     * @param activity    = calling activity
     * @param requestCode = request code to process request
     */
    public static void requestLocationPermission(Activity activity, int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
        }
    }

    public static void requestCallPermission(Fragment fragment, int requestCode) {
        if (fragment.shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
            fragment.requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, requestCode);
        } else {
            fragment.requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, requestCode);
        }
    }

    public static boolean checkWriteExtStoragePermission(Context mContext) {
        int result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return (result1 == PackageManager.PERMISSION_GRANTED);
    }


    public static void requestWriteExtStoragePermission(Activity activity, int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
        }
    }


}