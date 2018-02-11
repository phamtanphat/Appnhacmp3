package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ptp.phamtanphat.appnhacmp3.Adapter.DanhsachtheloaitheochudeAdapter;
import com.ptp.phamtanphat.appnhacmp3.Model.ChuDe;
import com.ptp.phamtanphat.appnhacmp3.Model.TheLoai;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtheloaitheochudeActivity extends AppCompatActivity {

    RecyclerView recyclerViewtheloaitheochude;
    Toolbar toolbartheloaithechude;
    DanhsachtheloaitheochudeAdapter danhsachtheloaitheochudeAdapter;
    ChuDe chuDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtheloaitheochude);
        GetIntent();
        init();
        GetData();

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TheLoai>> listCall = dataservice.GetTheloaitheochude(chuDe.getIdChuDe());
        listCall.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> mangtheloai = (ArrayList<TheLoai>) response.body();
                danhsachtheloaitheochudeAdapter = new DanhsachtheloaitheochudeAdapter(DanhsachtheloaitheochudeActivity.this,mangtheloai);
                recyclerViewtheloaitheochude.setLayoutManager(new GridLayoutManager(DanhsachtheloaitheochudeActivity.this,2));
                recyclerViewtheloaitheochude.setAdapter(danhsachtheloaitheochudeAdapter);
            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewtheloaitheochude = findViewById(R.id.recyclerviewtheloaitheochude);
        toolbartheloaithechude = findViewById(R.id.toolbartheloaitheochude);
        setSupportActionBar(toolbartheloaithechude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(chuDe.getTenChuDe());
        toolbartheloaithechude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("chude")) {
            chuDe = intent.getParcelableExtra("chude");
        }
    }
}
