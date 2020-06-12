package com.asus.mylibrary.adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.asus.mylibrary.fragments.FavouritesFragment;
import com.asus.mylibrary.fragments.MyBooksFragment;
import com.asus.mylibrary.fragments.ReadHistoryFragment;


public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    int totalTabs;

    // Tab Titles
    private String[] tabTitles = new String[]{"My Books", "Recent Reads", "Favourites"};

    public TabsPagerAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    // Showing the Fragments in the Tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MyBooksFragment();
            case 1:
                return new ReadHistoryFragment();
            case 2:
                return new FavouritesFragment();
            default:
                return null;
        }
    }

    //Overiding to get the Page Title
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    // Counts the total number of tabs. Can get the count by tabTitles.length also.
    @Override
    public int getCount() {
        return totalTabs;
    }
}