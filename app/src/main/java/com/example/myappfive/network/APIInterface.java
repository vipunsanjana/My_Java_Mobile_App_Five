package com.example.myappfive.network;

import com.example.myappfive.models.PostBody;
import com.example.myappfive.models.PostResponse;
import com.example.myappfive.models.UserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("users")
    Call<UserData> getUser();

    @POST("users")
    Call<PostResponse> createUser(@Body PostBody postBody);
}
