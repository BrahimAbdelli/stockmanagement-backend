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
@Table(name="orderclient")
public class OrderClient extends AbstractEntity{
    @Column(name = "code")
    private String code;

    @Column(name = "commanddate")
    private Instant commandDate;

    /*@Column(name = "orderstatus")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;*/

    @Column(name = "idcompany")
    private Integer idCompany;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    @OneToMany(mappedBy = "orderClient")
    private List<OrderLineClient> orderLineClients;
}
