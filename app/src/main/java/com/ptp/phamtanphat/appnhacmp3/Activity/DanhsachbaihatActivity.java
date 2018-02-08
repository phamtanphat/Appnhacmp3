package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ptp.phamtanphat.appnhacmp3.Adapter.AlbumAdapter;
import com.ptp.phamtanphat.appnhacmp3.Adapter.DanhsachbaihatAdapter;
import com.ptp.phamtanphat.appnhacmp3.Model.Album;
import com.ptp.phamtanphat.appnhacmp3.Model.Baihat;
import com.ptp.phamtanphat.appnhacmp3.Model.Playlist;
import com.ptp.phamtanphat.appnhacmp3.Model.Quangcao;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {

    Playlist playlist;
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    ImageView imgdanhsachcakhuc;
    RecyclerView recyclerViewdanhsachcakhuc;
    DanhsachbaihatAdapter danhsachbaihatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        DataIntent();
        anhxa();
        init();
        GetData();

    }

    private void GetData() {

        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> listCall = dataservice.GetDanhsachbaihat(playlist.getIdPlaylist());
        listCall.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {

                ArrayList<Baihat> mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this,mangbaihat);
                recyclerViewdanhsachcakhuc.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachcakhuc.setAdapter(danhsachbaihatAdapter);
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });

    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setTitle(playlist.getTen());
        try {
            URL url = new URL(playlist.getHinhPlaylist());
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(playlist.getHinhPlaylist()).into(imgdanhsachcakhuc);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        floatingActionButton = findViewById(R.id.floatingactionbuttondanhsach);
        imgdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
        recyclerViewdanhsachcakhuc = findViewById(R.id.recyclerViewdanhsachbaihat);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("itemplaylist")){
                playlist = intent.getParcelableExtra("itemplaylist");
            }
        }
    }
}
