package com.romario.gerenciador_de_produtos.controller;


import com.romario.gerenciador_de_produtos.business.exceptions.BadRequestException;
import com.romario.gerenciador_de_produtos.business.exceptions.NotFoundtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundtException.class)
    public ResponseEntity<String> notFoundExceptionHandler(NotFoundtException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequestExceptionHandler(BadRequestException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
