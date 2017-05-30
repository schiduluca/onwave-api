package com.konio.onwave.commons.utils;

import com.konio.onwave.domain.dto.Artist;
import com.konio.onwave.domain.dto.SampleArtistBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by lschidu on 2/19/17.
 */
public interface SpofityService {

    @GET("v1/search")
    Call<SampleArtistBody> postUser(@Query(value = "q") String artist, @Query(value = "type") String type);
}
