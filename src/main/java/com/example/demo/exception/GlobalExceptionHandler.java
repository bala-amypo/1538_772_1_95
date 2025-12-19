package com.example.demo.exception;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(BadRequestException.class)
public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
}


@ExceptionHandler(ConflictException.class)
public ResponseEntity<String> handleConflict(ConflictException ex) {
return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
}


@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleGeneral(Exception ex) {
return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}
}