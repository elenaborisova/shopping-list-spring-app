package com.example.shoppinglistapp.services.impl;

import com.example.shoppinglistapp.models.entities.CategoryEntity;
import com.example.shoppinglistapp.models.entities.ProductEntity;
import com.example.shoppinglistapp.models.services.ProductServiceModel;
import com.example.shoppinglistapp.repositories.ProductRepository;
import com.example.shoppinglistapp.services.CategoryService;
import com.example.shoppinglistapp.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        ProductEntity productEntity = modelMapper.map(productServiceModel, ProductEntity.class);
        CategoryEntity categoryEntity = categoryService.findByName(productServiceModel.getCategory());

        productEntity.setCategory(categoryEntity);

        productRepository.save(productEntity);
    }
}
