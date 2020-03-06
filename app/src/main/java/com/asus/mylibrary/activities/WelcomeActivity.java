package com.asus.mylibrary.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.asus.mylibrary.R;
import com.asus.mylibrary.adapters.WelcomeViewPagerAdapter;
import com.asus.mylibrary.managers.PrefManager;
import com.asus.mylibrary.utils.InkPageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Jaypatelbond created on 06-03-2020.
 */

public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = "WelcomeActivity";
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    InkPageIndicator indicator;
    @BindView(R.id.layoutDots)
    LinearLayout layoutDots;
    @BindView(R.id.buttonNext)
    Button buttonNext;
    @BindView(R.id.buttonSkip)
    Button buttonSkip;
    private int[] layouts;
    private WelcomeViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check first time launch.
        if (!PrefManager.getInstance().isWelcomeFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        buttonSkip.setOnClickListener(v -> launchHomeScreen());
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });

        layouts = new int[]{
                R.layout.slide1,
                R.layout.slide2,
        };

        changeStatusBarColor();

        viewPagerAdapter = new WelcomeViewPagerAdapter(layouts, this);
        viewPager.setAdapter(viewPagerAdapter);
        indicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // changing the next button text 'NEXT' --> "",  'Get Started'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                buttonNext.setText(getString(R.string.start));
                buttonNext.setOnClickListener(v -> launchHomeScreen());
                buttonSkip.setVisibility(View.GONE);
                indicator.setVisibility(View.GONE);
            } else {
                // still pages are left
                buttonNext.setText(getString(R.string.next));
                buttonNext.setVisibility(View.VISIBLE);
                indicator.setVisibility(View.VISIBLE);
                buttonSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    //Sending to Different Activities if not logged in
    private void launchHomeScreen() {
        PrefManager.getInstance().setWelcomeFirstTimeLaunch(false);
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }
}
