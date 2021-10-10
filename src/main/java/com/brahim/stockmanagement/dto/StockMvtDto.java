package com.brahim.stockmanagement.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.brahim.stockmanagement.model.StockMvt;
import com.brahim.stockmanagement.model.TypeStockMvt;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockMvtDto {

  private Integer id;

  private Instant mvtDate;

  private BigDecimal quantity;

  private ArticleDto article;

  private TypeStockMvt typeStockMvt;

  //private SourceMvtStk sourceMvt;

  private Integer idCompany;

  public static StockMvtDto fromEntity(StockMvt stockMvt) {
    if (stockMvt == null) {
      return null;
    }

    return StockMvtDto.builder()
        .id(stockMvt.getId())
        .mvtDate(stockMvt.getMvtDate())
        .quantity(stockMvt.getQuantity())
        .article(ArticleDto.fromEntity(stockMvt.getArticle()))
        .typeStockMvt(stockMvt.getTypeStockMvt())
        //.sourceMvt(stockMvt.getSourceMvt())
        .idCompany(stockMvt.getIdComapny())
        .build();
  }

  public static StockMvt toEntity(StockMvtDto dto) {
    if (dto == null) {
      return null;
    }

    StockMvt stockMvt = new StockMvt();
    stockMvt.setId(dto.getId());
    stockMvt.setMvtDate(dto.getMvtDate());
    stockMvt.setQuantity(dto.getQuantity());
    stockMvt.setArticle(ArticleDto.toEntity(dto.getArticle()));
    stockMvt.setTypeStockMvt(dto.getTypeStockMvt());
    //stockMvt.setSourceMvt(dto.getSourceMvt());
    stockMvt.setIdComapny(dto.getIdCompany());
    return stockMvt;
  }
}
