package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.ProviderDto;
import org.springframework.util.StringUtils;

public class ProviderValidator {

  public static List<String> validate(ProviderDto dto) {
    List<String> errors = new ArrayList<>();

    if (dto == null) {
      errors.add("'Please fill the provider name'");
      errors.add("'Please fill the provider lastname'");
      errors.add("'Please fill the provider email'");
      errors.add("'Please fill the provider phone'");
      errors.addAll(AddressValidator.validate(null));
      return errors;
    }

    if (!StringUtils.hasLength(dto.getName())) {
      errors.add("'Please fill the provider name'");
    }
    if (!StringUtils.hasLength(dto.getLastname())) {
      errors.add("'Please fill the provider lastname'");
    }
    if (!StringUtils.hasLength(dto.getMail())) {
      errors.add("'Please fill the provider email'");
    }
    if (!StringUtils.hasLength(dto.getPhone())) {
      errors.add("'Please fill the provider phone'");
    }
    errors.addAll(AddressValidator.validate(dto.getAddress()));
    return errors;
  }

}
