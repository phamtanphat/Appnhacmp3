package com.ptp.phamtanphat.appnhacmp3.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ptp.phamtanphat.appnhacmp3.Adapter.ChudeTheloaiAdapter;
import com.ptp.phamtanphat.appnhacmp3.Model.Theloaitrongngay;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tan Phat on 1/6/2018.
 */

public class Fragment_ChuDe_TheLoai_ToDay extends Fragment {

    View view;
    RelativeLayout relativeLayoutchudetheloai;
    ViewPager viewPager;
    ChudeTheloaiAdapter chudeTheloaiAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai_today,container,false);

        relativeLayoutchudetheloai = view.findViewById(R.id.relativechudetheloai);
        viewPager = view.findViewById(R.id.viewpagerchudetheloai);

        GetData();
        return view;
    }
    public void GetData(){
        Dataservice dataservice = APIService.getService();
        Call<Theloaitrongngay> theloaitrongngayCall = dataservice.GetCategoryMusic();
        theloaitrongngayCall.enqueue(new Callback<Theloaitrongngay>() {
            @Override
            public void onResponse(Call<Theloaitrongngay> call, Response<Theloaitrongngay> response) {
                Theloaitrongngay theloaitrongngay = response.body();
                ArrayList<Theloaitrongngay> theloaitrongngayArrayList = new ArrayList<>();
                theloaitrongngayArrayList.add(theloaitrongngay);
                chudeTheloaiAdapter = new ChudeTheloaiAdapter(getActivity(),theloaitrongngayArrayList);
                viewPager.setAdapter(chudeTheloaiAdapter);
            }

            @Override
            public void onFailure(Call<Theloaitrongngay> call, Throwable t) {

            }
        });
    }
}
