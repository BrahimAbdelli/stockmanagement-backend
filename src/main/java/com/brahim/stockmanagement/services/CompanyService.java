package com.brahim.stockmanagement.services;

import com.brahim.stockmanagement.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    CompanyDto save(CompanyDto dto);

    CompanyDto findById(Integer id);

    List<CompanyDto> findAll();

    void delete(Integer id);

}
