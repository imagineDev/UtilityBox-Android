package com.imaginedev.utilitybox.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by batman on 28/02/18.
 */

public final class ClipboardUtils {

    /**
     * Copies the provided string to the clipboard
     *
     * @return boolean - true is copied successfully - false is some issue in copying.
     */
    public static boolean copyToClipboard(@NonNull Context context, @Nullable String text) {
        if (!TextUtils.isEmpty(text) && context != null) {
            try {
                int sdk = android.os.Build.VERSION.SDK_INT;
                if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context
                            .getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboard.setText(text);
                } else {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context
                            .getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData
                            .newPlainText(
                                    "Copied Text", text);
                    clipboard.setPrimaryClip(clip);
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @return text from clipboard, it may return null
     */
    @Nullable
    public static CharSequence getTextFromClipboard(Context ctx) {
        ClipboardManager clipboard = (ClipboardManager) ctx.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = clipboard.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            return clip.getItemAt(0).coerceToText(ctx);
        }
        return null;
    }


}
