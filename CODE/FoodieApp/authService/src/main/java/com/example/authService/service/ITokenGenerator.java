package com.example.authService.service;

import com.example.authService.domain.User;
import java.util.Map;

public interface ITokenGenerator {
    Map<String,String> storeToken(User user);
}