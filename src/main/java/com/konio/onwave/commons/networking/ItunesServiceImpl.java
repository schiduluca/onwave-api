package com.konio.onwave.commons.networking;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by lschidu on 2/19/17.
 */
public class ItunesServiceImpl {

    private static ItunesServiceImpl INSTANCE = new ItunesServiceImpl();

    private static final String apiUrl = "https://itunes.apple.com/";

    private ItunesService apiService;


    private ItunesServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ItunesService.class);
    }

    public static ItunesServiceImpl getINSTANCE() {
        return INSTANCE;
    }

    public ItunesService getApiService() {
        return this.apiService;
    }
}
