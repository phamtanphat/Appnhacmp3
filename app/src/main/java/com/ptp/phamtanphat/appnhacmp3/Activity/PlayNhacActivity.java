package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ptp.phamtanphat.appnhacmp3.Adapter.PlayNhacadapter;
import com.ptp.phamtanphat.appnhacmp3.Adapter.PlaylistAdapter;
import com.ptp.phamtanphat.appnhacmp3.Adapter.ViewPagerPlaylistnhac;
import com.ptp.phamtanphat.appnhacmp3.Fragment.Fragment_Dia_Nhac;
import com.ptp.phamtanphat.appnhacmp3.Fragment.Fragment_Play_Danh_Sach_Cac_Bai_Hat;
import com.ptp.phamtanphat.appnhacmp3.Model.Baihat;
import com.ptp.phamtanphat.appnhacmp3.R;

import java.io.IOException;
import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class PlayNhacActivity extends AppCompatActivity {

    Baihat baihat;
    public static ArrayList<Baihat> mangbaihat = new ArrayList<>();
    public static Toolbar toolbarplaynhac;
    CircleIndicator circleIndicatorplaynhac;
    TextView txtTimeSong, txtTotalTime;
    SeekBar sktime;
    ImageButton imgplay, imgrepeat, imgnext, imgpre, imgrandom;
    ViewPager viewPagerPlaylistnhac;
    public static ViewPagerPlaylistnhac adapterpager;
    Fragment_Dia_Nhac fragment_dia_nhac;
    int position = 0;
    Fragment_Play_Danh_Sach_Cac_Bai_Hat fragment_play_danh_sach_cac_bai_hat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        Anhxa();
        GetdatafromIntent();
        init();
        eventPlay();

    }

    private void eventPlay() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (fragment_dia_nhac.isInLayout()) {
                    if (baihat != null && baihat.getHinhbaihat().length() > 0) {
                        fragment_dia_nhac.PlayDiaNhac(baihat.getHinhbaihat());
                    }
                    if (mangbaihat.size() > 0) {
                        fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(0).getHinhbaihat());
                    }
                }
            }
        }, 1000);

        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baihat != null && baihat.getHinhbaihat().length() > 0) {
                    fragment_dia_nhac.PlayDiaNhac(baihat.getHinhbaihat());
                }
                if (mangbaihat.size() > 0) {
                    fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(0).getHinhbaihat());
                }

            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (baihat != null && baihat.getHinhbaihat().length() > 0) {
                    fragment_dia_nhac.NextOrPreDiaNhac(baihat.getHinhbaihat());
                    fragment_dia_nhac.PlayDiaNhac(baihat.getHinhbaihat());
                    getSupportActionBar().setTitle(baihat.getTenbaihat());
                }
                if (mangbaihat.size() > 0) {

                    if (position < (mangbaihat.size() - 1)) {
                        position += 1;
                        fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(position).getHinhbaihat());
                        fragment_dia_nhac.NextOrPreDiaNhac(mangbaihat.get(position).getHinhbaihat());
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                    } else {
                        Toast.makeText(PlayNhacActivity.this, "Hết bài hát để chuyển!!", Toast.LENGTH_SHORT).show();
                        Log.d("BBB", "Mã " + position);
                    }

                }

            }
        });
        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baihat != null && baihat.getHinhbaihat().length() > 0) {
                    fragment_dia_nhac.NextOrPreDiaNhac(baihat.getHinhbaihat());
                    fragment_dia_nhac.PlayDiaNhac(baihat.getHinhbaihat());
                    getSupportActionBar().setTitle(baihat.getTenbaihat());
                }
                if (mangbaihat.size() > 0) {

                    if (position > 0) {
                        position = position - 1;
                        if (position == -1) {
                            fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(0).getHinhbaihat());
                            fragment_dia_nhac.NextOrPreDiaNhac(mangbaihat.get(0).getHinhbaihat());
                            getSupportActionBar().setTitle(mangbaihat.get(0).getTenbaihat());
                        } else {
                            fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(position).getHinhbaihat());
                            fragment_dia_nhac.NextOrPreDiaNhac(mangbaihat.get(position).getHinhbaihat());
                            getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                        }
                    } else {
                        Toast.makeText(PlayNhacActivity.this, "Hết bài hát để chuyển!!", Toast.LENGTH_SHORT).show();
                        Log.d("BBB", "Pre" + position + "");
                    }

                }
            }
        });

    }

    private void init() {
        fragment_dia_nhac = new Fragment_Dia_Nhac();
        fragment_play_danh_sach_cac_bai_hat = new Fragment_Play_Danh_Sach_Cac_Bai_Hat();

        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);
        if (baihat != null) {
            getSupportActionBar().setTitle(baihat.getTenbaihat());
        }
        if (mangbaihat.size() > 0) {
            getSupportActionBar().setTitle(mangbaihat.get(0).getTenbaihat());
        }

        adapterpager = new ViewPagerPlaylistnhac(getSupportFragmentManager());
        adapterpager.AddFragment(fragment_play_danh_sach_cac_bai_hat);
        adapterpager.AddFragment(fragment_dia_nhac);
        viewPagerPlaylistnhac.setAdapter(adapterpager);
        circleIndicatorplaynhac.setViewPager(viewPagerPlaylistnhac);
        fragment_dia_nhac = (Fragment_Dia_Nhac) adapterpager.getItem(1);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (baihat != null) {
                    if (baihat.getHinhbaihat().length() > 0) {
                        fragment_dia_nhac.PlayDiaNhac(baihat.getHinhbaihat());
                        handler.removeCallbacks(this);
                    } else {
                        handler.postDelayed(this, 200);
                    }
                }

                if (mangbaihat.size() > 0 && mangbaihat.get(0).getHinhbaihat().length() > 0) {
                    fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(0).getHinhbaihat());
                    handler.removeCallbacks(this);
                } else {
                    handler.postDelayed(this, 200);
                }


            }
        }, 200);


    }

    private void Anhxa() {
        circleIndicatorplaynhac = findViewById(R.id.circleindicatorplaynhac);
        toolbarplaynhac = findViewById(R.id.toolbarplaynhac);
        viewPagerPlaylistnhac = findViewById(R.id.viewpagerplay);
        txtTimeSong = findViewById(R.id.textviewtimesong);
        txtTotalTime = findViewById(R.id.textviewtotaltimesong);
        sktime = findViewById(R.id.seekbarsong);
        imgplay = findViewById(R.id.imagebuttonplay);
        imgrepeat = findViewById(R.id.imagebuttonrepeat);
        imgnext = findViewById(R.id.imagebuttonnext);
        imgpre = findViewById(R.id.imagebuttonpre);
        imgrandom = findViewById(R.id.imagebuttonsuffle);
    }

    private void GetdatafromIntent() {
        Intent intent = getIntent();
        mangbaihat.clear();
        if (intent != null) {
            if (intent.hasExtra("cakhuc")) {
                baihat = intent.getParcelableExtra("cakhuc");
                mangbaihat.add(baihat);
            }
            if (intent.hasExtra("cacbaihat")) {
                ArrayList<Baihat> arraybaihat = intent.getParcelableArrayListExtra("cacbaihat");
                Log.d("BBB", arraybaihat.size() + "");
                mangbaihat = arraybaihat;
            }
        }
    }

    public void PlayNhacMp3(String url) {
        //url = "http://khoapham.vn/download/vietnamoi.mp3";
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
