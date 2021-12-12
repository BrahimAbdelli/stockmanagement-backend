package com.brahim.stockmanagement.services.impl;

import com.brahim.stockmanagement.dto.OrderClientDto;
import com.brahim.stockmanagement.dto.OrderLineClientDto;
import com.brahim.stockmanagement.exception.EntityNotFoundException;
import com.brahim.stockmanagement.exception.ErrorCodes;
import com.brahim.stockmanagement.exception.InvalidEntityException;
import com.brahim.stockmanagement.model.Article;
import com.brahim.stockmanagement.model.Client;
import com.brahim.stockmanagement.model.OrderClient;
import com.brahim.stockmanagement.model.OrderLineClient;
import com.brahim.stockmanagement.repository.ArticleRepository;
import com.brahim.stockmanagement.repository.ClientRepository;
import com.brahim.stockmanagement.repository.OrderClientRepository;
import com.brahim.stockmanagement.repository.OrderLineClientRepository;
import com.brahim.stockmanagement.services.OrderClientService;
import com.brahim.stockmanagement.validators.OrderClientValidator;
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
public class OrderClientServiceImpl implements OrderClientService {

    private OrderClientRepository orderClientRepository;
    private OrderLineClientRepository orderLineClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public OrderClientServiceImpl(OrderClientRepository orderClientRepository) {
        this.orderClientRepository = orderClientRepository;
    }

    @Override
    public OrderClientDto save(OrderClientDto dto) {
        List<String> errors = OrderClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Order is not valid {}", dto);
            throw new InvalidEntityException("The order is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isPresent()) {
            log.warn("Client with ID {} was not found", dto.getClient().getId());
            throw new EntityNotFoundException("No Client with ID" + dto.getClient().getId() + " was found",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getOrderLineClients() != null) {
            dto.getOrderLineClients().forEach(ordLineClts -> {
                if (ordLineClts.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ordLineClts.getArticle().getId());
                    //if (article.isEmpty())
                    if (!article.isPresent()) {
                        articleErrors.add("Article with the ID " + ordLineClts.getArticle().getId() + " doesn't exist");
                    }
                } else {
                    articleErrors.add("Cannot register an Order with a NULL article");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article does not exist", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        //dto.setOrderDate(Instant.now());
        OrderClient savedOrderClient = orderClientRepository.save(OrderClientDto.toEntity(dto));

        if (dto.getOrderLineClients() != null) {
            dto.getOrderLineClients().forEach(ligCmdClt -> {
                OrderLineClient orderLineClient = OrderLineClientDto.toEntity(ligCmdClt);
                orderLineClient.setOrderClient(savedOrderClient);
                orderLineClient.setIdCompany(dto.getIdCompany());
                OrderLineClient savedOrderLine = orderLineClientRepository.save(orderLineClient);

                //effectuerSortie(savedOrderLine);
            });
        }

        return OrderClientDto.fromEntity(savedOrderClient);
    }

    @Override
    public OrderClientDto findById(Integer id) {
        if (id == null) {
            log.error("Order ID is null");
            return null;
        }

        return orderClientRepository.findById(id).map(OrderClientDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "No order with the ID = " + id + " was found",
                        ErrorCodes.ORDER_CLIENT_NOT_FOUND)
        );
    }

    @Override
    public OrderClientDto findByCode(String code) {
        if (StringUtils.hasLength(code)) {
            log.error(("Order client code is null"));
            return null;
        }
        return orderClientRepository.findOrderClientByCode(code).map(OrderClientDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No order with the Code = " + code + " was found"));
    }

    @Override
    public List<OrderClientDto> findAll() {
        return orderClientRepository.findAll().stream()
                .map(OrderClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Order ID is null");
            return;
        }
        orderClientRepository.deleteById(id);
    }
}
