package com.brahim.stockmanagement.controller;

import com.brahim.stockmanagement.controller.api.OrderClientApi;
import com.brahim.stockmanagement.dto.OrderClientDto;
import com.brahim.stockmanagement.services.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderClientController implements OrderClientApi {

    private OrderClientService orderClientService;

    @Autowired
    public OrderClientController(OrderClientService orderClientService) {
        this.orderClientService = orderClientService;
    }

    @Override
    public OrderClientDto save(OrderClientDto dto) {
        return orderClientService.save(dto);
    }

    @Override
    public OrderClientDto findById(Integer id) {
        return orderClientService.findById(id);
    }

    @Override
    public List<OrderClientDto> findAll() {
        return orderClientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        orderClientService.findAll();
    }

}
