package com.konio.onwave.config;

import com.konio.onwave.repository.SongRepository;
import com.konio.onwave.repository.UserRepository;
import com.konio.onwave.service.SongServiceApi;
import com.konio.onwave.service.UserServiceApi;
import com.konio.onwave.service.impl.SongServiceImpl;
import com.konio.onwave.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lschidu on 2/9/17.
 */
@Configuration
public class ServiceConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;

    @Bean
    public UserServiceApi userServiceApi() {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public SongServiceApi songServiceApi() {
        return new SongServiceImpl(songRepository, userRepository);
    }
}
