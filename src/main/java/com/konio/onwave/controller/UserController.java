package com.konio.onwave.controller;


import com.konio.onwave.domain.views.UserView;
import com.konio.onwave.service.UserServiceApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by lschidu on 2/9/17.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserServiceApi userServiceApi;


    public UserController(UserServiceApi userServiceApi) {
        this.userServiceApi = userServiceApi;
    }


    @RequestMapping(value = "{uuid}", method = RequestMethod.GET)
    public UserView getUserByUuid(@PathVariable String uuid) {
        return userServiceApi.findUserByUuid(uuid);
    }

    @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<UserView> postUser(@RequestBody UserView userView) {
        return ResponseEntity.ok(userServiceApi.registerUser(userView));
    }

    @RequestMapping(value = "followers/{uuid}", method = RequestMethod.GET)
    public List<UserView> getFollowersByUserUuid(@PathVariable String uuid) {
        return userServiceApi.findFollowersByUserUuid(uuid, Boolean.TRUE);
    }

    @RequestMapping(value = "following/{uuid}", method = RequestMethod.GET)
    public List<UserView> getFollowingByUserUuid(@PathVariable String uuid) {
        return userServiceApi.findFollowersByUserUuid(uuid, Boolean.FALSE);
    }


    @RequestMapping(value = "{userUuid}/follow/{uuid}", method = RequestMethod.PATCH)
    public UserView followUserByUuid(@PathVariable String userUuid, @PathVariable String uuid) {
        return userServiceApi.followUserByUuid(uuid, userUuid);
    }

    @RequestMapping(value = "{userUuid}/unfollow/{uuid}", method = RequestMethod.PATCH)
    public UserView unfollowUserByUuid(@PathVariable String userUuid, @PathVariable String uuid) {
        return userServiceApi.unfollowUserByUuid(userUuid, uuid);
    }
}
