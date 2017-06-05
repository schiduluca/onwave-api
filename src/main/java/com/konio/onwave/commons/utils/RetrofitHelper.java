package com.konio.onwave.commons.utils;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by lschidu on 2/19/17.
 */
public class RetrofitHelper {

    private static RetrofitHelper INSTANCE = new RetrofitHelper();

    private static final String apiUrl = "https://itunes.apple.com/";

    private ItunesService apiService;


    private RetrofitHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ItunesService.class);
    }

    public static RetrofitHelper getINSTANCE() {
        return INSTANCE;
    }

    public ItunesService getApiService() {
        return this.apiService;
    }
}
