package com.ptp.phamtanphat.appnhacmp3.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ptp.phamtanphat.appnhacmp3.Adapter.BannerAdapter;
import com.ptp.phamtanphat.appnhacmp3.Adapter.PlaylistAdapter;
import com.ptp.phamtanphat.appnhacmp3.Model.Playlist;
import com.ptp.phamtanphat.appnhacmp3.Model.Quangcao;
import com.ptp.phamtanphat.appnhacmp3.R;
import com.ptp.phamtanphat.appnhacmp3.Service.APIService;
import com.ptp.phamtanphat.appnhacmp3.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tan Phat on 12/21/2017.
 */

public class Fragment_Playlist extends Fragment {

    ListView lvplaylist;
    TextView txttitleplaylist;
    PlaylistAdapter playlistAdapter;
    ArrayList<Playlist> mangplaylist;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);

        lvplaylist = view.findViewById(R.id.listviewplaylist);
        txttitleplaylist = view.findViewById(R.id.textviewtitleplaylist);
        GetData();
        return view;
    }
    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Playlist>> listplaylist = dataservice.GetPlaylistCurrentDay();
       listplaylist.enqueue(new Callback<List<Playlist>>() {
           @Override
           public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
               mangplaylist = (ArrayList<Playlist>) response.body();
               playlistAdapter = new PlaylistAdapter(getActivity(),android.R.layout.simple_expandable_list_item_1,mangplaylist);
               lvplaylist.setAdapter(playlistAdapter);
           }

           @Override
           public void onFailure(Call<List<Playlist>> call, Throwable t) {

           }
       });
    }
}
