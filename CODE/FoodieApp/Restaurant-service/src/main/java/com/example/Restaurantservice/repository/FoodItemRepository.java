package com.example.Restaurantservice.repository;

import com.example.Restaurantservice.domain.FoodItems;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends MongoRepository<FoodItems,Integer> {
    public FoodItems findByItemName(String itemName);
}
