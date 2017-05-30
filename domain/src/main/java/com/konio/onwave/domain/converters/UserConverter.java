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
        userView.setFullName(userEntity.getFullName());
        userView.setEmail(userEntity.getEmail());
        userView.setPhotoUrl(userEntity.getPhotoUrl());
        return userView;
    }

    @Override
    protected UserEntity doBackward(UserView userView) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userView.getFirstName());
        userEntity.setEmail(userView.getEmail());
        userEntity.setFullName(userView.getFullName());
        userEntity.setUuid(userView.getUuid());
        userEntity.setLastName(userView.getLastName());
        userEntity.setUuid(userView.getUuid());
        userEntity.setPhotoUrl(userView.getPhotoUrl());
        return userEntity;
    }
}
