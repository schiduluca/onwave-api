package com.konio.onwave.user;

import com.konio.onwave.domain.entities.UserEntity;
import com.konio.onwave.domain.views.UserView;
import com.konio.onwave.repository.UserRepository;
import com.konio.onwave.service.UserServiceApi;
import com.konio.onwave.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by lschidu on 4/14/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private UserEntity userEntity;
    private UserView userView;
    private final long id = 1;

    private final String fullName = "Schidu Luca";
    private final String email = "schiduluca@gmail.com";

    private String randomUUID;

    @Mock
    private UserRepository userRepository;

    private UserServiceApi userServiceApi;



    @Before
    public void setup() {
        randomUUID = UUID.randomUUID().toString();
        prepareUser();
    }

    @Test
    public void testReturnUserById() {
        when(userRepository.findOneById(id)).thenReturn(userEntity);
        userServiceApi = new UserServiceImpl(userRepository);

        UserView obtainedUserView = userServiceApi.findUserById(id);
        assertThat(obtainedUserView.getEmail()).isSameAs(userView.getEmail());
        assertThat(obtainedUserView.getFullName()).isSameAs(userView.getFullName());
        assertThat(obtainedUserView.getUuid()).isSameAs(userView.getUuid());
    }

    @Test
    public void testReturnUserByUuid() {
        when(userRepository.findOneByUuid(randomUUID)).thenReturn(userEntity);
        userServiceApi = new UserServiceImpl(userRepository);
        UserView obtainedUserView = userServiceApi.findUserByUuid(randomUUID);
        assertThat(obtainedUserView.getEmail()).isSameAs(userView.getEmail());
        assertThat(obtainedUserView.getFullName()).isSameAs(userView.getFullName());
        assertThat(obtainedUserView.getUuid()).isSameAs(userView.getUuid());

    }

    private void prepareUser() {
        userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setUuid(randomUUID);

        userView = new UserView();
        userView.setFullName(fullName);
        userView.setEmail(email);
        userView.setUuid(randomUUID);
    }
}
