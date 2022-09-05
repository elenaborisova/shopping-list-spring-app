package com.example.shoppinglistapp.services;

import com.example.shoppinglistapp.models.services.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
