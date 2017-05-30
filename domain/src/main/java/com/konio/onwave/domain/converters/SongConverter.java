package com.konio.onwave.domain.converters;

import com.google.common.base.Converter;
import com.konio.onwave.domain.entities.SongEntity;
import com.konio.onwave.domain.views.SongView;

/**
 * Created by lschidu on 2/14/17.
 */
public class SongConverter extends Converter<SongEntity, SongView> {
    @Override
    protected SongView doForward(SongEntity songEntity) {
        SongView songView = new SongView();
        songView.setId(songEntity.getId());
        songView.setAlbum(songEntity.getAlbum());
        songView.setTrack(songEntity.getTrack());
        songView.setArtist(songEntity.getArtist());
        songView.setLatitude(songEntity.getLatitude());
        songView.setLongitude(songEntity.getLongitude());
        songView.setPhotoUrl(songEntity.getPhotoUrl());

        return songView;
    }

    @Override
    protected SongEntity doBackward(SongView songView) {
        SongEntity songEntity = new SongEntity();
        songEntity.setAlbum(songView.getAlbum());
        songEntity.setArtist(songView.getArtist());
        songEntity.setLatitude(songView.getLatitude());
        songEntity.setLongitude(songView.getLongitude());
        songEntity.setTrack(songView.getTrack());
        return songEntity;
    }
}
