package com.mahesh101.Restaurant.Management.CustomExcepiton;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }
}
