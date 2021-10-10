package com.brahim.stockmanagement.dto;

import java.math.BigDecimal;

import com.brahim.stockmanagement.model.Article;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDto {

  private Integer id;

  private String code;

  private String designation;

  private BigDecimal unitPriceET;

  private BigDecimal rateVAT;

  private BigDecimal unitPriceIncl;

  private String photo;

  private CategoryDto category;

  private Integer idCompany;

  public static ArticleDto fromEntity(Article article) {
    if (article == null) {
      return null;
    }
    return ArticleDto.builder()
        .id(article.getId())
        .code(article.getCode())
        .designation(article.getDesignation())
        .photo(article.getPhoto())
        .unitPriceET(article.getUnitPriceET())
        .unitPriceIncl(article.getUnitPriceIncl())
        .rateVAT(article.getRateVAT())
        .idCompany(article.getIdCompany())
        .category(CategoryDto.fromEntity(article.getCategory()))
        .build();
  }

  public static Article toEntity(ArticleDto articleDto) {
    if (articleDto == null) {
      return null;
    }
    Article article = new Article();
    article.setId(articleDto.getId());
    article.setCode(articleDto.getCode());
    article.setDesignation(articleDto.getDesignation());
    article.setPhoto(articleDto.getPhoto());
    article.setUnitPriceET(articleDto.getUnitPriceET());
    article.setUnitPriceIncl(articleDto.getUnitPriceIncl());
    article.setRateVAT(articleDto.getRateVAT());
    article.setIdCompany(articleDto.getIdCompany());
    article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
    return article;
  }

}
