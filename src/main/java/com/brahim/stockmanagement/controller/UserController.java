package com.brahim.stockmanagement.controller;

import com.brahim.stockmanagement.controller.api.UserApi;
import com.brahim.stockmanagement.dto.UserDto;
import com.brahim.stockmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserController implements UserApi {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto save(UserDto dto) {
        return userService.save(dto);
    }

    @Override
    public UserDto findById(Integer id) {
        return userService.findById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }
}
