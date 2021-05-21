package com.hihasan.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class LoadingDialog {
    private Context context;
    private ProgressDialog progressDialog;

    public LoadingDialog(Context context) {
        this.context = context;
    }

    //different type of method is available for alert dialog

    public void showProgressDialog() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    public void showProgressDialog(String msg) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    public void dismissProgress(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }


    public void showDialogYesNo(String msg, DialogInterface.OnClickListener yesListener, DialogInterface.OnClickListener noListener) {
        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(context);
        dialog.setMessage(msg);
        dialog.setCancelable(false);
        dialog.setPositiveButton(R.string.yes, yesListener);
        dialog.setNegativeButton(R.string.no,noListener);
        dialog.show();
    }
}
