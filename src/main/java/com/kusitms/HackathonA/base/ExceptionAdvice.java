package com.kusitms.HackathonA.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    /**
     * Custom Exception 핸들링
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity onBaseException(BaseException exception){
        return new ResponseEntity<>(BaseResponse.onFailure(exception.getErrorCode().getCode(), exception.getMessage(), exception.getData()), null, exception.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity onException(Exception exception){
        return new ResponseEntity<>(BaseResponse.onFailure(500, exception.getMessage(),null), null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
