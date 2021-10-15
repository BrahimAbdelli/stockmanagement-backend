package com.brahim.stockmanagement.validators;

import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.OrderClientDTO;
import org.springframework.util.StringUtils;

public class OrderClientValidator {


  public static List<String> validate(OrderClientDTO dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("'Please fill the order code'");
      errors.add("'Please fill the order date'");
      //errors.add("'Please select the order state'");
      errors.add("'Please fill the client'");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getCode())) {
      errors.add("'Please fill the order code'");
    }
    if (dto.getCommandDate() == null) {
      errors.add("'Please fill the order date'");
    }
/*    if (!StringUtils.hasLength(dto.getOrderStatus().toString())) {
      errors.add("'Please select the order status'");
    }*/
    if (dto.getClient() == null || dto.getClient().getId() == null) {
      errors.add("'Please fill the client'");
    }

    return errors;
  }

}
