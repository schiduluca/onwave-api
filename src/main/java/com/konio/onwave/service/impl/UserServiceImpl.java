package com.konio.onwave.service.impl;

import com.google.common.collect.Lists;
import com.konio.onwave.domain.converters.SongConverter;
import com.konio.onwave.domain.converters.UserConverter;
import com.konio.onwave.domain.entities.UserEntity;
import com.konio.onwave.domain.views.UserView;
import com.konio.onwave.repository.UserRepository;
import com.konio.onwave.service.UserServiceApi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lschidu on 2/9/17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserServiceApi {

    private final UserRepository userRepository;

    private final UserConverter userConverter = new UserConverter();

    private final SongConverter songConverter = new SongConverter();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserView registerUser(UserView userView) {
        UserEntity userEntity = userConverter.reverse().convert(userView);
        userRepository.save(userEntity);
        return userView;
    }

    @Override
    public UserView findUserById(Long id) {
        UserEntity userEntity = userRepository.findOneById(id);
        return userConverter.convert(userEntity);
    }

    @Override
    public List<UserView> findFollowersByUserUuid(String uuid, Boolean follower) {
        List<UserEntity> list = follower ? userRepository.findOneByUuid(uuid).getFollowers() :
                userRepository.findOneByUuid(uuid).getFollowing();
        return list.stream().map(userConverter::convert).collect(Collectors.toList());
    }

    @Override
    public UserView followUserByUuid(String userUuid, String uuid) {
        UserEntity userEntity = userRepository.findOneByUuid(userUuid);
        UserEntity userToFollow = userRepository.findOneByUuid(uuid);

        if(!userEntity.getFollowing().contains(userToFollow)) {
            userEntity.getFollowing().add(userToFollow);
            return userConverter.convert(userToFollow);
        } else {
            return null;
        }
    }

    @Override
    public UserView unfollowUserByUuid(String userUuid, String uuid) {
        UserEntity userEntity = userRepository.findOneByUuid(userUuid);
        UserEntity userToFollow = userRepository.findOneByUuid(uuid);

        if(userEntity.getFollowing().contains(userToFollow)) {
            userEntity.getFollowing().remove(userToFollow);
            return userConverter.convert(userToFollow);
        } else {
            return null;
        }
    }

    @Override
    public UserView findUserByUuid(String uuid) {
        UserEntity userEntity = userRepository.findOneByUuid(uuid);
        UserView userView = userConverter.convert(userEntity);
        userView.setSongs(Lists.reverse(userEntity.getSongs().stream().map(songConverter::convert).collect(Collectors.toList())));
        return userView;
    }

    @Override
    public List<UserView> findAllUsers() {
        return userRepository.findAll().stream().map(userConverter::convert).collect(Collectors.toList());
    }
}
