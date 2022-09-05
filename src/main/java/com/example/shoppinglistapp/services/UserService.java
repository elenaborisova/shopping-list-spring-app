package com.example.shoppinglistapp.services;

import com.example.shoppinglistapp.models.services.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
