package com.brahim.stockmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="orderlineprovider")
public class OrderLineProvider extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idorderprovider")
    private OrderProvider orderProvider;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;

    @Column(name = "idcompany")
    private Integer idCompany;
}
