package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.ClientDto;
import org.springframework.util.StringUtils;

public class ClientValidator {

  public static List<String> validate(ClientDto dto) {
    List<String> errors = new ArrayList<>();

    if (dto == null) {
      errors.add("'Please fill the client name'");
      errors.add("'Please fill the client lastname'");
      errors.add("'Please fill the client mail'");
      errors.add("'Please fill the client phone'");
      errors.addAll(AddressValidator.validate(null));
      return errors;
    }

    if (!StringUtils.hasLength(dto.getName())) {
      errors.add("'Please fill the client name'");
    }
    if (!StringUtils.hasLength(dto.getLastname())) {
      errors.add("'Please fill the client lastname'");
    }
    if (!StringUtils.hasLength(dto.getMail())) {
      errors.add("'Please fill the client mail'");
    }
    if (!StringUtils.hasLength(dto.getPhone())) {
      errors.add("'Please fill the client phone'");
    }
    errors.addAll(AddressValidator.validate(dto.getAddress()));
    return errors;
  }

}
