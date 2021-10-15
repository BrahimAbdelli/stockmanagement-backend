package com.brahim.stockmanagement.repository;

import java.util.Optional;

import com.brahim.stockmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
