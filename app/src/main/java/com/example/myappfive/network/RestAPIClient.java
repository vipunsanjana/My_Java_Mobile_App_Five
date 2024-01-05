package com.example.myappfive.network;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIClient {

    private Retrofit mClient;
    OkHttpClient client;
    Context context;

    public RestAPIClient(String baseUrl){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        RequestInterceptor interceptor = new RequestInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .addInterceptor(interceptor) // Assuming you intended to add this interceptor
                .build();

        mClient = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    public APIInterface buildApi(){
        return mClient.create(APIInterface.class);
    }

    public Retrofit retrofit(){
        return mClient;
    }

    public OkHttpClient okHttpClient(){
        return client;
    }

    class RequestInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer aaa")
                    .build();
            return chain.proceed(request);
        }
    }
}