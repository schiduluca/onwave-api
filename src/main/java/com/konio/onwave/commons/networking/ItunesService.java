package com.konio.onwave.commons.networking;

import com.konio.onwave.domain.dto.SampleArtistBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by lschidu on 2/19/17.
 */
public interface ItunesService {

    @GET("search")
    Call<SampleArtistBody> postUser(@Query(value = "term") String artist);
}
