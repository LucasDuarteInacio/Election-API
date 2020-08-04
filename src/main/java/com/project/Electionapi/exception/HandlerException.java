package com.project.Electionapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ResponseException> expectError(ApiException e, WebRequest webRequest){
        ResponseException responseException = new ResponseException(e.getMessage(),e.getDetail(),
                System.currentTimeMillis(),webRequest.getDescription(true));
        return new ResponseEntity<>(responseException, HttpStatus.valueOf(e.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseException> unexpectError(Exception e, WebRequest webRequest){
        ResponseException responseException = new ResponseException(e.getMessage(),
                e.toString(), System.currentTimeMillis(), webRequest.getDescription(true));
        return new ResponseEntity(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
