package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ptp.phamtanphat.appnhacmp3.Adapter.BannerAdapter;
import com.ptp.phamtanphat.appnhacmp3.Model.Banner;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KhoaPhamPC on 20/11/2017.
 */

public class Fragment_Banner extends android.app.Fragment {

    View view;
    ViewPager viewPager;
    BannerAdapter bannerAdapter;
    CircleIndicator circleIndicator;
    ArrayList<Banner> mangbanner = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner,container,false);

        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefault);
        GetData();
        bannerAdapter = new BannerAdapter(getActivity(),mangbanner);
        viewPager.setAdapter(bannerAdapter);
        circleIndicator.setViewPager(viewPager);
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Banner>> listbanner = dataservice.GetDataBanner();
        listbanner.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                ArrayList<Banner> banners = (ArrayList<Banner>) response.body();
                mangbanner.addAll(banners);
                bannerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {

            }
        });
    }
}
