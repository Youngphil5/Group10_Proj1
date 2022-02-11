package com.daclink.drew.sp22.cst438_project01_starter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.daclink.drew.sp22.cst438_project01_starter.R;

public class LoadingActivity {
    Activity activity;
    AlertDialog diaglog;

    void LoadingDialog(Activity myActivity){
        activity = myActivity;
    }

    void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(true);

        diaglog = builder.create();
        diaglog.show();
    }

    void dismissDialog(){
        diaglog.dismiss();
    }
}
