package com.imaginedev.utilitybox.misc;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by batman on 04/03/18.
 */

public final class AssetsUtils {

    /**
     * @param fileName - Name of the file stored in assets
     *                 eg: "data.json", "cat.txt", "fonts/roboto.ttf"
     */
    public static String readAsString(Context context, String fileName) {
        String str = null;

        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            str = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return str;
    }

}
