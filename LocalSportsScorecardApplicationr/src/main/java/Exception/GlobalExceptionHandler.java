package com.example.demo.Exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.example.demo.response.ResponceStructure;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

   
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponceStructure<String>> handleNullPointer(NullPointerException ex) {

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setMessage("Null value encountered: " + ex.getMessage());
        rs.setData(null);
        rs.setStatusCode(404);

        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
    }

    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponceStructure<String>> handleRuntime(RuntimeException ex) {

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setMessage("Runtime error: " + ex.getMessage());
        rs.setData(null);
        rs.setStatusCode(500);

        return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // 🔴 4. Handle Validation Errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponceStructure<String>> handleValidation(MethodArgumentNotValidException ex) {

        String msg = ex.getBindingResult()
                       .getFieldError()
                       .getDefaultMessage();

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setMessage(msg);
        rs.setData(null);
        rs.setStatusCode(400);

        return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
    }

    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponceStructure<String>> handleConstraint(ConstraintViolationException ex) {

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setMessage(ex.getMessage());
        rs.setData(null);
        rs.setStatusCode(400);

        return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
    }

   
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponceStructure<String>> handleAll(Exception ex) {

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setMessage("Unexpected error: " + ex.getMessage());
        rs.setData(null);
        rs.setStatusCode(500);

        return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}