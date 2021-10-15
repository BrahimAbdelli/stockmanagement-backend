package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.ArticleDto;
import org.springframework.util.StringUtils;

public class ArticleValidator {

  public static List<String> validate(ArticleDto dto) {
    List<String> errors = new ArrayList<>();

    if (dto == null) {
      errors.add("'Please fill the code'");
      errors.add("'Please fill the designation'");
      errors.add("'Please fill the unit price excluding tax'");
      errors.add("'Please fill the VAT rate'");
      errors.add("'Please fill the unit price incl.'");
      errors.add("'Please select a category'");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getCode())) {
      errors.add("'Please fill the code'");
    }
    if (!StringUtils.hasLength(dto.getDesignation())) {
      errors.add("'Please fill the designation'");
    }
    if (dto.getUnitPriceET() == null) {
      errors.add("'Please fill the unit price excluding tax'");
    }
    if (dto.getRateVAT() == null) {
      errors.add("'Please fill the VAT rate'");
    }
    if (dto.getUnitPriceIncl() == null) {
      errors.add("'Please fill the unit price incl.'");
    }
    if (dto.getCategory() == null || dto.getCategory().getId() == null) {
      errors.add("'Please select a category'");
    }
    return errors;
  }

}
