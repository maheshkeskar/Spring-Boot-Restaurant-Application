package com.mahesh101.Restaurant.Management.CustomExcepiton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestaurantNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RestaurantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String RestaurantNotFoundHandler(RestaurantNotFoundException ex){
        return ex.getMessage();
    }
}