package com.ptp.phamtanphat.appnhacmp3.Fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import com.ptp.phamtanphat.appnhacmp3.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Dell on 2/16/2018.
 */

public class Fragment_Dia_Nhac extends Fragment {
    View view;
    CircleImageView circleImageView;
    ObjectAnimator imageviewobjectanimator;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dia_nhac,container,false);
        circleImageView = view.findViewById(R.id.imageviewcirclemp3);
        imageviewobjectanimator = ObjectAnimator.ofFloat(circleImageView,
                "rotation", 0f, 360f);
        imageviewobjectanimator.setDuration(10000);
        imageviewobjectanimator.setRepeatCount(ValueAnimator.INFINITE);
        imageviewobjectanimator.setRepeatMode(ValueAnimator.RESTART);
        imageviewobjectanimator.setInterpolator(new LinearInterpolator());
        return view;
    }
    public void PlayDiaNhac(String hinhanh){
        Picasso.with(getActivity()).load(hinhanh).into(circleImageView);
        imageviewobjectanimator.start();
    }
    public void PauseDiaNhac(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            imageviewobjectanimator.pause();
        }
    }
    public void ResumeDiaNhac(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            imageviewobjectanimator.resume();
        }
    }
    public void SetImageCirCle(String hinhanh){
        Picasso.with(getActivity()).load(hinhanh).into(circleImageView);
    }
    public void NextOrPreDiaNhac(String hinhanh){
        if (imageviewobjectanimator != null){
            imageviewobjectanimator.cancel();
            imageviewobjectanimator.start();
            SetImageCirCle(hinhanh);
        }else {
            imageviewobjectanimator.start();
            SetImageCirCle(hinhanh);
        }
    }

}
