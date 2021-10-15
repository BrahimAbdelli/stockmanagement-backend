package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.AddressDto;
import org.springframework.util.StringUtils;

public class AddressValidator {

  public static List<String> validate(AddressDto addressDto) {
    List<String> errors = new ArrayList<>();

    if (addressDto == null) {
      errors.add("'Please fill the address°1'");
      errors.add("'Please fill the city'");
      errors.add("'Please fill the country'");
      errors.add("'Please fill the postal code'");
      return errors;
    }
    if (!StringUtils.hasLength(addressDto.getAddress1())) {
      errors.add("'Please fill the address°1'");
    }
    if (!StringUtils.hasLength(addressDto.getCity())) {
      errors.add("'Please fill the city'");
    }
    if (!StringUtils.hasLength(addressDto.getCountry())) {
      errors.add("'Please fill the country'");
    }
    if (!StringUtils.hasLength(addressDto.getPostalCode())) {
      errors.add("'Please fill the postal code'");
    }
    return errors;
  }

}
