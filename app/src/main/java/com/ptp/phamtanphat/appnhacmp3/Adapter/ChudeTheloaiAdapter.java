package com.ptp.phamtanphat.appnhacmp3.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.appnhacmp3.Model.Theloaitrongngay;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Tan Phat on 1/8/2018.
 */

public class ChudeTheloaiAdapter extends PagerAdapter {
    Context context;
    ArrayList<Theloaitrongngay> theloaitrongngayArrayList;

    public ChudeTheloaiAdapter(Context context, ArrayList<Theloaitrongngay> theloaitrongngayArrayList) {
        this.context = context;
        this.theloaitrongngayArrayList = theloaitrongngayArrayList;
    }

    @Override
    public int getCount() {
        return theloaitrongngayArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_the_loai_trong_ngay,null);

        ImageView imgchudetheloai = view.findViewById(R.id.imageviewtheloaitrongngay);
        TextView txttenchudetheloai = view.findViewById(R.id.textviewtenchudetheloaitrongngay);


            Picasso.with(context).load(theloaitrongngayArrayList.get(position).getChuDe().get(position).getHinhChuDe()).into(imgchudetheloai);
            txttenchudetheloai.setText(theloaitrongngayArrayList.get(position).getChuDe().get(position).getTenChuDe());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
