package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.CompanyDto;
import org.springframework.util.StringUtils;

public class CompanyValidator {

  public static List<String> validate(CompanyDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("'Please fill the company name'");
      errors.add("'Please fill the company description'");
      errors.add("'Please fill the company tax code'");
      errors.add("'Please fill the company email'");
      errors.add("'Please fill the company phone'");
      errors.addAll(AddressValidator.validate(null));
      return errors;
    }

    if (!StringUtils.hasLength(dto.getName())) {
      errors.add("'Please fill the company name'");
    }
    if (!StringUtils.hasLength(dto.getDescription())) {
      errors.add("'Please fill the company description'");
    }
    if (!StringUtils.hasLength(dto.getTaxCode())) {
      errors.add("'Please fill the company tax code'");
    }
    if (!StringUtils.hasLength(dto.getEmail())) {
      errors.add("'Please fill the company email'");
    }
    if (!StringUtils.hasLength(dto.getPhone())) {
      errors.add("'Please fill the company phone'");
    }

    errors.addAll(AddressValidator.validate(dto.getAddress()));
    return errors;
  }

}
