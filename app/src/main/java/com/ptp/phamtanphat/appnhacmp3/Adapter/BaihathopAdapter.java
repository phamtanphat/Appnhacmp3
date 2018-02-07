package com.ptp.phamtanphat.appnhacmp3.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ptp.phamtanphat.appnhacmp3.Model.BaiHatThichNhat;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Dell on 2/5/2018.
 */

public class BaihathopAdapter extends RecyclerView.Adapter<BaihathopAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHatThichNhat> mangbaihathot;
    Boolean like = false;

    public BaihathopAdapter(Context context, ArrayList<BaiHatThichNhat> mangbaihathot) {
        this.context = context;
        this.mangbaihathot = mangbaihathot;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_bai_hat_hot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        BaiHatThichNhat baiHatThichNhat = mangbaihathot.get(position);
        holder.txtten.setText(baiHatThichNhat.getTenbaihat());
        holder.txtcasi.setText(baiHatThichNhat.getCasi());
        Picasso.with(context).load(baiHatThichNhat.getHinhbaihat()).into(holder.imghinh);

    }

    @Override
    public int getItemCount() {
        return mangbaihathot.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten,txtcasi;
        ImageView imghinh,imgluothich;
        public ViewHolder(View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textviewtenbaihathot);
            txtcasi = itemView.findViewById(R.id.textviewcasibaihathot);
            imghinh = itemView.findViewById(R.id.imageviewbaihathot);
            imgluothich = itemView.findViewById(R.id.imageviewluotthich);
            imgluothich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluothich.setImageResource(R.drawable.iconloved);
                }
            });
        }
    }
}
