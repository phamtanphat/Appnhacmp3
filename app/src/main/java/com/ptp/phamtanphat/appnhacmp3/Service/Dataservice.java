package com.ptp.phamtanphat.appnhacmp3.Service;

import com.ptp.phamtanphat.appnhacmp3.Model.Album;
import com.ptp.phamtanphat.appnhacmp3.Model.BaiHatThichNhat;
import com.ptp.phamtanphat.appnhacmp3.Model.Playlist;
import com.ptp.phamtanphat.appnhacmp3.Model.Quangcao;
import com.ptp.phamtanphat.appnhacmp3.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KhoaPhamPC on 4/12/2017.
 */

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<BaiHatThichNhat>> GetBaiHatHot();
}
