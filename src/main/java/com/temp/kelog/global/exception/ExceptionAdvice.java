package com.temp.kelog.global.exception;

import com.temp.kelog.global.dto.ExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionDto> definedException(BusinessException e) {
        final ExceptionDto exceptionDto = ExceptionDto.builder()
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(e.getHttpStatus())
                .body(exceptionDto);
    }
}
