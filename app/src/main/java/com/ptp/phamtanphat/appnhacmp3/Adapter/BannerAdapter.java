package com.ptp.phamtanphat.appnhacmp3.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.appnhacmp3.Model.Banner;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by KhoaPhamPC on 20/11/2017.
 */

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Banner> arrayListbanner;

    public BannerAdapter(Context context, ArrayList<Banner> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @Override
    public int getCount() {
        return arrayListbanner.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);

        ImageView imgbackgroundbanner = view.findViewById(R.id.imageviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        ImageView imgplaybanner = view.findViewById(R.id.imageviewplaybanner);
        TextView txttitlesongbanner = view.findViewById(R.id.textvewtitlebannerbaihat);
        TextView txtlyricsongbanner = view.findViewById(R.id.textviewloibaihatbanner);

        Picasso.with(context).load(arrayListbanner.get(position).getHinhBaiHat()).into(imgbackgroundbanner);
        Picasso.with(context).load(arrayListbanner.get(position).getHinhBaiHat()).into(imgsongbanner);
        txtlyricsongbanner.setText(arrayListbanner.get(position).getLoiBaiHat());
        txttitlesongbanner.setText(arrayListbanner.get(position).getTenBaiHat());
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
       container.removeView((View) object);

    }
}
