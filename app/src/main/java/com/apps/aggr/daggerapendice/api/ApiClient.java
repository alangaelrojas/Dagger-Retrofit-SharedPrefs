package com.apps.aggr.daggerapendice.api;

import com.apps.aggr.daggerapendice.model.Meteorologia;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {

    @GET("data/2.5/forecast?id=524901&appid=804086089049ade02b1975fc113f1be4")
    Call<Meteorologia> getTiempo();
}
