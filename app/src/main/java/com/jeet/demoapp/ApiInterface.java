package com.jeet.demoapp;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET
    Call<Object> getDataFromServer(@Url String url);


    @POST
    Call<Object> getDataFromServer(@Url String url, @Body HashMap<String, String> hashMap);
}
