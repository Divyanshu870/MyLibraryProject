package com.asus.mylibrary.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.asus.mylibrary.R;

/**
 * @author Jaypatelbond created on 06-03-2020.
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}