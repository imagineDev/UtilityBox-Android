package com.imaginedev.utilitybox.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by batman on 04/03/18.
 */

public final class DrawableUtils {


    public static Drawable fromResources(Resources resources, @DrawableRes int resourceId) {
        return resources.getDrawable(resourceId);
    }

    public static Drawable fromFile(File file) {
        return Drawable.createFromPath(file.getAbsolutePath());
    }


    /**
     * Uri format : "android.resource://my_app_package/drawable/drawable_name"
     *
     * @return Drawable at that Uri
     */
    public static Drawable fromUri(Context ctx, Uri uri) throws FileNotFoundException {
        Drawable drawable = null;
        InputStream inputStream = ctx.getContentResolver().openInputStream(uri);
        drawable = fromStream(inputStream, uri.toString());
        return drawable;
    }

    public static Drawable fromStream(InputStream is, @Nullable String sourceName) {
        return Drawable.createFromStream(is, sourceName);
    }

    public static Drawable fromAssets(Context context, String url) {
        Drawable drawable = null;
        InputStream inputStream = null;
        try {

            inputStream = context.getAssets().open(url);
            drawable = fromStream(inputStream, null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return drawable;
    }

    /**
     * From the documentation:
     * A Drawable that wraps a bitmap and can be tiled, stretched, or aligned. You can create a BitmapDrawable from a file path, an input stream, through XML inflation, or from a Bitmap object.
     *
     * @return A BitmapDrawable.
     */
    public static Drawable fromBitmap(Resources resources, Bitmap bitmap) {
        return new BitmapDrawable(resources, bitmap);
    }

    public static Drawable fromByteArray(Resources resources, byte[] array) {
        return new BitmapDrawable(resources, BitmapUtils.fromByteArray(array));
    }


}
