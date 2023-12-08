package com.example.authService.service;

import com.example.authService.exception.UserNotFoundException;
import com.example.authService.domain.User;

public interface IUserService {
    User login(User user)throws UserNotFoundException;
    User register (User user);
    User UpdateUser(String email, User user) throws UserNotFoundException;
    void removeUser(String email);
}