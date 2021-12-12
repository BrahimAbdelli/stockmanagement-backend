package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.OrderProviderDto;
import org.springframework.util.StringUtils;

public class OrderProviderValidator {

  public static List<String> validate(OrderProviderDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("'Please fill the order code'");
      errors.add("'Please fill the order date'");
      //errors.add("'Please fill the order state'");
      errors.add("'Please fill the client'");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getCode())) {
      errors.add("'Please fill the order code'");
    }
    if (dto.getOrderDate() == null) {
      errors.add("'Please fill the order date'");
    }
/*    if (!StringUtils.hasLength(dto.getOrderStatus().toString())) {
      //errors.add("'Please fill the order state'");
    }*/
    if (dto.getProvider() == null || dto.getProvider().getId() == null) {
      errors.add("'Please fill the client'");
    }

    return errors;
  }

}
