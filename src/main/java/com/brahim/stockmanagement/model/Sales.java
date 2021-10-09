package com.brahim.stockmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="sales")
public class Sales extends AbstractEntity{
    @Column(name = "code")
    private String code;

    @Column(name = "saledate")
    private Instant saleDate;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "idcompany")
    private Integer idComapny;

    @OneToMany(mappedBy = "sale")
    private List<SaleLine> saleLines;
}
