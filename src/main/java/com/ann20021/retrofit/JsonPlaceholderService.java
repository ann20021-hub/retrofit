package com.ann20021.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.concurrent.TimeUnit;

public class JsonPlaceholderService {
    private Retrofit retrofit;

    public static JsonPlaceholderService instance;

    private static final String Base_URL = "https://jsonplaceholder.typicode.com";

    private JsonPlaceholderService(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static JsonPlaceholderService getInstance(){
        if (instance==null){
            instance = new JsonPlaceholderService();
        }
        return instance;
    }

    public JsonPlaceholderAPI api(){
        return retrofit.create(JsonPlaceholderAPI.class);
    }

}
