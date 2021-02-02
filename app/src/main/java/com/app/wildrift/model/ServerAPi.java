package com.app.wildrift.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerAPi {

    @GET("AppSettings.json")
    Call<DataInfo> getInfo();
}
