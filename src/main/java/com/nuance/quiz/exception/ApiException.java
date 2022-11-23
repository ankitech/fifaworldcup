package com.nuance.quiz.exception;

import org.springframework.http.HttpStatus;

class ApiException extends Exception{
    private HttpStatus code;
    ApiException(HttpStatus code, String msg) {
        super(msg);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }
}
