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
@Table(name="sellline")
public class SaleLine extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "idsale")
    private Sales sale;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitPrice")
    private BigDecimal unitPrice;

    @Column(name = "idcompany")
    private Integer idCompany;
}
