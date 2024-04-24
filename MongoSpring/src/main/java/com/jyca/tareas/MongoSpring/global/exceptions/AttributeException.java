package com.jyca.tareas.MongoSpring.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttributeException extends Exception{
    public AttributeException(String message) {
        super(message);
    }

}
