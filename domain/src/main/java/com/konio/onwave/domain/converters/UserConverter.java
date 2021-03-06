package com.konio.onwave.domain.converters;

/**
 * Created by lschidu on 2/12/17.
 */
import com.google.common.base.Converter;
import com.konio.onwave.domain.entities.UserEntity;
import com.konio.onwave.domain.views.UserView;

public class UserConverter extends Converter<UserEntity, UserView> {
    @Override
    protected UserView doForward(UserEntity userEntity) {
        UserView userView = new UserView();
        userView.setId(userEntity.getId());
        userView.setFirstName(userEntity.getFirstName());
        userView.setLastName(userEntity.getLastName());
        userView.setUuid(userEntity.getUuid());
        userView.setEmail(userEntity.getEmail());
        userView.setPhotoUrl(userEntity.getPhotoUrl());
        return userView;
    }

    @Override
    protected UserEntity doBackward(UserView userView) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userView.getFullName().split(" ")[0]);
        userEntity.setEmail(userView.getEmail());
        userEntity.setUuid(userView.getUuid());
        userEntity.setLastName(userView.getFullName().split(" ")[1]);
        userEntity.setUuid(userView.getUuid());
        userEntity.setPhotoUrl(userView.getPhotoUrl());
        return userEntity;
    }
}
