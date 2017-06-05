package com.konio.onwave.service.impl;

import com.konio.onwave.commons.utils.RetrofitHelper;
import com.konio.onwave.domain.converters.SongConverter;
import com.konio.onwave.domain.dto.SampleArtistBody;
import com.konio.onwave.domain.entities.SongEntity;
import com.konio.onwave.domain.entities.UserEntity;
import com.konio.onwave.domain.views.SongView;
import com.konio.onwave.repository.SongRepository;
import com.konio.onwave.repository.UserRepository;
import com.konio.onwave.service.SongServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lschidu on 2/14/17.
 */
@Service
@Transactional
public class SongServiceImpl implements SongServiceApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SongRepository songRepository;

    private final UserRepository userRepository;

    private final SongConverter songConverter = new SongConverter();

    public SongServiceImpl(SongRepository songRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SongView findSongById(Long id) {
        return songConverter.convert(songRepository.findOneById(id));
    }

    @Override
    public void addSong(SongView songView, String userUuid) {
        UserEntity userEntity = userRepository.findOneByUuid(userUuid);
        SongEntity songEntity = songConverter.reverse().convert(songView);
        songEntity.setUserId(userEntity.getId());
        songEntity.setCreationDate(Date.from(Instant.now()));
        songEntity.setUserEntity(userEntity);
        Call<SampleArtistBody> artist = RetrofitHelper.getINSTANCE().getApiService().postUser(songEntity.getArtist());

        artist.enqueue(new Callback<SampleArtistBody>() {
            @Override
            public void onResponse(Response<SampleArtistBody> response, Retrofit retrofit) {
                if(response.body() != null) {
                    songEntity.setPhotoUrl(response.body().getResults().get(0).getArtworkUrl30()
                            .replace("30x30", "500x500"));
                }
                songRepository.save(songEntity);
            }

            @Override
            public void onFailure(Throwable throwable) {
            }
        });
    }

    @Override
    public List<SongView> getSongListByUserId(String  uuid) {
        UserEntity userEntity = userRepository.findOneByUuid(uuid);
        return userEntity.getSongs().stream().map(songConverter::convert).collect(Collectors.toList());
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.removeById(id);
    }

}
