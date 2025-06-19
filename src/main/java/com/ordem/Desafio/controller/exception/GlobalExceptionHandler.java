package com.ordem.Desafio.controller.exception;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException noFoundException){
        return  new ResponseEntity<>("Id não  localizado.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedExceptiom(Throwable unexpectedExceptiom){
        var message = "Unespecte Server Error, see the logs.";
        logger.error(message, unexpectedExceptiom);
        return  new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
