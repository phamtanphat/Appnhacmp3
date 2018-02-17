package com.ptp.phamtanphat.appnhacmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ptp.phamtanphat.appnhacmp3.Activity.PlayNhacActivity;
import com.ptp.phamtanphat.appnhacmp3.Model.Baihat;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dell on 2/5/2018.
 */

public class BaihathopAdapter extends RecyclerView.Adapter<BaihathopAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> mangbaihathot;

    public BaihathopAdapter(Context context, ArrayList<Baihat> mangbaihathot) {
        this.context = context;
        this.mangbaihathot = mangbaihathot;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_bai_hat_hot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Baihat baiHatThichNhat = mangbaihathot.get(position);
        holder.txtten.setText(baiHatThichNhat.getTenbaihat());
        holder.txtcasi.setText(baiHatThichNhat.getCasi());
        Picasso.with(context).load(baiHatThichNhat.getHinhbaihat()).into(holder.imghinh);

    }

    @Override
    public int getItemCount() {
        return mangbaihathot.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtten, txtcasi;
        ImageView imghinh, imgluothich;

        public ViewHolder(View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textviewtenbaihathot);
            txtcasi = itemView.findViewById(R.id.textviewcasibaihathot);
            imghinh = itemView.findViewById(R.id.imageviewbaihathot);
            imgluothich = itemView.findViewById(R.id.imageviewluotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",mangbaihathot.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluothich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluothich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.UpdateLuotthich("1", mangbaihathot.get(getPosition()).getIdbaihat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("success")) {
                                Toast.makeText(context, "Da thich", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Loi!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluothich.setEnabled(false);
                }
            });
        }
    }
}
