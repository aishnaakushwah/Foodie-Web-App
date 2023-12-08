package com.example.Restaurantservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Restaurant of this id is not found")
public class RestaurantNotFoundException extends Exception {
}