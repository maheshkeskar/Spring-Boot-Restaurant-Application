package com.mahesh101.Restaurant.Management.CustomExcepiton;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(Long id){
        super(("Could not find restaurant"+id));
    }
}
