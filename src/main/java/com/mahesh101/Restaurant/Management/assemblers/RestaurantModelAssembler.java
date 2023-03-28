package com.mahesh101.Restaurant.Management.assemblers;

import com.mahesh101.Restaurant.Management.Controller.RestaurantController;
import com.mahesh101.Restaurant.Management.Model.Restaurant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Qualifier("restaurantModelAssembler")

public class RestaurantModelAssembler implements RepresentationModelAssembler<Restaurant, EntityModel<Restaurant>>{


    @Override
    public EntityModel<Restaurant> toModel(Restaurant restaurant) {
       return EntityModel.of(restaurant,
               linkTo(methodOn(RestaurantController.class).one(restaurant.getID())).withSelfRel(),
               linkTo(methodOn(RestaurantController.class).all()).withRel(("all_restaurant")));
    }


    }

