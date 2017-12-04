package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ptp.phamtanphat.appnhacmp3.Adapter;
import com.ptp.phamtanphat.appnhacmp3.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by KhoaPhamPC on 20/11/2017.
 */

public class Fragment_Banner extends android.app.Fragment {

    View view;
    ViewPager viewPager;
    Adapter adapter;
    CircleIndicator circleIndicator;
    ArrayList<Integer> manginh = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner,container,false);

        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefault);
        manginh.add(R.drawable.cat);
        manginh.add(R.drawable.cow);
        manginh.add(R.drawable.dog);
        manginh.add(R.drawable.iconfish);
        manginh.add(R.drawable.iconpenguin);
        adapter = new Adapter(getActivity(),manginh);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
        return view;
    }
}
