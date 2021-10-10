package com.brahim.stockmanagement.dto;

import java.time.Instant;
import java.util.List;

import com.brahim.stockmanagement.model.OrderClient;
import com.brahim.stockmanagement.model.OrderStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderClientDTO {

  private Integer id;

  private String code;

  private Instant commandDate;

  private OrderStatus orderStatus;

  private ClientDto client;

  private Integer idCompany;

  private List<OrderLineClientDto> OrderLineClients;

  public static OrderClientDTO fromEntity(OrderClient orderClient) {
    if (orderClient == null) {
      return null;
    }
    return OrderClientDTO.builder()
        .id(orderClient.getId())
        .code(orderClient.getCode())
        .commandDate(orderClient.getCommandDate())
        //.etatCommande(orderClient.getEtatCommande())
        .client(ClientDto.fromEntity(orderClient.getClient()))
        .idCompany(orderClient.getIdCompany())
        .build();

  }

  public static OrderClient toEntity(OrderClientDTO dto) {
    if (dto == null) {
      return null;
    }
    OrderClient orderClient = new OrderClient();
    orderClient.setId(dto.getId());
    orderClient.setCode(dto.getCode());
    orderClient.setClient(ClientDto.toEntity(dto.getClient()));
    orderClient.setCommandDate(dto.getCommandDate());
    //orderClient.setEtatCommande(dto.getEtatCommande());
    orderClient.setIdCompany(dto.getIdCompany());
    return orderClient;
  }

/*  public boolean isCommandeLivree() {
    return EtatCommande.LIVREE.equals(this.etatCommande);
  }*/
}
