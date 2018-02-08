package com.ptp.phamtanphat.appnhacmp3.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ptp.phamtanphat.appnhacmp3.Adapter.BaihathopAdapter;
import com.ptp.phamtanphat.appnhacmp3.Model.Baihat;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dell on 2/5/2018.
 */

public class Fragment_Bai_Hat_Hot extends Fragment {

    View view;
    RecyclerView recyclerViewbaihathot;
    BaihathopAdapter baihathopAdapter;
    TextView txtxemthembaihathot;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bai_hat_thich_nhat,container,false);
        recyclerViewbaihathot = view.findViewById(R.id.recyclerViewbaihathot);
        txtxemthembaihathot = view.findViewById(R.id.textviewxemthembaihathot);
        GetData();

        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> listCall = dataservice.GetBaiHatHot();
        listCall.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> mangbaihathot = (ArrayList<Baihat>) response.body();
                baihathopAdapter = new BaihathopAdapter(getActivity(),mangbaihathot);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewbaihathot.setLayoutManager(linearLayoutManager);
                recyclerViewbaihathot.setAdapter(baihathopAdapter);
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
}
