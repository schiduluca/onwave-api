package com.konio.onwave.controller;

import com.konio.onwave.domain.views.SongView;
import com.konio.onwave.service.SongServiceApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lschidu on 2/14/17.
 */
@RestController
@RequestMapping(value = "/songs")
public class SongController {

    private final SongServiceApi songServiceApi;


    public SongController(SongServiceApi songServiceApi) {
        this.songServiceApi = songServiceApi;
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.POST)
    public void postSong(@RequestBody SongView songView, @PathVariable String uuid) {
        songServiceApi.addSong(songView, uuid);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SongView getSongById(@PathVariable Long id) {
        return songServiceApi.findSongById(id);
    }

    @RequestMapping(value = "/list/{userUuid}", method = RequestMethod.GET)
    public List<SongView> getSongListByUserId(@PathVariable String userUuid) {
        return songServiceApi.getSongListByUserId(userUuid);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSong(@PathVariable Long id) {
        songServiceApi.deleteSong(id);
    }
    
}
