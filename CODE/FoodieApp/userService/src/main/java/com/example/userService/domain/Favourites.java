package com.example.userService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Favourites {
    @Id
    private int itemId;
    private String itemName;
    private float itemPrice;
    private float itemRating;
    private String imageUrl;

}