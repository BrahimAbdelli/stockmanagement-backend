package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.SalesDto;
import org.springframework.util.StringUtils;

public class SalesValidator {

  public static List<String> validate(SalesDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("'Please fill the sales code'");
      errors.add("'Please fill the sales date'");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getCode())) {
      errors.add("'Please fill the sales code'");
    }
    if (dto.getSaleDate() == null) {
      errors.add("'Please fill the sales date'");
    }

    return errors;
  }

}
