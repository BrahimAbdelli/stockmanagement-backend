package com.brahim.stockmanagement.repository;

import java.math.BigDecimal;
import java.util.List;

import com.brahim.stockmanagement.model.StockMvt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockMvtRepository extends JpaRepository<StockMvt, Integer> {

  @Query("select sum(m.quantity) from StockMvt m where m.article.id = :idArticle")
  BigDecimal stockRealArticle(@Param("idArticle") Integer idArticle);

  List<StockMvt> findAllByArticleId(Integer idArticle);

}
