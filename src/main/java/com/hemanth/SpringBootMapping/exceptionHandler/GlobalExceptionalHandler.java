package com.hemanth.SpringBootMapping.exceptionHandler;


import com.hemanth.SpringBootMapping.exception.StudentIdNotFoundException;
import com.hemanth.SpringBootMapping.exception.UniversityIdNotFoundException;
import com.hemanth.SpringBootMapping.messageFormat.MessageFormat;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice

public class GlobalExceptionalHandler
{


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {

        List<String> errors = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            errors.add(error.getDefaultMessage());
        }

        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

    @ExceptionHandler
    ResponseEntity<MessageFormat> handleException(StudentIdNotFoundException sn)
    {
        MessageFormat messageFormat=new MessageFormat();
        messageFormat.setStatusCode(HttpStatus.NOT_FOUND.value());
        messageFormat.setMessage(sn.getMessage());
        messageFormat.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(messageFormat,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    ResponseEntity<MessageFormat> handleException(UniversityIdNotFoundException un)
    {
        MessageFormat messageFormat=new MessageFormat();
        messageFormat.setStatusCode(HttpStatus.NOT_FOUND.value());
        messageFormat.setMessage(un.getMessage());
        messageFormat.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(messageFormat,HttpStatus.NOT_FOUND);

    }









}
