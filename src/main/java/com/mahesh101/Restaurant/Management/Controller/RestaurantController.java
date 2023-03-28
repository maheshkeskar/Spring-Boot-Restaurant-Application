package com.mahesh101.Restaurant.Management.Controller;

import com.mahesh101.Restaurant.Management.CustomExcepiton.RestaurantNotFoundException;
import com.mahesh101.Restaurant.Management.Model.Restaurant;
import com.mahesh101.Restaurant.Management.Repository.RestaurantRepository;
import com.mahesh101.Restaurant.Management.assemblers.RestaurantModelAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController

@Slf4j

public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantModelAssembler restaurantModelAssembler;


    RestaurantController(RestaurantRepository repository, RestaurantModelAssembler restaurantModelAssembler) {
        this.restaurantModelAssembler = restaurantModelAssembler;
        log.info("RestaurantRepository bean:" + repository.toString());
        this.restaurantRepository = repository;
    }

    @GetMapping("/restaurant")

    public CollectionModel<EntityModel<Restaurant>> all() {

        List<EntityModel<Restaurant>> restaurant = (List<EntityModel<Restaurant>>) restaurantRepository.findAll()
                .stream()
                .map(restaurantModelAssembler::toModel)
                .toList();

        return CollectionModel.of(restaurant,
                linkTo(methodOn(RestaurantController.class).all()).withSelfRel());
    }
    @GetMapping("/restaurant/{id}")
    public EntityModel<Restaurant>one(@PathVariable(name="id",required = true)Long id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFoundException(id));
        return restaurantModelAssembler.toModel(restaurant);
    }
    @PostMapping("/restaurant")
    ResponseEntity<?> newRestaurant(@RequestBody Restaurant newRestaurant){

        EntityModel<Restaurant>entityModel = restaurantModelAssembler.toModel(restaurantRepository.save(newRestaurant));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }
    @PutMapping("/restaurant/{id}")
    ResponseEntity<?> replaceRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable Long id ){

        Restaurant updatedRestaurant = restaurantRepository.findById(id)
                .map(restaurant -> {
                    restaurant.setDishName(newRestaurant.getDishName());
                    restaurant.setDishPrice(newRestaurant.getDishPrice());
                    return restaurantRepository.save(restaurant);
                })  //
                .orElseGet(()->{
                    newRestaurant.setID(id);
                    return restaurantRepository.save((newRestaurant));
                });
        EntityModel<Restaurant>entityModel = restaurantModelAssembler.toModel(updatedRestaurant);
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);



    }


}
