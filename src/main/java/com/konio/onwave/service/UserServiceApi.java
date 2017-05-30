package com.konio.onwave.service;

import com.konio.onwave.commons.ErrorMessage;
import com.konio.onwave.commons.validator.UniqueEmail;
import com.konio.onwave.commons.validator.UniqueUUID;
import com.konio.onwave.commons.validator.UserExists;
import com.konio.onwave.domain.views.UserView;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

/**
 * Created by lschidu on 2/9/17.
 */
@Service
@Validated
public interface UserServiceApi {

    UserView registerUser(@UniqueEmail(error = ErrorMessage.EMAIL_ALREADY_EXISTS)
                          @UniqueUUID(error = ErrorMessage.UUID_ALREADY_EXISTS) UserView userView);

    UserView findUserById(Long id);

    List<UserView> findFollowersByUserUuid(@UserExists(error = ErrorMessage.USER_DOESNT_EXIST) String uuid, Boolean follower);

    UserView followUserByUuid(@UserExists(error = ErrorMessage.USER_DOESNT_EXIST) String userUuid,
                              @UserExists(error = ErrorMessage.USER_DOESNT_EXIST) String uuid);

    UserView unfollowUserByUuid(@UserExists(error = ErrorMessage.USER_DOESNT_EXIST) String userUuid,
                                @UserExists(error = ErrorMessage.USER_DOESNT_EXIST) String uuid);

    UserView findUserByUuid(@UserExists(error = ErrorMessage.USER_DOESNT_EXIST) String uuid);
}
