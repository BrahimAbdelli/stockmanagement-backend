package com.brahim.stockmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="orderprovider")
public class OrderProvider extends AbstractEntity{
    @Column(name = "code")
    private String code;

    @Column(name = "orderdate")
    private Instant orderDate;

    /*@Column(name = "orderstatus")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;*/

    @Column(name = "idcompany")
    private Integer idCompany;

    @ManyToOne
    @JoinColumn(name = "idprovider")
    private Provider provider;

    @OneToMany(mappedBy = "orderProvider")
    private List<OrderLineProvider> orderLineProviders;
}
