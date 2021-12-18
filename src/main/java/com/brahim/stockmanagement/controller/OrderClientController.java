package com.brahim.stockmanagement.controller;

import com.brahim.stockmanagement.controller.api.OrderClientApi;
import com.brahim.stockmanagement.dto.OrderClientDto;
import com.brahim.stockmanagement.services.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
    public OrderClientDto findByCode(String code) { return orderClientService.findByCode(code);}

    @Override
    public List<OrderClientDto> findAll() {
        return orderClientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        orderClientService.findAll();
    }

}
