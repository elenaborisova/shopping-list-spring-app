package com.example.shoppinglistapp.services;

import com.example.shoppinglistapp.models.entities.enums.CategoryNameEnum;
import com.example.shoppinglistapp.models.services.ProductServiceModel;
import com.example.shoppinglistapp.models.views.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalProductsPrice();

    List<ProductViewModel> getAllProductsByCategoryName(CategoryNameEnum categoryName);

    void buyById(String id);

    void buyAll();
}
