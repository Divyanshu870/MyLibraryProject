package com.asus.mylibrary.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;

import androidx.annotation.RequiresApi;

import com.afollestad.materialdialogs.MaterialDialog;
import com.asus.mylibrary.R;
import com.asus.mylibrary.utils.Utils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

/**
 * @author Jaypatelbond created on 06-03-2020.
 */

public class SplashActivity extends BaseActivity {
    private static final long SPLASH_TIME_OUT = 2500;
    RxPermissions rxPermissions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initPermissions();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start your app main activity
                startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @SuppressLint("CheckResult")
    private void initPermissions() {
        rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        // All requested permissions are granted
                    } else {

                        // Making an Alert Dialog for permissions of Storage
                        Utils.showOkCancelAlertDialog(this, getString(R.string.settings), getString(R.string.exit),
                                getString(R.string.app_name), "My Library requires permissions to continue",
                                new MaterialDialog.ButtonCallback() {
                                    @Override
                                    public void onPositive(MaterialDialog dialog) {
                                        Intent intent = new Intent();
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                                        intent.setData(uri);
                                        startActivity(intent);
                                    }

                                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                    @Override
                                    public void onNegative(MaterialDialog dialog) {
                                        //Closing the app if "exit" selected
                                        finishAffinity();
                                    }
                                });
                    }
                });
    }

}
