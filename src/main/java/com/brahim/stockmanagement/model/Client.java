package com.brahim.stockmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="client")
public class Client extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Embedded
    private Address address;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "idCompany")
    private Integer idCompany;

    @OneToMany(mappedBy = "client")
    private List<OrderClient> orderClients;
}
