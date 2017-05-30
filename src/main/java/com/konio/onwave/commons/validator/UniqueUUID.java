package com.konio.onwave.commons.validator;

import com.konio.onwave.commons.ErrorMessage;
import com.konio.onwave.commons.validator.impl.UniqueUUIDValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lschidu on 2/12/17.
 */
@Constraint(validatedBy = UniqueUUIDValidator.class)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUUID {

    String message() default "{Phone}";

    ErrorMessage error();


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
