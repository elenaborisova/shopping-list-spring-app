package com.example.shoppinglistapp.repositories;

import com.example.shoppinglistapp.models.entities.CategoryEntity;
import com.example.shoppinglistapp.models.entities.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    Optional<CategoryEntity> findByName(CategoryNameEnum name);
}
