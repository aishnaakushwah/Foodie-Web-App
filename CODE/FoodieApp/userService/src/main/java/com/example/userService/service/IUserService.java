package com.example.userService.service;

import com.example.userService.domain.Address;
import com.example.userService.domain.Favourites;
import com.example.userService.domain.User;
import com.example.userService.exception.FavouriteItemNotFoundException;
import com.example.userService.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {
    public User addUser (User user);
    public User addFavouritesInList (String email, Favourites favouritesCart);
    public User updateUser(String email,User updatedUser) throws UserNotFoundException;
    public List<Favourites> getListOfFavouriteById(String email)throws FavouriteItemNotFoundException;
    public void removeFavouriteById(String email,int itemId)throws FavouriteItemNotFoundException;
    public boolean favItemExist(String email,int itemId);
    public byte[] getUserProfileImg(String email);
    public User getUserName(String email);
    public boolean addAddress(String email, Address address);
    public Address getAddress(String email);


}