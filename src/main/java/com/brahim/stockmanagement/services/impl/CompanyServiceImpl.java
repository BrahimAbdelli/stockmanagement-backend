package com.brahim.stockmanagement.services.impl;

import com.brahim.stockmanagement.dto.CompanyDto;
import com.brahim.stockmanagement.exception.EntityNotFoundException;
import com.brahim.stockmanagement.exception.ErrorCodes;
import com.brahim.stockmanagement.exception.InvalidEntityException;
import com.brahim.stockmanagement.repository.CompanyRepository;
import com.brahim.stockmanagement.services.CompanyService;
import com.brahim.stockmanagement.validators.CompanyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {


    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyDto save(CompanyDto dto) {
        List<String> errors = CompanyValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Company is not valid {}", dto);
            throw new InvalidEntityException("The company is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        return CompanyDto.fromEntity(companyRepository.save(CompanyDto.toEntity(dto)));
    }

    @Override
    public CompanyDto findById(Integer id) {
        if (id == null) {
            log.error("Company ID is null");
            return null;
        }

        return companyRepository.findById(id).map(CompanyDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "No company with the ID = " + id + " was found",
                        ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CompanyDto> findAll() {
        return companyRepository.findAll().stream()
                .map(CompanyDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Company ID is null");
            return;
        }
        companyRepository.deleteById(id);
    }
}
