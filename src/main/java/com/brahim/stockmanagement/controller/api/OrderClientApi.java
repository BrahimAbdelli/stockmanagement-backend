package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.OrderClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping("/orderclient")
public interface OrderClientApi {
    @PostMapping(value = APP_ROOT + "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    OrderClientDto save(@RequestBody OrderClientDto dto);

    @GetMapping(value = APP_ROOT + "/{idOrderClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderClientDto findById(@PathVariable("idOrderClient") Integer id);

    @GetMapping(value = APP_ROOT + "", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/{idOrderClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idOrderClient") Integer id);
}
