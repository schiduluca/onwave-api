package com.konio.onwave.commons.validator.impl;

import com.konio.onwave.commons.ErrorMessage;
import com.konio.onwave.commons.validator.AbstractConstraintValidator;
import com.konio.onwave.commons.validator.UserExists;
import com.konio.onwave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by lschidu on 2/12/17.
 */
public class UserExistsValidator extends AbstractConstraintValidator<UserExists, String> {

    @Autowired
    private UserRepository userRepository;

    private ErrorMessage message;

    @Override
    public void initialize(UserExists uniqueEmail) {
        this.message = uniqueEmail.error();
    }


    @Override
    protected boolean isValid(String uuid) {
        return userRepository.findOneByUuid(uuid) != null;
    }

    @Override
    protected ErrorMessage getErrorCode() {
        return message;
    }
}
