package com.brahim.stockmanagement.controller;

import com.brahim.stockmanagement.controller.api.CompanyApi;
import com.brahim.stockmanagement.dto.CompanyDto;
import com.brahim.stockmanagement.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController implements CompanyApi {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public CompanyDto save(CompanyDto dto) {
        return companyService.save(dto);
    }

    @Override
    public CompanyDto findById(Integer id) {
        return companyService.findById(id);
    }

    @Override
    public List<CompanyDto> findAll() {
        return companyService.findAll();
    }

    @Override
    public void delete(Integer id) {
        companyService.findAll();
    }

}
