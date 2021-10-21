package com.brahim.stockmanagement.services;

import com.brahim.stockmanagement.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    List<CategoryDto> findAll();

    void delete(Integer id);

}
