package com.ptp.phamtanphat.appnhacmp3.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.ptp.phamtanphat.appnhacmp3.Model.ChuDe;
import com.ptp.phamtanphat.appnhacmp3.Model.TheLoai;
import com.ptp.phamtanphat.appnhacmp3.Model.Theloaitrongngay;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;
import com.squareup.picasso.Picasso;

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
    HorizontalScrollView horizontalScrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai_today,container,false);

        relativeLayoutchudetheloai = view.findViewById(R.id.relativechudetheloai);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);

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

                ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                chuDeArrayList.addAll(theloaitrongngay.getChuDe());

                ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
                theLoaiArrayList.addAll(theloaitrongngay.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                for (int i = 0 ; i<(chuDeArrayList.size());i++){
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(getActivity()).load(chuDeArrayList.get(i).getHinhChuDe()).into(imageView);
                    linearLayout.addView(imageView);
                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<Theloaitrongngay> call, Throwable t) {

            }
        });
    }
}
