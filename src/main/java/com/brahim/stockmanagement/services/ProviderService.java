package com.brahim.stockmanagement.services;

import com.brahim.stockmanagement.dto.ProviderDto;

import java.util.List;

public interface ProviderService {

    ProviderDto save(ProviderDto dto);

    ProviderDto findById(Integer id);

    List<ProviderDto> findAll();

    void delete(Integer id);

}
