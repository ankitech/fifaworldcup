package com.nuance.quiz.exception;

import org.springframework.http.HttpStatus;

public class GeneralException extends ApiException {
    private HttpStatus code;
    public GeneralException(HttpStatus code, String msg) {
        super(code, msg);
        this.code = code;
    }
}