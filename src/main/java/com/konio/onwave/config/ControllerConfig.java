package com.konio.onwave.config;

import com.konio.onwave.controller.SongController;
import com.konio.onwave.controller.UserController;
import com.konio.onwave.service.SongServiceApi;
import com.konio.onwave.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by lschidu on 2/12/17.
 */
@Configuration
public class ControllerConfig {

    @Autowired
    private UserServiceApi userServiceApi;

    @Autowired
    private SongServiceApi songServiceApi;

    @Bean
    public UserController userController() {
        return new UserController(userServiceApi);
    }

    @Bean
    public SongController songController() {
        return new SongController(songServiceApi);
    }

}
