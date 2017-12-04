package com.ptp.phamtanphat.appnhacmp3;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by KhoaPhamPC on 20/11/2017.
 */

public class Adapter extends PagerAdapter {
    Context context;
    ArrayList<Integer> manghinh;

    public Adapter(Context context, ArrayList<Integer> manghinh) {
        this.context = context;
        this.manghinh = manghinh;
    }

    @Override
    public int getCount() {
        return manghinh.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);
        img = view.findViewById(R.id.imageviewhinh);
        img.setImageResource(manghinh.get(position));
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
       container.removeView((View) object);

    }
}
