package com.example.Restaurantservice.service;

import com.example.Restaurantservice.domain.Restaurant;
import com.example.Restaurantservice.domain.FoodItems;
import com.example.Restaurantservice.exception.FoodItemNotFoundException;
import com.example.Restaurantservice.exception.RestaurantAlreadyExistsException;
import com.example.Restaurantservice.exception.RestaurantNotFoundException;

import java.util.List;

public interface IRestaurantService {
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistsException;   //save
    public List<Restaurant> getAllRestaurant();  //findAll
    public Restaurant getRestaurantByLocation(String location); //findByLocation
    public Restaurant getByRating(double rating); //findByRating
    public Restaurant updateRestaurant(Restaurant restaurant,int restaurantId) throws RestaurantNotFoundException;   //save -update
    public Restaurant getById(int restaurantId);     //findById
    public boolean deleteById(int restaurantId) throws RestaurantNotFoundException;
    public List<FoodItems> getItems(int id) throws RestaurantNotFoundException;
    public Restaurant updateFoodItem(int restaurantId, FoodItems newFoodItem) throws RestaurantNotFoundException, FoodItemNotFoundException;
    public boolean deleteFoodItem(int restaurantId, FoodItems foodItems) throws RestaurantNotFoundException, FoodItemNotFoundException;
}
