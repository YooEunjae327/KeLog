package com.temp.kelog.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException{

    private final ExceptionType error;

    public  CustomException(ExceptionType error) {
        super(error.getMessage());
        this.error = error;
    }
}
