package com.brahim.stockmanagement.services;

import com.brahim.stockmanagement.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto dto);

    UserDto findById(Integer id);

    List<UserDto> findAll();

    void delete(Integer id);

}
