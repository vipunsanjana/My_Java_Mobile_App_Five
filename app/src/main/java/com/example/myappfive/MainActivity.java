package com.example.myappfive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myappfive.models.PostBody;
import com.example.myappfive.models.PostResponse;
import com.example.myappfive.models.UserData;
import com.example.myappfive.models.UserDataList;
import com.example.myappfive.network.APIInterface;
import com.example.myappfive.network.RestAPIClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIInterface service;
    private RestAPIClient client;
    private String baseUrl;
    private ArrayList<UserDataList> userDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseUrl = "https://reqres.in/api/";
        client = new RestAPIClient(baseUrl);

        service = client.buildApi();

        Call<UserData> call = service.getUser();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {

                userDataList = response.body().getUserDataList();
                Log.d("TAG", "onResponse" + response);

            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {

            }
        });

        PostBody postBody = new PostBody("kaml","SSE");
        Call<PostResponse> callPost = service.createUser(postBody);
        callPost.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if(response.isSuccessful()){

                    //code 200 || 201
                    Log.d("TAG", "onResponse" + response);

                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });
    }
}