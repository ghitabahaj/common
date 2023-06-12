package com.common.common.exceptions.technical;

import com.common.common.exceptions.business.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectAlreadyExistException extends BusinessException {

    public ObjectAlreadyExistException(String message) {
        super(message);
    }

    public ObjectAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}