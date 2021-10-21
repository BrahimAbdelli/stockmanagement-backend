package com.brahim.stockmanagement.services.impl;

import com.brahim.stockmanagement.dto.ProviderDto;
import com.brahim.stockmanagement.exception.EntityNotFoundException;
import com.brahim.stockmanagement.exception.ErrorCodes;
import com.brahim.stockmanagement.exception.InvalidEntityException;
import com.brahim.stockmanagement.repository.ProviderRepository;
import com.brahim.stockmanagement.services.ProviderService;
import com.brahim.stockmanagement.validators.ProviderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProviderServiceImpl implements ProviderService {


    private ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public ProviderDto save(ProviderDto dto) {
        List<String> errors = ProviderValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Provider is not valid {}", dto);
            throw new InvalidEntityException("The provider is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        return ProviderDto.fromEntity(providerRepository.save(ProviderDto.toEntity(dto)));
    }

    @Override
    public ProviderDto findById(Integer id) {
        if (id == null) {
            log.error("Provider ID is null");
            return null;
        }

        return providerRepository.findById(id).map(ProviderDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "No provider with the ID = " + id + " was found",
                        ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<ProviderDto> findAll() {
        return providerRepository.findAll().stream()
                .map(ProviderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Provider ID is null");
            return;
        }
        providerRepository.deleteById(id);
    }
}
