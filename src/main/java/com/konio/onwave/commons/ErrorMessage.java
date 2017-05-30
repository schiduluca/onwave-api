package com.konio.onwave.commons;

/**
 * Created by lschidu on 2/12/17.
 */
public enum ErrorMessage {

    EMAIL_ALREADY_EXISTS("1"),
    USER_DOESNT_EXIST("3"),
    UUID_ALREADY_EXISTS("2");

    private final String code;

    ErrorMessage(String code) {
        this.code = code;
    }

    public String getErrorCode() {
        return code;
    }

}
