package com.jyca.tareas.MongoSpring.global.exceptions;

import com.jyca.tareas.MongoSpring.global.dto.MessageDto;
import com.jyca.tareas.MongoSpring.global.utils.Operations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDto> throwNotFounfException(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageDto(HttpStatus.NOT_FOUND, e.getMessage()));
    }
    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MessageDto> throwAttributeException(AttributeException e){
        return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageDto> generalException(Exception e){
        return ResponseEntity.internalServerError().body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDto> validationException(MethodArgumentNotValidException e) {
        List<String> messages = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(
                (error) -> {messages.add(error.getDefaultMessage());
    });
        return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, Operations.trimBrackets(messages.toString())));
    }
}
