package com.brahim.stockmanagement.dto;

import java.math.BigDecimal;

import com.brahim.stockmanagement.model.SaleLine;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaleLineDto {

  private Integer id;

  private SalesDto sale;

  private ArticleDto article;

  private BigDecimal quantity;

  private BigDecimal unitPrice;

  private Integer idCompany;

  public static SaleLineDto fromEntity(SaleLine saleLine) {
    if (saleLine == null) {
      return null;
    }

    return SaleLineDto.builder()
        .id(saleLine.getId())
        .sale(SalesDto.fromEntity(saleLine.getSale()))
        .article(ArticleDto.fromEntity(saleLine.getArticle()))
        .quantity(saleLine.getQuantity())
        .unitPrice(saleLine.getUnitPrice())
        .idCompany(saleLine.getIdCompany())
        .build();
  }

  public static SaleLine toEntity(SaleLineDto dto) {
    if (dto == null) {
      return null;
    }
    SaleLine saleLine = new SaleLine();
    saleLine.setId(dto.getId());
    saleLine.setSale(SalesDto.toEntity(dto.getSale()));
    saleLine.setArticle(ArticleDto.toEntity(dto.getArticle()));
    saleLine.setQuantity(dto.getQuantity());
    saleLine.setUnitPrice(dto.getUnitPrice());
    saleLine.setIdCompany(dto.getIdCompany());
    return saleLine;
  }

}
