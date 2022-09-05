package com.example.shoppinglistapp.services;

import com.example.shoppinglistapp.models.entities.CategoryEntity;
import com.example.shoppinglistapp.models.entities.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByName(CategoryNameEnum categoryName);
}
