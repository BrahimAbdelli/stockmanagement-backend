package com.brahim.stockmanagement.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.brahim.stockmanagement.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

  private Integer id;

  private String name;

  private String lastname;

  private String email;

  private Instant birthDate;

  private String password;

  private AddressDto address;

  private String photo;

  private CompanyDto company;

  private List<RolesDto> roles;

  public static UserDto fromEntity(User user) {
    if (user == null) {
      return null;
    }

    return UserDto.builder()
        .id(user.getId())
        .name(user.getName())
        .lastname(user.getLastname())
        .email(user.getEmail())
        .password(user.getPassword())
        .birthDate(user.getBirthDate())
        .address(AddressDto.fromEntity(user.getAddress()))
        .photo(user.getPhoto())
        .company(CompanyDto.fromEntity(user.getCompany()))
        .roles(
                user.getRoles() != null ?
                        user.getRoles().stream()
                    .map(RolesDto::fromEntity)
                    .collect(Collectors.toList()) : null
        )
        .build();
  }

  public static User toEntity(UserDto dto) {
    if (dto == null) {
      return null;
    }

    User user = new User();
    user.setId(dto.getId());
    user.setName(dto.getName());
    user.setLastname(dto.getLastname());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    user.setBirthDate(dto.getBirthDate());
    user.setAddress(AddressDto.toEntity(dto.getAddress()));
    user.setPhoto(dto.getPhoto());
    user.setCompany(CompanyDto.toEntity(dto.getCompany()));

    return user;
  }
}
