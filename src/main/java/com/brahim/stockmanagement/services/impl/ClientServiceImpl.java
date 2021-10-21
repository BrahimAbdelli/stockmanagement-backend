package com.brahim.stockmanagement.services.impl;

import com.brahim.stockmanagement.dto.ClientDto;
import com.brahim.stockmanagement.exception.EntityNotFoundException;
import com.brahim.stockmanagement.exception.ErrorCodes;
import com.brahim.stockmanagement.exception.InvalidEntityException;
import com.brahim.stockmanagement.repository.ClientRepository;
import com.brahim.stockmanagement.services.ClientService;
import com.brahim.stockmanagement.validators.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("The client is not valid", ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }

        return clientRepository.findById(id).map(ClientDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "No client with the ID = " + id + " was found",
                        ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return;
        }
        clientRepository.deleteById(id);
    }
}
