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

    @Column(name = "commanddate")
    private Instant commandDate;

    /*@Column(name = "orderstatus")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;*/

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idprovider")
    private Provider provider;

    @OneToMany(mappedBy = "orderProvider")
    private List<OrderLineProvider> orderLineProviders;
}
