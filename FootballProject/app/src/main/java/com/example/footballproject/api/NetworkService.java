package com.example.footballproject.api;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "https://api-football-v1.p.rapidapi.com";
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public ApiEndpoints getApi (){
        return mRetrofit.create(ApiEndpoints.class);
    }
}
