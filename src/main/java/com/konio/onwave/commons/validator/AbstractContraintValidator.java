package com.konio.onwave.commons.validator;

import com.konio.onwave.commons.ErrorMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * Created by lschidu on 2/13/17.
 */
public abstract class AbstractContraintValidator<A extends Annotation, T>
        implements ConstraintValidator<A, T> {

    @Override
    public boolean isValid(T value, ConstraintValidatorContext context) {
        boolean isValid = isValid(value);
        if (!isValid) {
            context.buildConstraintViolationWithTemplate(getErrorCode().getErrorCode())
                    .addConstraintViolation();
            context.disableDefaultConstraintViolation();
        }
        return isValid;
    }

    protected abstract boolean isValid(T value);

    protected abstract ErrorMessage getErrorCode();



}
