package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ptp.phamtanphat.appnhacmp3.Adapter.AlbumAdapter;
import com.ptp.phamtanphat.appnhacmp3.Adapter.DanhsachcacplaylistAdapter;
import com.ptp.phamtanphat.appnhacmp3.Model.Album;
import com.ptp.phamtanphat.appnhacmp3.Model.Playlist;
import com.ptp.phamtanphat.appnhacmp3.Model.TheLoai;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Danhsachcacplaylist extends AppCompatActivity {

    DanhsachcacplaylistAdapter danhsachcactheloaiAdapter;
    RecyclerView recyclerViewdanhsachcacplaylist;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcactheloai);
        Anhxa();
        GetData();

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> callback = dataservice.GetDanhsachcacPlaylist();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> mangplaylist = (ArrayList<Playlist>) response.body();
                danhsachcactheloaiAdapter = new DanhsachcacplaylistAdapter(Danhsachcacplaylist.this,mangplaylist);
                recyclerViewdanhsachcacplaylist.setLayoutManager(new GridLayoutManager(Danhsachcacplaylist.this,2));
                recyclerViewdanhsachcacplaylist.setAdapter(danhsachcactheloaiAdapter);

            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    private void Anhxa() {
        recyclerViewdanhsachcacplaylist = findViewById(R.id.recyclerViewdanhsachcacplaylist);
        toolbar = findViewById(R.id.toolbardanhsachcacplaylist);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play Lists");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorFloatingButton));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
