package com.asus.mylibrary.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.asus.mylibrary.MyLibraryApplication;

/**
 * @author Jaypatelbond created on 06-03-2020.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyLibraryApplication) getApplication()).setContext(this);

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}