package com.example.shoppinglistapp.services.impl;

import com.example.shoppinglistapp.models.entities.UserEntity;
import com.example.shoppinglistapp.models.services.UserServiceModel;
import com.example.shoppinglistapp.repositories.UserRepository;
import com.example.shoppinglistapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(user);
    }
}
