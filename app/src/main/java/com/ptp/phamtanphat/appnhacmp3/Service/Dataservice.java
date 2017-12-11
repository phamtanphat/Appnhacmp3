package com.ptp.phamtanphat.appnhacmp3.Service;

import com.ptp.phamtanphat.appnhacmp3.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KhoaPhamPC on 4/12/2017.
 */

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();
}
