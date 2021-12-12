package com.brahim.stockmanagement.services;

import com.brahim.stockmanagement.dto.OrderClientDto;

import java.util.List;

public interface OrderClientService {

    OrderClientDto save(OrderClientDto dto);

    OrderClientDto findById(Integer id);

    OrderClientDto findByCode(String code);

    List<OrderClientDto> findAll();

    void delete(Integer id);

}
