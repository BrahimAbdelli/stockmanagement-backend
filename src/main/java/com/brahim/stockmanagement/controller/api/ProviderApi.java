package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.ProviderDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping("/providers")
@Api(APP_ROOT + "/providers")
public interface ProviderApi {
    @PostMapping(value = APP_ROOT + "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProviderDto save(@RequestBody ProviderDto dto);

    @GetMapping(value = APP_ROOT + "/{idProvider}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProviderDto findById(@PathVariable("idProvider") Integer id);

    @GetMapping(value = APP_ROOT + "", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProviderDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/{idProvider}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idProvider") Integer id);
}
