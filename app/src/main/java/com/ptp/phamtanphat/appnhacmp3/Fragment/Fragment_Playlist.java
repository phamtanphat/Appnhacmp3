package com.ptp.phamtanphat.appnhacmp3.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ptp.phamtanphat.appnhacmp3.R;

/**
 * Created by Tan Phat on 12/21/2017.
 */

public class Fragment_Playlist extends Fragment {

    ListView lvplaylist;
    TextView txttitleplaylist;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);

        lvplaylist = view.findViewById(R.id.listviewplaylist);
        txttitleplaylist = view.findViewById(R.id.textviewtitleplaylist);
        return view;
    }
}
