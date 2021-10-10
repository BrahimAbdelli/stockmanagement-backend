package com.brahim.stockmanagement.dto;

import com.brahim.stockmanagement.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

  private String address1;

  private String address2;

  private String city;

  private String postalCode;

  private String country;

  public static AddressDto fromEntity(Address address) {
    if (address == null) {
      return null;
    }

    return AddressDto.builder()
        .address1(address.getAddress1())
        .address2(address.getAddress2())
        .postalCode(address.getPostalCode())
        .city(address.getCity())
        .country(address.getCountry())
        .build();
  }

  public static Address toEntity(AddressDto addressDto) {
    if (addressDto == null) {
      return null;
    }
    Address address = new Address();
    address.setAddress1(addressDto.getAddress1());
    address.setAddress2(addressDto.getAddress2());
    address.setPostalCode(addressDto.getPostalCode());
    address.setCity(addressDto.getCity());
    address.setCountry(addressDto.getCountry());
    return address;
  }

}
