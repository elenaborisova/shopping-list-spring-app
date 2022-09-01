package com.example.shoppinglistapp.services.impl;

import com.example.shoppinglistapp.models.entities.CategoryEntity;
import com.example.shoppinglistapp.models.entities.enums.CategoryNameEnum;
import com.example.shoppinglistapp.repositories.CategoryRepository;
import com.example.shoppinglistapp.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryName -> {
                        CategoryEntity category = new CategoryEntity(
                                categoryName, "Description for " + categoryName.name());

                        categoryRepository.save(category);
                    });
        }
    }
}
