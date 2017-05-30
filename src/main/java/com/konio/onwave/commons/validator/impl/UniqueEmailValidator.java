package com.konio.onwave.commons.validator.impl;

import com.konio.onwave.commons.ErrorMessage;
import com.konio.onwave.commons.validator.AbstractContraintValidator;
import com.konio.onwave.commons.validator.UniqueEmail;
import com.konio.onwave.domain.views.UserView;
import com.konio.onwave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by lschidu on 2/12/17.
 */
public class UniqueEmailValidator extends AbstractContraintValidator<UniqueEmail, UserView> {

    @Autowired
    private UserRepository userRepository;

    private ErrorMessage message;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
        this.message = uniqueEmail.error();
    }


    @Override
    protected boolean isValid(UserView value) {
        return userRepository.findOneByEmail(value.getEmail()) == null;
    }

    @Override
    protected ErrorMessage getErrorCode() {
        return message;
    }
}
