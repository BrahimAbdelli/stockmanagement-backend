package com.brahim.stockmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.brahim.stockmanagement.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

/*  @Query("select a from article where code=:code and designation = :designation")
  List<Article> findByCustomQuery(@Param ("code") String c, @Param("designation") String d);

  @Query(value="select * from article where code=:code",nativeQuery = true)
  List<Article> findByNativeQuery(@Param ("code") String c);*/

  List<Article> findByCodeIgnoreCaseAndDesignation(String code, String designation);

  Optional<Article> findArticleByCode(String code);

  List<Article> findAllByCategoryId(Integer idCategory);


}
