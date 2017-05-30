package com.konio.onwave.repository;

import com.konio.onwave.domain.entities.UserEntity;
import com.konio.onwave.domain.views.UserView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by lschidu on 2/9/17.
 */
public interface UserRepository extends JpaRepository<UserEntity, UserView> {

    UserEntity findOneById(Long id);

    UserEntity findOneByEmail(String email);

    UserEntity findOneByUuid(String uuid);

}
