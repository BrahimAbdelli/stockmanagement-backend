package com.brahim.stockmanagement.dto;

import com.brahim.stockmanagement.model.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {

  private Integer id;

  private String name;

  private String description;

  private AddressDto address;

  private String taxCode;

  private String photo;

  private String email;

  private String phone;

  private String website;


  @JsonIgnore
  private List<UserDto> users;

  public static CompanyDto fromEntity(Company company) {
    if (company == null) {
      return null;
    }
    return CompanyDto.builder()
        .id(company.getId())
        .name(company.getName())
        .description(company.getDescription())
        .address(AddressDto.fromEntity(company.getAddress()))
        .taxCode(company.getTaxCode())
        .photo(company.getPhoto())
        .email(company.getEmail())
        .phone(company.getPhone())
        .website(company.getWebsite())
        .build();
  }

  public static Company toEntity(CompanyDto dto) {
    if (dto == null) {
      return null;
    }
    Company company = new Company();
    company.setId(dto.getId());
    company.setName(dto.getName());
    company.setDescription(dto.getDescription());
    company.setAddress(AddressDto.toEntity(dto.getAddress()));
    company.setTaxCode(dto.getTaxCode());
    company.setPhoto(dto.getPhoto());
    company.setEmail(dto.getEmail());
    company.setPhone(dto.getPhone());
    company.setWebsite(dto.getWebsite());

    return company;
  }

}
