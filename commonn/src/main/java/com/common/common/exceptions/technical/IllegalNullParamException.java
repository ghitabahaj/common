package com.common.common.exceptions.technical;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalNullParamException extends TechnicalException {

    public IllegalNullParamException(String message) {
        super(message);
    }

    public IllegalNullParamException(String message, Throwable cause) {
        super(message, cause);
    }
}
