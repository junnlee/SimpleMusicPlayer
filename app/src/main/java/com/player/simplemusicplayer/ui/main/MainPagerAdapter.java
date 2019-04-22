package com.player.simplemusicplayer.ui.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.player.simplemusicplayer.ui.base.BaseFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles;
    private BaseFragment[] fragments;

    public MainPagerAdapter(FragmentManager fm, String[] titles, BaseFragment[] fragments) {
        super(fm);
        this.mTitles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        if (mTitles == null) return 0;
        return mTitles.length;
    }




}
