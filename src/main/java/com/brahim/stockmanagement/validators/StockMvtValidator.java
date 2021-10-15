package com.brahim.stockmanagement.validators;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.brahim.stockmanagement.dto.StockMvtDto;
import org.springframework.util.StringUtils;

public class StockMvtValidator {

  public static List<String> validate(StockMvtDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("'Please fill the movement date'");
      errors.add("'Please fill the movement quantity'");
      errors.add("'Please fill the article'");
      errors.add("'Please select the movement type'");

      return errors;
    }
    if (dto.getMvtDate() == null) {
      errors.add("'Please fill the movement date'");
    }
    if (dto.getQuantity() == null || dto.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
      errors.add("'Please fill the movement quantity'");
    }
    if (dto.getArticle() == null || dto.getArticle().getId() == null) {
      errors.add("'Please fill the article'");
    }
    if (!StringUtils.hasLength(dto.getTypeStockMvt().name())) {
      errors.add("'Please select the movement type'");
    }

    return errors;
  }

}
