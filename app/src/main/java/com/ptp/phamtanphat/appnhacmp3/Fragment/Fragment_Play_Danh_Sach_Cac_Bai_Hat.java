package com.ptp.phamtanphat.appnhacmp3.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ptp.phamtanphat.appnhacmp3.Activity.PlayNhacActivity;
import com.ptp.phamtanphat.appnhacmp3.Adapter.PlayNhacadapter;
import com.ptp.phamtanphat.appnhacmp3.R;

/**
 * Created by Dell on 2/16/2018.
 */

public class Fragment_Play_Danh_Sach_Cac_Bai_Hat extends Fragment {

    View view;
    RecyclerView recyclerViewplaynhac;
    PlayNhacadapter playNhacadapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danh_sach_cac_bat_hat,container,false);
        recyclerViewplaynhac = view.findViewById(R.id.recyclerviewPlayBaihat);
        if (PlayNhacActivity.mangbaihat.size() >0){

            playNhacadapter = new PlayNhacadapter(getActivity(),PlayNhacActivity.mangbaihat,PlayNhacActivity.toolbarplaynhac);
            recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaynhac.setAdapter(playNhacadapter);
        }
        return view;
    }
}
