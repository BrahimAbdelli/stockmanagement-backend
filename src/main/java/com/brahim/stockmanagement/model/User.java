package com.brahim.stockmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="user")
public class User extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "birthdate")
    private Instant birthDate;

    @Column(name = "password")
    private String password;

    @Embedded
    private Address address;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idcompany")
    private Company company;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private List<Roles> roles;

}
