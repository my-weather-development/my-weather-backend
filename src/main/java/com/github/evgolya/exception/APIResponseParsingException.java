package com.github.evgolya.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public final class APIResponseParsingException extends RuntimeException {

    public APIResponseParsingException(String message, JsonProcessingException exception) {
        super(message, exception);
    }
}
