package com.asus.mylibrary.utils;

import android.app.Activity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.asus.mylibrary.R;

/**
 * @author Jaypatelbond created on 31-05-2020.
 */

public class Utils {

    public static MaterialDialog showOkCancelAlertDialog(Activity activity, String ok, String cancel, String title, String message, final MaterialDialog.ButtonCallback materialDialogCallback) {
        if (!activity.isFinishing()) {
            MaterialDialog alertDialog = new MaterialDialog.Builder(activity)
                    .title(title)
                    .content(message)
                    .negativeText(cancel)
                    .positiveText(ok)
                    .cancelable(false)
                    .positiveColor(activity.getResources().getColor(R.color.colorPrimary))
                    .callback(materialDialogCallback).build();
            alertDialog.show();
            return alertDialog;
        } else {
            return null;
        }
    }
}
