package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ptp.phamtanphat.appnhacmp3.Adapter.DanhsachtatcachudeAdapter;
import com.ptp.phamtanphat.appnhacmp3.Model.ChuDe;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Danhsachtatcachude extends AppCompatActivity {

    Toolbar toolbarallchudetheloai;
    RecyclerView recyclerViewallchudetheloai;
    DanhsachtatcachudeAdapter danhsachtatcachudeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcacacchudevatheloai);
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<ChuDe>> callback = dataservice.GetAllChude();
        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangchude = (ArrayList<ChuDe>) response.body();
                danhsachtatcachudeAdapter = new DanhsachtatcachudeAdapter(Danhsachtatcachude.this,mangchude);
                recyclerViewallchudetheloai.setLayoutManager(new GridLayoutManager(Danhsachtatcachude.this,1));
                recyclerViewallchudetheloai.setAdapter(danhsachtatcachudeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void init() {
        toolbarallchudetheloai = findViewById(R.id.toolbarallchudetheloai);
        recyclerViewallchudetheloai = findViewById(R.id.recyclerViewAllchudetheloai);
        setSupportActionBar(toolbarallchudetheloai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbarallchudetheloai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
