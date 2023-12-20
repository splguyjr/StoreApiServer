package com.example.cloudproject.storeapi.repository;

import com.example.cloudproject.storeapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
