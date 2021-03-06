package com.ptp.phamtanphat.appnhacmp3.Adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.appnhacmp3.Activity.PlayNhacActivity;
import com.ptp.phamtanphat.appnhacmp3.Fragment.Fragment_Dia_Nhac;
import com.ptp.phamtanphat.appnhacmp3.Model.Baihat;
import com.ptp.phamtanphat.appnhacmp3.R;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dell on 2/16/2018.
 */

public class PlayNhacadapter extends RecyclerView.Adapter<PlayNhacadapter.ViewHolder> {

    Context context;
    ArrayList<Baihat> mangbaihat;
    Toolbar toolbar;
    MediaPlayer mediaPlayer;

    public PlayNhacadapter(Context context, ArrayList<Baihat> mangbaihat, Toolbar toolbar) {
        this.context = context;
        this.mangbaihat = mangbaihat;
        this.toolbar = toolbar;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_play_bat_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txtindex.setText(position + 1+"");
        holder.txttenbaihat.setText(baihat.getTenbaihat());
        holder.txtcasi.setText(baihat.getCasi());
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex,txttenbaihat,txtcasi;
        public ViewHolder(View itemView) {
            super(itemView);
            txtcasi = itemView.findViewById(R.id.textviewplaytencasi);
            txtindex = itemView.findViewById(R.id.textviewplaynhacindex);
            txttenbaihat = itemView.findViewById(R.id.textviewplaynhactenbaihat);
        }
    }

}
