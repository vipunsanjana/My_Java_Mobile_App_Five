package com.example.myappfive.network;

import com.example.myappfive.models.UserData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("users")
    Call<UserData> getUser();
}
