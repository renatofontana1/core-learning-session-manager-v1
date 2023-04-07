package com.accenture.ada.sessionManager.sessionmanager.exception;

import com.accenture.ada.baseapp.exception.AdaDomainRuntimeException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AdaDomainRuntimeException {

    private static final String ERROR_KEY = "user.not.found";

    public UserNotFoundException(String email) {
        super("Could not find user with email " + email, ERROR_KEY, HttpStatus.NOT_FOUND);
    }

}
