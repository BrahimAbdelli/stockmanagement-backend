package com.brahim.stockmanagement.services.impl;

import com.brahim.stockmanagement.dto.OrderLineProviderDto;
import com.brahim.stockmanagement.dto.OrderProviderDto;
import com.brahim.stockmanagement.dto.OrderLineClientDto;
import com.brahim.stockmanagement.exception.EntityNotFoundException;
import com.brahim.stockmanagement.exception.ErrorCodes;
import com.brahim.stockmanagement.exception.InvalidEntityException;
import com.brahim.stockmanagement.exception.InvalidOperationException;
import com.brahim.stockmanagement.model.*;
import com.brahim.stockmanagement.repository.*;
import com.brahim.stockmanagement.services.OrderProviderService;
import com.brahim.stockmanagement.validators.OrderClientValidator;
import com.brahim.stockmanagement.validators.OrderProviderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderProviderServiceImpl implements OrderProviderService {

    private OrderProviderRepository orderProviderRepository;
    private OrderLineProviderRepository orderLineProviderRepository;
    private ProviderRepository providerRepository;
    private ArticleRepository articleRepository;;

    @Autowired
    public OrderProviderServiceImpl(OrderProviderRepository orderProviderRepository,
                                          ProviderRepository providerRepository, ArticleRepository articleRepository,
                                          OrderLineProviderRepository orderLineProviderRepository) {
        this.orderProviderRepository = orderProviderRepository;
        this.orderLineProviderRepository = orderLineProviderRepository;
        this.providerRepository = providerRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public OrderProviderDto save(OrderProviderDto dto) {

        List<String> providerErrors = OrderProviderValidator.validate(dto);

        if (!providerErrors.isEmpty()) {
            log.error("Order Provider is not valid ");
            throw new InvalidEntityException("The order provider is not valid", ErrorCodes.ORDER_PROVIDER_NOT_VALID, providerErrors);
        }

        Optional<Provider> provider = providerRepository.findById(dto.getProvider().getId());
        if (providerErrors.isEmpty()) {
            log.warn("Provider with ID {} was not found", dto.getProvider().getId());
            throw new EntityNotFoundException("No Provider with ID" + dto.getProvider().getId() + " n'a ete trouve dans la BDD",
                    ErrorCodes.PROVIDER_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getOrderLineProviders() != null) {
            dto.getOrderLineProviders().forEach(ligCmdFrs -> {
                if (ligCmdFrs.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdFrs.getArticle().getId());
                    if (providerErrors.isEmpty()) {
                        articleErrors.add("Article with the ID" + ligCmdFrs.getArticle().getId() + " doesn't exist");
                    }
                } else {
                    articleErrors.add("Cannot register an Order with a NULL article");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article doesn't exist", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }
        dto.setOrderDate(Instant.now());
        OrderProvider savedOrderProviders = orderProviderRepository.save(OrderProviderDto.toEntity(dto));

        if (dto.getOrderLineProviders() != null) {
            dto.getOrderLineProviders().forEach(lineOrderProviders -> {
                OrderLineProvider orderLineProvider = OrderLineProviderDto.toEntity(lineOrderProviders);
                orderLineProvider.setOrderProvider(savedOrderProviders);
                //orderLineProvider.setIdCompany(savedOrderProviders.getIdCompany());
                //OrderLineProvider saveLine = orderLineProviderRepository.save(orderLineProvider);
                orderLineProviderRepository.save(orderLineProvider);

                //effectuerEntree(saveLine);
            });
        }

        return OrderProviderDto.fromEntity(savedOrderProviders);
    }

    @Override
    public OrderProviderDto findById(Integer id) {
        if (id == null) {
            log.error("Order provider ID is NULL");
            return null;
        }
        return orderProviderRepository.findById(id)
                .map(OrderProviderDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No order with the ID = " + id + " was found", ErrorCodes.ORDER_PROVIDER_NOT_FOUND
                ));
    }

    @Override
    public OrderProviderDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Order provider CODE is NULL");
            return null;
        }
        return orderProviderRepository.findOrderProviderByCode(code)
                .map(OrderProviderDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No order with the Code = " + code + " was found", ErrorCodes.ORDER_PROVIDER_NOT_FOUND
                ));
    }

    @Override
    public List<OrderProviderDto> findAll() {
        return orderProviderRepository.findAll().stream()
                .map(OrderProviderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Order Provider ID is NULL");
            return;
        }
        orderProviderRepository.deleteById(id);
    }
}
