package com.ptp.phamtanphat.appnhacmp3.Service;

import com.ptp.phamtanphat.appnhacmp3.Model.Album;
import com.ptp.phamtanphat.appnhacmp3.Model.Baihat;
import com.ptp.phamtanphat.appnhacmp3.Model.Playlist;
import com.ptp.phamtanphat.appnhacmp3.Model.Quangcao;
import com.ptp.phamtanphat.appnhacmp3.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
    Call<List<Baihat>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihat(@Field("idplaylist") String idplaylist);

    @GET("danhsachcacplaylist.php")
    Call<List<Playlist>> GetDanhsachcacPlaylist();
}
