package com.accenture.ada.sessionManager.sessionmanager.exception;

import com.accenture.ada.baseapp.exception.AdaDomainRuntimeException;
import org.springframework.http.HttpStatus;

public class SessionNotFoundException extends AdaDomainRuntimeException {

    private static final String ERROR_KEY = "session.not.found";

    public SessionNotFoundException(String sessionId) {
        super("Session not found for session id " + sessionId, ERROR_KEY, HttpStatus.NOT_FOUND);
    }


}
