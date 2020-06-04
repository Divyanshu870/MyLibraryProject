package com.asus.mylibrary.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.asus.mylibrary.R;
import com.asus.mylibrary.adapters.TabsPagerAdapter;
import com.asus.mylibrary.utils.SearchDocument;
import com.asus.mylibrary.utils.StorageUtil;
import com.asus.mylibrary.utils.Utils;
import com.google.android.material.tabs.TabLayout;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Jaypatelbond created on 06-03-2020.
 */

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.toolbarMyBooking)
    Toolbar toolbarMyBooking;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerHome)
    ViewPager viewPagerHome;
    private TabsPagerAdapter mAdapter;
    RxPermissions rxPermissions;
    private File storage;
    private String[] storagePaths;

    @SuppressLint("CheckResult")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViewPager();

    }

    private void initViewPager() {
        // Setting the text titles for the tab
        tabLayout.addTab(tabLayout.newTab().setText("My Books"));
        tabLayout.addTab(tabLayout.newTab().setText("Recent Reads"));
        tabLayout.addTab(tabLayout.newTab().setText("Favourites"));

        //Setting the TabsPagerAdapter
        mAdapter = new TabsPagerAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPagerHome.setAdapter(mAdapter);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPagerHome);


         /*
          on swiping the viewpager makes respective tab selected
        */
        viewPagerHome.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerHome.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}