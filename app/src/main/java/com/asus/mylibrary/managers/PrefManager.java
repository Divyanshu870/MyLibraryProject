package com.asus.mylibrary.managers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Jaypatelbond created on 06-03-2020.
 */

public class PrefManager {
    public static final String KEY_PREFS_NAME = "PREFS";
    private static PrefManager instance;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;
    public static final String IS_WELCOME_FIRST_TIME_LAUNCH = "IS_WELCOME_FIRST_TIME_LAUNCH";

    @SuppressLint("CommitPrefEdits")
    public PrefManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(KEY_PREFS_NAME, PRIVATE_MODE);
        editor = pref.edit();

    }

    public static void initInstance(Context context) {
        instance = new PrefManager(context);
    }

    public static PrefManager getInstance() {
        return instance;
    }

    public void clearAll() {
        editor.clear().commit();
    }

    //Welcome page first launch check to prefs.
    public boolean isWelcomeFirstTimeLaunch() {
        return pref.getBoolean(IS_WELCOME_FIRST_TIME_LAUNCH, true);
    }

    public void setWelcomeFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_WELCOME_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }
}
