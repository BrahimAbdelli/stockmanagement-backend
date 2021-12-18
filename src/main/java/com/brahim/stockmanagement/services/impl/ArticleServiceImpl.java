package com.brahim.stockmanagement.services.impl;

import com.brahim.stockmanagement.dto.ArticleDto;
import com.brahim.stockmanagement.exception.EntityNotFoundException;
import com.brahim.stockmanagement.exception.ErrorCodes;
import com.brahim.stockmanagement.exception.InvalidEntityException;
import com.brahim.stockmanagement.repository.ArticleRepository;
import com.brahim.stockmanagement.services.ArticleService;
import com.brahim.stockmanagement.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("The article is not valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        return articleRepository.findById(id).map(ArticleDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "No article with the ID = " + id + " was found",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Article Code is null");
            return null;
        }

        return articleRepository.findArticleByCode(code)
                .map(ArticleDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "No article with the Code = " + code + " was found",
                                ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);
    }
}


