package com.techgigandroidhackathon.Utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Amol G on 01-12-2017.
 */

public class ApplicationUtils {
    private static ProgressDialog progressDialog;

    /**
     * Show progress dialog
     *
     * @param context
     * @param title
     * @param message
     */
    static public void showProgressDialog(Context context, String title, String message) {
        if (null == progressDialog) {
            progressDialog = new ProgressDialog(context);
        }
        if (progressDialog.isShowing()) {
            return;
        }
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    /**
     * Cancel progress dialog
     */
    public static void cancelProgressDialog() {
        if (null == progressDialog) {
            return;
        }
        if (!progressDialog.isShowing()) {
            return;
        }
        progressDialog.dismiss();
    }
}
