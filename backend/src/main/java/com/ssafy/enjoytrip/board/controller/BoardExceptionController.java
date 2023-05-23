package com.ssafy.enjoytrip.board.controller;

import com.ssafy.enjoytrip.board.model.util.DeleteException;
import com.ssafy.enjoytrip.board.model.util.ModifyException;
import com.ssafy.enjoytrip.board.model.util.RegistException;

import com.ssafy.enjoytrip.util.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.ssafy.enjoytrip.util.ApiUtils.*;
@RestControllerAdvice
public class BoardExceptionController {
    @ExceptionHandler({RegistException.class, ModifyException.class})
    public ResponseEntity<ApiResult<?>> exceptionHandler(Exception e){
        return error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeleteException.class)
    public ResponseEntity<ApiResult<?>> boardDeleteExceptionHandler(DeleteException e){
        return error("삭제 오류",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResult<?>> ectHandler(Exception e){
        return error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
