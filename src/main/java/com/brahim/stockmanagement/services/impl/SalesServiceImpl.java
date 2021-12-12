package com.brahim.stockmanagement.services.impl;

import com.brahim.stockmanagement.dto.SaleLineDto;
import com.brahim.stockmanagement.dto.SalesDto;
import com.brahim.stockmanagement.exception.EntityNotFoundException;
import com.brahim.stockmanagement.exception.ErrorCodes;
import com.brahim.stockmanagement.exception.InvalidEntityException;
import com.brahim.stockmanagement.exception.InvalidOperationException;
import com.brahim.stockmanagement.model.Article;
import com.brahim.stockmanagement.model.SaleLine;
import com.brahim.stockmanagement.model.Sales;
import com.brahim.stockmanagement.repository.ArticleRepository;
import com.brahim.stockmanagement.repository.SaleLineRepository;
import com.brahim.stockmanagement.repository.SalesRepository;
import com.brahim.stockmanagement.services.SalesService;
import com.brahim.stockmanagement.validators.SalesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SalesServiceImpl implements SalesService {

    private ArticleRepository articleRepository;
    private SalesRepository salesRepository;
    private SaleLineRepository saleLineRepository;
    //private MvtStkService mvtStkService;

    @Autowired
    public SalesServiceImpl(ArticleRepository articleRepository, SalesRepository salesRepository,
                            SaleLineRepository saleLineRepository) {
        this.articleRepository = articleRepository;
        this.salesRepository = salesRepository;
        this.saleLineRepository = saleLineRepository;
        //this.mvtStkService = mvtStkService;
    }

    @Override
    public SalesDto save(SalesDto dto) {
        List<String> errors = SalesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Sales is not valid");
            throw new InvalidEntityException("The sale object is not valid", ErrorCodes.SALE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getSaleLines().forEach(saleLineDto -> {
            Optional<Article> article = articleRepository.findById(saleLineDto.getArticle().getId());
            if (articleErrors.isEmpty()) {
                articleErrors.add("No article with the ID " + saleLineDto.getArticle().getId() + " was found");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("One or more articles were not found in the DB, {}", errors);
            throw new InvalidEntityException("One or more articles were not found in the DB", ErrorCodes.SALE_NOT_VALID, errors);
        }

        Sales savedSales = salesRepository.save(SalesDto.toEntity(dto));

        dto.getSaleLines().forEach(saleLineDto -> {
            SaleLine saleLine = SaleLineDto.toEntity(saleLineDto);
            saleLine.setSale(savedSales);
            saleLineRepository.save(saleLine);
            //updateMvtStk(ligneVente);
        });

        return SalesDto.fromEntity(savedSales);
    }

    @Override
    public SalesDto findById(Integer id) {
        if (id == null) {
            log.error("Sale ID is NULL");
            return null;
        }
        return salesRepository.findById(id)
                .map(SalesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No order with the ID = " + id + " was found", ErrorCodes.SALE_NOT_FOUND));
    }

    @Override
    public SalesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Sale CODE is NULL");
            return null;
        }
        return salesRepository.findSalesByCode(code)
                .map(SalesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No order with the code = " + code + " was found", ErrorCodes.SALE_NOT_VALID
                ));
    }

    @Override
    public List<SalesDto> findAll() {
        return salesRepository.findAll().stream()
                .map(SalesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Sale ID is NULL");
            return;
        }
        List<SaleLine> saleLines = saleLineRepository.findAllBySaleId(id);
        if (!saleLines.isEmpty()) {
            throw new InvalidOperationException("Impossible to delete a sale ...",
                    ErrorCodes.SALE_ALREADY_IN_USE);
        }
        salesRepository.deleteById(id);
    }


}
