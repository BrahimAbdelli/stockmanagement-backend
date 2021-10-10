package com.brahim.stockmanagement.dto;

import com.brahim.stockmanagement.model.Provider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProviderDto {

  private Integer id;

  private String name;

  private String lastname;

  private AddressDto address;

  private String photo;

  private String mail;

  private String phone;

  private Integer idCompany;

  @JsonIgnore
  private List<OrderProviderDto> orderProviders;

  public static ProviderDto fromEntity(Provider provider) {
    if (provider == null) {
      return null;
    }
    return ProviderDto.builder()
        .id(provider.getId())
        .name(provider.getName())
        .lastname(provider.getLastname())
        .address(AddressDto.fromEntity(provider.getAddress()))
        .photo(provider.getPhoto())
        .mail(provider.getMail())
        .phone(provider.getPhone())
        .idCompany(provider.getIdCompany())
        .build();
  }

  public static Provider toEntity(ProviderDto dto) {
    if (dto == null) {
      return null;
    }
    Provider provider = new Provider();
    provider.setId(dto.getId());
    provider.setName(dto.getName());
    provider.setLastname(dto.getLastname());
    provider.setAddress(AddressDto.toEntity(dto.getAddress()));
    provider.setPhoto(dto.getPhoto());
    provider.setMail(dto.getMail());
    provider.setPhone(dto.getPhone());
    provider.setIdCompany(dto.getIdCompany());

    return provider;
  }
}
