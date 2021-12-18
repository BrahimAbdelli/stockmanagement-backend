package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.ClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/clients")
@Api(APP_ROOT + "/clients")
public interface ClientApi {
    @PostMapping(value = APP_ROOT + "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT + "/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Integer id);

    @GetMapping(value = APP_ROOT + "", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idClient") Integer id);
}
