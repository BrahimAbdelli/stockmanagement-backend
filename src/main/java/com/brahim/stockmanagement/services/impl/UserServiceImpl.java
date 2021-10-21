package com.brahim.stockmanagement.services.impl;

import com.brahim.stockmanagement.dto.UserDto;
import com.brahim.stockmanagement.exception.EntityNotFoundException;
import com.brahim.stockmanagement.exception.ErrorCodes;
import com.brahim.stockmanagement.exception.InvalidEntityException;
import com.brahim.stockmanagement.repository.UserRepository;
import com.brahim.stockmanagement.services.UserService;
import com.brahim.stockmanagement.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto dto) {
        List<String> errors = UserValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("User is not valid {}", dto);
            throw new InvalidEntityException("The user is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(dto)));
    }

    @Override
    public UserDto findById(Integer id) {
        if (id == null) {
            log.error("User ID is null");
            return null;
        }

        return userRepository.findById(id).map(UserDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "No user with the ID = " + id + " was found",
                        ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("User ID is null");
            return;
        }
        userRepository.deleteById(id);
    }
}
