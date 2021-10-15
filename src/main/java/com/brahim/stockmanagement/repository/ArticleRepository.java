package com.brahim.stockmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.brahim.stockmanagement.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
