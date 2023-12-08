package com.example.Restaurantservice.repository;

import com.example.Restaurantservice.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,Integer> {

    public Restaurant findByLocation(String location);
    public Restaurant findByRating(double rating);
}