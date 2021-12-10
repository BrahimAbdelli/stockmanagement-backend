package com.brahim.stockmanagement.dto;

import com.brahim.stockmanagement.model.OrderLineClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderLineClientDto {

  private Integer id;

  private ArticleDto article;

  @JsonIgnore
  private OrderClientDto orderClient;

  private BigDecimal quantity;

  private BigDecimal unitPrice;

  private Integer idCompany;

  public static OrderLineClientDto fromEntity(OrderLineClient orderLineClient) {
    if (orderLineClient == null) {
      return null;
    }
    return OrderLineClientDto.builder()
        .id(orderLineClient.getId())
        .article(ArticleDto.fromEntity(orderLineClient.getArticle()))
        .quantity(orderLineClient.getQuantity())
        .unitPrice(orderLineClient.getUnitPrice())
        .idCompany(orderLineClient.getIdCompany())
        .build();
  }

  public static OrderLineClient toEntity(OrderLineClientDto dto) {
    if (dto == null) {
      return null;
    }

    OrderLineClient orderLineClient = new OrderLineClient();
    orderLineClient.setId(dto.getId());
    orderLineClient.setArticle(ArticleDto.toEntity(dto.getArticle()));
    orderLineClient.setUnitPrice(dto.getUnitPrice());
    orderLineClient.setQuantity(dto.getQuantity());
    orderLineClient.setIdCompany(dto.getIdCompany());
    return orderLineClient;
  }

}
