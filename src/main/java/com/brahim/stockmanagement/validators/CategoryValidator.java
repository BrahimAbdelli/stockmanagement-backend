package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.CategoryDto;
import org.springframework.util.StringUtils;

public class CategoryValidator {

  public static List<String> validate(CategoryDto categoryDto) {
    List<String> errors = new ArrayList<>();

    if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
      errors.add("'Please fill the code'");
    }
    return errors;
  }

}
