package com.mahesh101.Restaurant.Management.Configs;


import com.mahesh101.Restaurant.Management.Model.Restaurant;
import com.mahesh101.Restaurant.Management.Repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log= LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner commandLineRunner(RestaurantRepository restaurantRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("Preloading " + restaurantRepository.save(new Restaurant("Chicken Thali", 350, 1)));
                log.info("Preloading " + restaurantRepository.save(new Restaurant("Mutton Thali", 450, 2)));
                log.info("Preloading " + restaurantRepository.save(new Restaurant("veg", 150, 3)));





            }


        };
        }
    }

