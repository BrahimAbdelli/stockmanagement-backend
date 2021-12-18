package com.brahim.stockmanagement.controller;

import com.brahim.stockmanagement.controller.api.OrderProviderApi;
import com.brahim.stockmanagement.dto.OrderProviderDto;
import com.brahim.stockmanagement.services.ArticleService;
import com.brahim.stockmanagement.services.OrderProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderProviderController implements OrderProviderApi {

    private OrderProviderService orderProviderService;

    // Field Injection
/*    @Autowired
    private OrderProviderService orderProviderService;*/

    // Getter Injection
/*    @Autowired
    public ArticleService getArticleService() {
        return orderProviderService;
    }*/

    // Constructor Injection
    @Autowired
    public OrderProviderController(OrderProviderService orderProviderService) {
        this.orderProviderService = orderProviderService;
    }

    @Override
    public OrderProviderDto save(OrderProviderDto dto) {
        return orderProviderService.save(dto);
    }

    @Override
    public OrderProviderDto findById(Integer id) {
        return orderProviderService.findById(id);
    }

    @Override
    public OrderProviderDto findByCode(String code) {
        return orderProviderService.findByCode(code);
    }

    @Override
    public List<OrderProviderDto> findAll() {
        return orderProviderService.findAll();
    }

    @Override
    public void delete(Integer id) {
        orderProviderService.delete(id);
    }
}
