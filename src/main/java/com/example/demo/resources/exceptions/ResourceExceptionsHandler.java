package com.example.demo.resources.exceptions;

import com.example.demo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionsHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectnotfound(ObjectNotFoundException e, HttpServletRequest h){
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Id Nao Encontrado",
                e.getMessage(),
                h.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> objectnotvalid(MethodArgumentNotValidException e, HttpServletRequest h){
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;

        StandardError err = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Objeto Invalido",
                "Algum Campo Esta Incorreto.",
                h.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }



}
