package com.brahim.stockmanagement.dto;

import com.brahim.stockmanagement.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

  private Integer id;

  private String code;

  private String designation;

  private Integer idCompany;

  @JsonIgnore
  private List<ArticleDto> articles;

  public static CategoryDto fromEntity(Category category) {
    if (category == null) {
      return null;
      // TODO throw an exception
    }

    return CategoryDto.builder()
        .id(category.getId())
        .code(category.getCode())
        .designation(category.getDesignation())
        .idCompany(category.getIdCompany())
        .build();
  }

  public static Category toEntity(CategoryDto categoryDto) {
    if (categoryDto == null) {
      return null;
      // TODO throw an exception
    }

    Category category = new Category();
    category.setId(categoryDto.getId());
    category.setCode(categoryDto.getCode());
    category.setDesignation(categoryDto.getDesignation());
    category.setIdCompany(categoryDto.getIdCompany());

    return category;
  }
}
