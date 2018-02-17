package com.ptp.phamtanphat.appnhacmp3.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Dell on 2/16/2018.
 */

public class ViewPagerPlaylistnhac extends FragmentPagerAdapter {
    public final ArrayList<Fragment> arrayFragment = new ArrayList<>();

    public ViewPagerPlaylistnhac(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFragment.get(position);
    }

    public void AddFragment(Fragment fragment){
        arrayFragment.add(fragment);
    }
    @Override
    public int getCount() {
        return arrayFragment.size();
    }
}
