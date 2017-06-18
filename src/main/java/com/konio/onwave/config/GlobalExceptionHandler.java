package com.konio.onwave.config;

import com.konio.onwave.commons.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lschidu on 2/12/17.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ErrorView handleException(ConstraintViolationException e) {
        List<String> collect = e.getConstraintViolations().stream().
                map(ConstraintViolation::getMessageTemplate).collect(Collectors.toList());
        return new ErrorView(collect);
    }
}
