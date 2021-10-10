package com.brahim.stockmanagement.dto;

import java.math.BigDecimal;

import com.brahim.stockmanagement.model.OrderLineProvider;
import com.brahim.stockmanagement.model.OrderProvider;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderLineProviderDto {

  private Integer id;

  private ArticleDto article;

  private OrderProvider orderProvider;

  private BigDecimal quantity;

  private BigDecimal unitPrice;

  private Integer idCompany;

  public static OrderLineProviderDto fromEntity(OrderLineProvider orderLineProvider) {
    if (orderLineProvider == null) {
      return null;
    }
    return OrderLineProviderDto.builder()
        .id(orderLineProvider.getId())
        .article(ArticleDto.fromEntity(orderLineProvider.getArticle()))
        .quantity(orderLineProvider.getQuantity())
        .unitPrice(orderLineProvider.getUnitPrice())
        .idCompany(orderLineProvider.getIdCompany())
        .build();
  }

  public static OrderLineProvider toEntity(OrderLineProviderDto dto) {
    if (dto == null) {
      return null;
    }

    OrderLineProvider orderLineProvider = new OrderLineProvider();
    orderLineProvider.setId(dto.getId());
    orderLineProvider.setArticle(ArticleDto.toEntity(dto.getArticle()));
    orderLineProvider.setUnitPrice(dto.getUnitPrice());
    orderLineProvider.setQuantity(dto.getQuantity());
    orderLineProvider.setIdCompany(dto.getIdCompany());
    return orderLineProvider;
  }

}
