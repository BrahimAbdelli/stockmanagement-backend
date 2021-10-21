package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping("/users")
public interface UserApi {
    @PostMapping(value = APP_ROOT + "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto save(@RequestBody UserDto dto);

    @GetMapping(value = APP_ROOT + "/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto findById(@PathVariable("idUser") Integer id);

    @GetMapping(value = APP_ROOT + "", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idUser") Integer id);
}
