package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.CompanyDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/companies")
@Api(APP_ROOT + "/companies")
public interface CompanyApi {
    @PostMapping(value = APP_ROOT + "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CompanyDto save(@RequestBody CompanyDto dto);

    @GetMapping(value = APP_ROOT + "/{idCompany}", produces = MediaType.APPLICATION_JSON_VALUE)
    CompanyDto findById(@PathVariable("idCompany") Integer id);

    @GetMapping(value = APP_ROOT + "", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CompanyDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/{idCompany}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idCompany") Integer id);
}
