package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.StrictMode;
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
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

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
    ArrayList<Baihat> arraybaihat;
    Fragment_Dia_Nhac fragment_dia_nhac;
    int position = 0;
    Fragment_Play_Danh_Sach_Cac_Bai_Hat fragment_play_danh_sach_cac_bai_hat;
    MediaPlayer mediaPlayer = new MediaPlayer();
    boolean repeat = false;
    boolean checkrandom = false;
    boolean nextbaihat = false;

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
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapterpager.getItem(1) != null) {
                    if (mangbaihat.size() > 0) {
                        fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(0).getHinhbaihat());
                        imgplay.performClick();
                        handler.removeCallbacks(this);
                    }
                } else {
                    handler.postDelayed(this, 100);
                }

            }
        }, 500);

        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imgplay.setImageResource(R.drawable.iconplay);
                } else {
                    if (mediaPlayer.isLooping()) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                    }
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.iconpause);
                }
                TimeSong();
                UpdateTime();


            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mangbaihat.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer.isLooping() || mediaPlayer != null || mediaPlayer == null) {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                        }
                    }
                    if (position < (mangbaihat.size())) {
                        position++;

                        if (position > (mangbaihat.size() - 1)) {
                            position = 0;
                        }

                        if (repeat == true) {
                            position -= 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if (index == position) {
                                position = index - 1;
                            }
                            position = index;

                        }

                        mediaPlayer = new MediaPlayer();
                        PlayNhacMp3(mangbaihat.get(position).getLinkbaihat());
                        imgplay.setImageResource(R.drawable.iconpause);
                        fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(position).getHinhbaihat());
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                        UpdateTime();
                        imgpre.setClickable(false);
                        imgnext.setClickable(false);
                        Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imgnext.setClickable(true);
                                imgpre.setClickable(true);
                            }
                        },5000);
                    }

                }
            }
        });
        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mangbaihat.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer.isLooping() || mediaPlayer != null || mediaPlayer == null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                    }
                    if (position < (mangbaihat.size())) {
                        position--;
                        if (position < 0) {
                            position = mangbaihat.size() - 1;
                        }
                        if (repeat == true) {
                            position += 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if (index == position) {
                                position = index - 1;
                            }
                            position = index;

                        }
                        mediaPlayer = new MediaPlayer();
                        PlayNhacMp3(mangbaihat.get(position).getLinkbaihat());
                        fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(position).getHinhbaihat());
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                        UpdateTime();

                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgnext.setClickable(true);
                        imgpre.setClickable(true);
                    }
                },5000);
            }
        });
        sktime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        imgrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkrandom == false) {
                    if (repeat == true) {
                        repeat = false;
                        imgrandom.setImageResource(R.drawable.iconshuffled);
                        imgrepeat.setImageResource(R.drawable.iconrepeat);
                    }
                    imgrandom.setImageResource(R.drawable.iconshuffled);
                    checkrandom = true;
                } else {

                    imgrandom.setImageResource(R.drawable.iconsuffle);
                    checkrandom = true;
                }
            }
        });
        imgrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repeat == false) {
                    if (checkrandom == true) {
                        checkrandom = false;
                        imgrepeat.setImageResource(R.drawable.iconsyned);
                        imgrandom.setImageResource(R.drawable.iconsuffle);
                    }
                    imgrepeat.setImageResource(R.drawable.iconsyned);
                    repeat = true;
                } else {

                    imgrepeat.setImageResource(R.drawable.iconrepeat);
                    repeat = false;
                }

            }
        });

    }

    private void init() {
        fragment_dia_nhac = new Fragment_Dia_Nhac();
        fragment_play_danh_sach_cac_bai_hat = new Fragment_Play_Danh_Sach_Cac_Bai_Hat();
        adapterpager = new ViewPagerPlaylistnhac(getSupportFragmentManager());
        adapterpager.AddFragment(fragment_play_danh_sach_cac_bai_hat);
        adapterpager.AddFragment(fragment_dia_nhac);
        viewPagerPlaylistnhac.setAdapter(adapterpager);
        circleIndicatorplaynhac.setViewPager(viewPagerPlaylistnhac);
        fragment_dia_nhac = (Fragment_Dia_Nhac) adapterpager.getItem(1);
        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mangbaihat.clear();
                finish();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);

        if (mangbaihat.size() > 0) {
            getSupportActionBar().setTitle(mangbaihat.get(0).getTenbaihat());
            PlayNhacMp3(mangbaihat.get(0).getLinkbaihat());
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

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
                arraybaihat = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat = arraybaihat;
            }
        }
    }

    public void PlayNhacMp3(String url) {
        //url = "http://khoapham.vn/download/vietnamoi.mp3";
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(final MediaPlayer mp) {
                    CountDownTimer countDownTimer = new CountDownTimer(300, 100) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            mp.start();
                            TimeSong();
                        }
                    };
                    countDownTimer.start();


                }
            });
            mediaPlayer.prepareAsync();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void TimeSong() {
        final Handler handlerTImeSOng = new Handler();
        handlerTImeSOng.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (mediaPlayer != null) {
                    if (mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition() > 50) {
                        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                        txtTotalTime.setText(dinhDangGio.format(mediaPlayer.getDuration()));
                        // gán max skSong = tổng thời gian bài hát
                        sktime.setMax(mediaPlayer.getDuration());
                        nextbaihat = true;
                        handlerTImeSOng.removeCallbacks(this);

                    } else {
                        handlerTImeSOng.postDelayed(this, 1000);
                    }
                }

            }
        }, 2000);

    }

    private void UpdateTime() {
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // update seekbar
                sktime.setProgress(mediaPlayer.getCurrentPosition());
                // update txtTimeSong
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
//
                if (nextbaihat == true) {
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            if ((mp.getDuration() - mp.getCurrentPosition()) < 500) {
                                position++;
                                if (mangbaihat.size() > 1) {
                                    if (position > mangbaihat.size() - 1) {
                                        position = 0;
                                    }
                                    if (mediaPlayer.isPlaying()) {
                                        mediaPlayer.stop();
                                    }
                                    if (repeat == true) {
                                        position -= 1;
                                    }
                                    if (checkrandom == true) {
                                        Random random = new Random();
                                        int index = random.nextInt(mangbaihat.size());
                                        if (index == position) {
                                            position = index - 1;
                                        }
                                        position = index;

                                    }
                                    mediaPlayer = new MediaPlayer();
                                    fragment_dia_nhac.PlayDiaNhac(mangbaihat.get(position).getHinhbaihat());
                                    PlayNhacMp3(mangbaihat.get(position).getLinkbaihat());
                                    getSupportActionBar().setTitle(mangbaihat.get(position).getTenbaihat());
                                    TimeSong();
                                    nextbaihat = false;
                                }
                            }
                        }
                    });
                }


                handler.postDelayed(this, 300);
            }
        }, 100);
    }

}

