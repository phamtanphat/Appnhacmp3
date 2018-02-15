package com.ptp.phamtanphat.appnhacmp3.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ptp.phamtanphat.appnhacmp3.Model.Baihat;
import com.ptp.phamtanphat.appnhacmp3.R;

public class PlayNhacActivity extends AppCompatActivity {

    Baihat baihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        GetdatafromIntent();
    }

    private void GetdatafromIntent() {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("cakhuc")){
                baihat = intent.getParcelableExtra("cakhuc");
                Toast.makeText(this, baihat.getTenbaihat(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
