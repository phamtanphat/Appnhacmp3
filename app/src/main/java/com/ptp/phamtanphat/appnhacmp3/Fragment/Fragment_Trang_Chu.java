package com.ptp.phamtanphat.appnhacmp3.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ptp.phamtanphat.appnhacmp3.R;

/**
 * Created by Dell on 2/14/2018.
 */

public class Fragment_Trang_Chu extends android.support.v4.app.Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_trang_chu,container,false);
        return view;
    }
}
