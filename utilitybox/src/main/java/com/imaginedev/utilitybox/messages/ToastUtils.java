package com.imaginedev.utilitybox.messages;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.imaginedev.utilitybox.string.StringUtils;

/**
 * Created by batman on 28/02/18.
 */

public final class ToastUtils {

    public static void showShort(Context ctx, String str) {
        if (ctx == null || str == null) {
            return;
        }
        show(ctx, str, Toast.LENGTH_SHORT);
    }

    public static void showShort(Context ctx, @StringRes int strRes, @Nullable Object[] strArgs) {
        if (ctx == null ) {
            return;
        }
        show(ctx, strRes, strArgs, Toast.LENGTH_SHORT);
    }

    public static void showLong(Context ctx, String str) {
        if (ctx == null || str == null) {
            return;
        }
        show(ctx, str, Toast.LENGTH_LONG);
    }

    public static void showLong(Context ctx, @StringRes int strRes, @Nullable Object[] strArgs) {
        if (ctx == null ) {
            return;
        }
        show(ctx, strRes, strArgs, Toast.LENGTH_LONG);
    }


    private static void show(Context ctx, @StringRes int strRes, @Nullable Object[] strArgs, int toastDuration) {

        String txt = "";

        if (strArgs != null && strArgs.length > 0) {
            txt = StringUtils.getStringSaftely(ctx, strRes, strArgs);
        } else {
            txt = StringUtils.getStringSaftely(ctx, strRes);
        }

        show(ctx, txt, toastDuration);

    }

    private static void show(Context ctx, String str, int toastDuration) {
        Toast.makeText(ctx, StringUtils.getStringSaftely(str), toastDuration).show();
    }

}
