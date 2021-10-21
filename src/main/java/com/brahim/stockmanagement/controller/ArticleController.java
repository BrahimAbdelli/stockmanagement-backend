package com.brahim.stockmanagement.controller;

import com.brahim.stockmanagement.controller.api.ArticleApi;
import com.brahim.stockmanagement.dto.ArticleDto;
import com.brahim.stockmanagement.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    // Field Injection
/*    @Autowired
    private ArticleService articleService;*/

    // Getter Injection
/*    @Autowired
    public ArticleService getArticleService() {
        return articleService;
    }*/

    // Constructor Injection
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCode(String code) {
        return articleService.findByCode(code);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);

    }
}
