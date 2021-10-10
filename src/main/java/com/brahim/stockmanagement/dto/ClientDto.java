package com.brahim.stockmanagement.dto;


import com.brahim.stockmanagement.model.Address;
import com.brahim.stockmanagement.model.Client;
import com.brahim.stockmanagement.model.OrderClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {

  private Integer id;

  private String name;

  private String lastname;

  private AddressDto address;

  private String photo;

  private String mail;

  private String phone;

  private Integer idCompany;

  @JsonIgnore
  private List<OrderClient> orderClients;

  public static ClientDto fromEntity(Client client) {
    if (client == null) {
      return null;
    }
    return ClientDto.builder()
        .id(client.getId())
        .name(client.getName())
        .lastname(client.getLastname())
        .address(AddressDto.fromEntity(client.getAddress()))
        .photo(client.getPhoto())
        .mail(client.getMail())
        .phone(client.getPhone())
        .idCompany(client.getIdCompany())
        .build();
  }

  public static Client toEntity(ClientDto dto) {
    if (dto == null) {
      return null;
    }
    Client client = new Client();
    client.setId(dto.getId());
    client.setName(dto.getName());
    client.setLastname(dto.getLastname());
    client.setAddress(AddressDto.toEntity(dto.getAddress()));
    client.setPhoto(dto.getPhoto());
    client.setMail(dto.getMail());
    client.setPhone(dto.getPhone());
    client.setIdCompany(dto.getIdCompany());
    return client;
  }

}
