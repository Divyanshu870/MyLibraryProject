package com.asus.mylibrary.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.asus.mylibrary.R;
import com.asus.mylibrary.adapters.TabsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Jaypatelbond created on 06-03-2020.
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.toolbarMyBooking)
    Toolbar toolbarMyBooking;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerHome)
    ViewPager viewPagerHome;
    private TabsPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tabLayout.addTab(tabLayout.newTab().setText("My Books"));
        tabLayout.addTab(tabLayout.newTab().setText("Read History"));
        tabLayout.addTab(tabLayout.newTab().setText("Favourites"));

        mAdapter = new TabsPagerAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPagerHome.setAdapter(mAdapter);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPagerHome);

        initViewPager();

    }

    private void initViewPager() {
         /*
          on swiping the viewpager make respective tab selected
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