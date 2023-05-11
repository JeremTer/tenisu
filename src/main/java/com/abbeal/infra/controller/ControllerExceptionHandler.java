package com.abbeal.infra.controller;

import com.abbeal.usecase.exceptions.UnknownPlayerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UnknownPlayerException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleUnknownPlayerException(Exception exception) {
        return exception.getMessage();
    }
}
