package com.imaginedev.utilitybox.messages;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.imaginedev.utilitybox.string.StringUtils;

/**
 * Provides a method to show a Snackbar.
 */
public final class SnackbarUtils {

    public static void showShort(View v, String snackbarText) {
        if (v == null || snackbarText == null) {
            return;
        }
        show(v, snackbarText, Snackbar.LENGTH_SHORT, null);

    }

    public static void showShort(View v, @StringRes int strRes, @Nullable Object[] strArgs) {
        if (v == null) {
            return;
        }
        show(v, strRes, strArgs, Snackbar.LENGTH_SHORT, null);

    }

    public static void showShort(Activity v, String snackbarText) {
        if (v == null || snackbarText == null) {
            return;
        }

        View view = v.findViewById(android.R.id.content);

        if (view != null) {
            show(view, snackbarText, Snackbar.LENGTH_SHORT, null);
        }

    }

    public static void showShort(Activity v, @StringRes int strRes, @Nullable Object[] strArgs) {
        if (v == null) {
            return;
        }

        View view = v.findViewById(android.R.id.content);

        if (view != null) {
            show(view, strRes, strArgs, Snackbar.LENGTH_SHORT, null);
        }

    }

    public static void showShort(Fragment v, String snackbarText) {
        if (v == null || snackbarText == null || v.getView() == null) {
            return;
        }

        show(v.getView(), snackbarText, Snackbar.LENGTH_SHORT, null);

    }

    public static void showShort(Fragment v, @StringRes int strRes, @Nullable Object[] strArg) {
        if (v == null || v.getView() == null) {
            return;
        }

        show(v.getView(), strRes, strArg, Snackbar.LENGTH_SHORT, null);

    }

    public static void showLong(View v, String snackbarText) {
        if (v == null || snackbarText == null) {
            return;
        }
        show(v, snackbarText, Snackbar.LENGTH_LONG, null);

    }

    public static void showLong(View v, @StringRes int strRes, @Nullable Object[] strArgs) {
        if (v == null) {
            return;
        }
        show(v, strRes, strArgs, Snackbar.LENGTH_LONG, null);

    }

    public static void showLong(Activity v, String snackbarText) {
        if (v == null || snackbarText == null) {
            return;
        }

        View view = v.findViewById(android.R.id.content);

        if (view != null) {
            show(view, snackbarText, Snackbar.LENGTH_LONG, null);
        }

    }

    public static void showLong(Activity v, @StringRes int strRes, @Nullable Object[] strArgs) {
        if (v == null) {
            return;
        }

        View view = v.findViewById(android.R.id.content);

        if (view != null) {
            show(view, strRes, strArgs, Snackbar.LENGTH_LONG, null);
        }

    }

    public static void showLong(Fragment v, String snackbarText) {
        if (v == null || snackbarText == null || v.getView() == null) {
            return;
        }

        show(v.getView(), snackbarText, Snackbar.LENGTH_LONG, null);

    }

    public static void showLong(Fragment v, @StringRes int strRes, @Nullable Object[] strArg) {
        if (v == null || v.getView() == null) {
            return;
        }

        show(v.getView(), strRes, strArg, Snackbar.LENGTH_LONG, null);

    }

    public static void showIndefinite(View v, String snackbarText, @Nullable View.OnClickListener listener) {
        if (v == null || snackbarText == null) {
            return;
        }
        show(v, snackbarText, Snackbar.LENGTH_INDEFINITE, listener);

    }

    public static void showIndefinite(View v, @StringRes int strRes, @Nullable Object[] strArgs, @Nullable View.OnClickListener listener) {
        if (v == null) {
            return;
        }
        show(v, strRes, strArgs, Snackbar.LENGTH_INDEFINITE, listener);

    }

    public static void showIndefinite(Activity v, String snackbarText, @Nullable View.OnClickListener listener) {
        if (v == null || snackbarText == null) {
            return;
        }

        View view = v.findViewById(android.R.id.content);

        if (view != null) {
            show(view, snackbarText, Snackbar.LENGTH_INDEFINITE, listener);
        }

    }

    public static void showIndefinite(Activity v, @StringRes int strRes, @Nullable Object[] strArgs, @Nullable View.OnClickListener listener) {
        if (v == null) {
            return;
        }

        View view = v.findViewById(android.R.id.content);

        if (view != null) {
            show(view, strRes, strArgs, Snackbar.LENGTH_INDEFINITE, listener);
        }

    }

    public static void showIndefinite(Fragment v, String snackbarText, @Nullable View.OnClickListener listener) {
        if (v == null || snackbarText == null || v.getView() == null) {
            return;
        }

        show(v.getView(), snackbarText, Snackbar.LENGTH_INDEFINITE, listener);

    }

    public static void showIndefinite(Fragment v, @StringRes int strRes, @Nullable Object[] strArg, @Nullable View.OnClickListener listener) {
        if (v == null || v.getView() == null) {
            return;
        }

        show(v.getView(), strRes, strArg, Snackbar.LENGTH_INDEFINITE, listener);

    }


    private static void show(@NonNull View v, String snackbarText, int snackBarDuration, @Nullable View.OnClickListener listener) {
        Snackbar sb = build(v, snackbarText, snackBarDuration);
        if (sb != null) {
            if (listener != null) {
                sb.setAction("OK", listener);
            }
            sb.show();
        }
    }

    private static void show(@NonNull View v, @StringRes int strRes, @Nullable Object[] strArgs, int snackBarDuration, @Nullable View.OnClickListener listener) {
        Snackbar sb = build(v, strRes, strArgs, snackBarDuration);
        if (sb != null) {
            if (listener != null) {
                sb.setAction("OK", listener);
            }
            sb.show();
        }

    }


    public static Snackbar build(@NonNull View v, @StringRes int strRes, @Nullable Object[] strArgs, int snackBarDuration) {

        Context ctx = v.getContext();
        String str = "";

        if (strArgs != null && strArgs.length > 0) {
            str = StringUtils.getStringSaftely(ctx, strRes, strArgs);
        } else {
            str = StringUtils.getStringSaftely(ctx, strRes);
        }

        return build(v, str, snackBarDuration);

    }

    public static Snackbar build(@NonNull View v, String snackbarText, int snackBarDuration) {
        String str = StringUtils.getStringSaftely(snackbarText);

        Snackbar snackbar = Snackbar.make(v, snackbarText, snackBarDuration);

        if (str.length() > 25) {
            if (snackbar != null) {
                View snackBarView = snackbar.getView();
                if (snackBarView != null) {
                    TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                    if (textView != null) {
                        textView.setSingleLine(false);
                        textView.setMaxLines(6);  // show multiple line
                    }
                }
            }

        }

        return snackbar;

    }

}