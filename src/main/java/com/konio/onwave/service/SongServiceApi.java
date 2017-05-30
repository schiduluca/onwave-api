package com.konio.onwave.service;

import com.konio.onwave.commons.ErrorMessage;
import com.konio.onwave.commons.validator.UserExists;
import com.konio.onwave.domain.views.SongView;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lschidu on 2/14/17.
 */
@Service
@Validated
public interface SongServiceApi {

    SongView findSongById(Long id);

    void addSong(SongView songView, @UserExists(error = ErrorMessage.USER_DOESNT_EXIST) String uuid);

    List<SongView> getSongListByUserId(@UserExists(error = ErrorMessage.USER_DOESNT_EXIST) Long id);


}
