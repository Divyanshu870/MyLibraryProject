package com.asus.mylibrary;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.asus.mylibrary.managers.PrefManager;

/**
 * @author Jaypatelbond created on 06-03-2020.
 */

public class MyLibraryApplication extends MultiDexApplication {
    public static Context context;
    private static MyLibraryApplication mInstance;

    public static Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        MyLibraryApplication.context = context;
    }

    public static synchronized MyLibraryApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        PrefManager.initInstance(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        MultiDex.install(this);

    }
}
