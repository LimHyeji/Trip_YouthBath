package com.ssafy.enjoytrip.member.controller;

import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.member.util.JoinException;
import com.ssafy.enjoytrip.member.util.LoginException;
import com.ssafy.enjoytrip.util.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.ssafy.enjoytrip.util.ApiUtils.*;

@RestControllerAdvice
public class MemberExceptionController {
    @ExceptionHandler({JoinException.class, LoginException.class, InfoCheckException.class})
    public ResponseEntity<ApiResult<?>> joinExceptionHandler(JoinException joinException){
        return error(joinException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResult<?>> anyExceptionHandler(Exception e){
        return error(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
