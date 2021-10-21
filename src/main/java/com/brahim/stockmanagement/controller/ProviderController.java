package com.brahim.stockmanagement.controller;

import com.brahim.stockmanagement.controller.api.ProviderApi;
import com.brahim.stockmanagement.dto.ProviderDto;
import com.brahim.stockmanagement.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProviderController implements ProviderApi {

    private ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public ProviderDto save(ProviderDto dto) {
        return providerService.save(dto);
    }

    @Override
    public ProviderDto findById(Integer id) {
        return providerService.findById(id);
    }

    @Override
    public List<ProviderDto> findAll() {
        return providerService.findAll();
    }

    @Override
    public void delete(Integer id) {
        providerService.delete(id);
    }
}
