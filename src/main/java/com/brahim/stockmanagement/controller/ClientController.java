package com.brahim.stockmanagement.controller;

import com.brahim.stockmanagement.controller.api.ClientApi;
import com.brahim.stockmanagement.dto.ClientDto;
import com.brahim.stockmanagement.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientController implements ClientApi {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
