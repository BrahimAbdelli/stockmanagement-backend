package com.brahim.stockmanagement.services;

import com.brahim.stockmanagement.dto.OrderClientDto;
import com.brahim.stockmanagement.dto.SalesDto;

import java.util.List;

public interface SalesService {
    SalesDto save(SalesDto dto);

    SalesDto findById(Integer id);

    SalesDto findByCode(String code);

    List<SalesDto> findAll();

    void delete(Integer id);
}
