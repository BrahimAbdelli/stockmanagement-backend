package com.brahim.stockmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="stockmvt")
public class StockMvt extends AbstractEntity {
    @Column(name = "mvtdate")
    private Instant mvtDate;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "typestockmvt")
    @Enumerated(EnumType.STRING)
    private TypeStockMvt typeStockMvt;

    @Column(name = "idCompany")
    private Integer idComapny;
}
