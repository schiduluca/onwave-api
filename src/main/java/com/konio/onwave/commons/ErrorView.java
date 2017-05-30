package com.konio.onwave.commons;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lschidu on 2/13/17.
 */
public class ErrorView implements Serializable {

    private final List<String> errorCodes;

    public ErrorView(List<String> errorCode) {
        this.errorCodes = errorCode;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }
}
