package com.ptp.phamtanphat.appnhacmp3.Service;

/**
 * Created by KhoaPhamPC on 4/12/2017.
 */

public class APIService {

    private static final String Base_URL = "https://phatdroid94com.000webhostapp.com/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(Base_URL).create(Dataservice.class);
    }
}
