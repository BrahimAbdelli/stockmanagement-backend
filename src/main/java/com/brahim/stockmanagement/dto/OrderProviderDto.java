package com.brahim.stockmanagement.dto;

import java.time.Instant;
import java.util.List;

import com.brahim.stockmanagement.model.OrderProvider;
import com.brahim.stockmanagement.model.OrderStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderProviderDto {

  private Integer id;

  private String code;

  private Instant commandDate;

  private OrderStatus orderStatus;

  private ProviderDto provider;

  private Integer idCompany;

  private List<OrderLineProviderDto> orderLineProviders;

  public static OrderProviderDto fromEntity(OrderProvider orderProvider) {
    if (orderProvider == null) {
      return null;
    }
    return OrderProviderDto.builder()
        .id(orderProvider.getId())
        .code(orderProvider.getCode())
        .commandDate(orderProvider.getCommandDate())
        .provider(ProviderDto.fromEntity(orderProvider.getProvider()))
        //.orderStatus(orderProvider.getOrderStatus())
        .idCompany(orderProvider.getIdCompany())
        .build();
  }

  public static OrderProvider toEntity(OrderProviderDto dto) {
    if (dto == null) {
      return null;
    }
    OrderProvider orderProvider = new OrderProvider();
    orderProvider.setId(dto.getId());
    orderProvider.setCode(dto.getCode());
    orderProvider.setCommandDate(dto.getCommandDate());
    orderProvider.setProvider(ProviderDto.toEntity(dto.getProvider()));
    orderProvider.setIdCompany(dto.getIdCompany());
    //orderProvider.setOrderStatus(dto.getOrderStatus());
    return orderProvider;
  }

/*  public boolean isCommandeLivree() {
    return EtatCommande.LIVREE.equals(this.etatCommande);
  }*/

}
