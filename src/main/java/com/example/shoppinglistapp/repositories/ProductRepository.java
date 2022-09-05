package com.example.shoppinglistapp.repositories;

import com.example.shoppinglistapp.models.entities.ProductEntity;
import com.example.shoppinglistapp.models.entities.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query("SELECT SUM(p.price) FROM ProductEntity P")
    BigDecimal findTotalProductsPrice();

    List<ProductEntity> findAllByCategory_Name(CategoryNameEnum categoryName);
}
