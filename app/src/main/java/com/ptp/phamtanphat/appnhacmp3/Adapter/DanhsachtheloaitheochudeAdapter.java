package com.ptp.phamtanphat.appnhacmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.appnhacmp3.Activity.DanhsachbaihatActivity;
import com.ptp.phamtanphat.appnhacmp3.Model.ChuDe;
import com.ptp.phamtanphat.appnhacmp3.Model.Playlist;
import com.ptp.phamtanphat.appnhacmp3.Model.TheLoai;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Dell on 2/9/2018.
 */

public class DanhsachtheloaitheochudeAdapter extends RecyclerView.Adapter<DanhsachtheloaitheochudeAdapter.ViewHolder>{
    Context context;
    ArrayList<TheLoai> mangtheloai;

    public DanhsachtheloaitheochudeAdapter(Context context, ArrayList<TheLoai> mangtheloai) {
        this.context = context;
        this.mangtheloai = mangtheloai;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_the_loai_theo_chu_de,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TheLoai theLoai = mangtheloai.get(position);
        Picasso.with(context).load(theLoai.getHinhTheLoai()).into(holder.imghinhnen);
        holder.txttentheloai.setText(theLoai.getTenTheLoai());
    }

    @Override
    public int getItemCount() {
        return mangtheloai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnen,imgiconplay;
        TextView txttentheloai;
        public ViewHolder(View itemView) {
            super(itemView);
            imghinhnen = itemView.findViewById(R.id.imageviewttheloaithechude);
            imgiconplay = itemView.findViewById(R.id.imageviewplayttheloaithechude);
            txttentheloai = itemView.findViewById(R.id.textviewtentheloaithechude);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
