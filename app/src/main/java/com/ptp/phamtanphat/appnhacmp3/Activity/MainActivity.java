package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ptp.phamtanphat.appnhacmp3.Adapter.MainViewPagerAdapter;
import com.ptp.phamtanphat.appnhacmp3.Fragment.Fragment_Tim_Kiem;
import com.ptp.phamtanphat.appnhacmp3.Fragment.Fragment_Trang_Chu;
import com.ptp.phamtanphat.appnhacmp3.R;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        intit();


    }

    private void intit() {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragmentTitle(new Fragment_Trang_Chu(), "Trang Chủ");
        adapter.addFragmentTitle(new Fragment_Tim_Kiem(), "Tìm Kiếm");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);
    }

    private void Anhxa() {
        tabLayout = findViewById(R.id.myTablayout);
        viewPager = findViewById(R.id.myViewpager);
    }
}
