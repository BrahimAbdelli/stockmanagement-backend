package com.brahim.stockmanagement.dto;

import java.time.Instant;
import java.util.List;

import com.brahim.stockmanagement.model.Sales;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalesDto {

  private Integer id;

  private String code;

  private Instant saleDate;

  private String commentary;

  private List<SaleLineDto> saleLines;

  private Integer idCompany;

  public static SalesDto fromEntity(Sales sales) {
    if (sales == null) {
      return null;
    }
    return SalesDto.builder()
        .id(sales.getId())
        .code(sales.getCode())
        .commentary(sales.getCommentary())
        .idCompany(sales.getIdComapny())
        .build();
  }

  public static Sales toEntity(SalesDto dto) {
    if (dto == null) {
      return null;
    }
    Sales sales = new Sales();
    sales.setId(dto.getId());
    sales.setCode(sales.getCode());
    sales.setCommentary(dto.getCommentary());
    sales.setIdComapny(dto.getIdCompany());
    return sales;
  }
}
