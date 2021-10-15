package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.UserDto;
import org.springframework.util.StringUtils;

public class UserValidator {

  public static List<String> validate(UserDto userDto) {
    List<String> errors = new ArrayList<>();

    if (userDto == null) {
      errors.add("'Please fill the user name'");
      errors.add("'Please fill the user lastname'");
      errors.add("'Please fill the user password'");
      errors.add("'Please fill the user address'");
      errors.addAll(AddressValidator.validate(null));
      return errors;
    }

    if (!StringUtils.hasLength(userDto.getName())) {
      errors.add("'Please fill the user name'");
    }
    if (!StringUtils.hasLength(userDto.getLastname())) {
      errors.add("'Please fill the user lastname'");
    }
    if (!StringUtils.hasLength(userDto.getEmail())) {
      errors.add("'Please fill the user email'");
    }
    if (!StringUtils.hasLength(userDto.getPassword())) {
      errors.add("'Please fill the user password'");
    }
    if (userDto.getBirthDate() == null) {
      errors.add("'Please fill the user birth date'");
    }
    errors.addAll(AddressValidator.validate(userDto.getAddress()));

    return errors;
  }

}
