package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.SalesDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/sales")
@Api(APP_ROOT + "/sales")
public interface SalesApi {
    @PostMapping(value = APP_ROOT + "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    SalesDto save(@RequestBody SalesDto dto);

    @GetMapping(value = APP_ROOT + "/{idSale}", produces = MediaType.APPLICATION_JSON_VALUE)
    SalesDto findById(@PathVariable("idSale") Integer id);

    @GetMapping(value = APP_ROOT + "/filter/{codeSale}", produces = MediaType.APPLICATION_JSON_VALUE)
    SalesDto findByCode(@PathVariable("codeSale") String code);

    @GetMapping(value = APP_ROOT + "", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SalesDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/{idSale}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idSale") Integer id);
}
