package com.mahesh101.Restaurant.Management.Repository;

import com.mahesh101.Restaurant.Management.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{
}
