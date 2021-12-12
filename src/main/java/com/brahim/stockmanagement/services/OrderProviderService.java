package com.brahim.stockmanagement.services;

import com.brahim.stockmanagement.dto.OrderClientDto;
import com.brahim.stockmanagement.dto.OrderProviderDto;

import java.util.List;

public interface OrderProviderService {

    OrderProviderDto save(OrderProviderDto dto);

    OrderProviderDto findById(Integer id);

    OrderProviderDto findByCode(String code);

    List<OrderProviderDto> findAll();

    void delete(Integer id);

}
