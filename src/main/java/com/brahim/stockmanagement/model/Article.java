package com.brahim.stockmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="article")
public class Article extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "unitpriceet")
    private BigDecimal unitPriceET;

    @Column(name = "ratevat")
    private BigDecimal rateVAT;

    @Column(name = "unitpriceincl")
    private BigDecimal unitPriceIncl;

    @Column(name = "photo")
    private String photo;

    @Column(name = "idcompany")
    private Integer idCompany;

    @ManyToOne
    @JoinColumn(name="idcategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<SaleLine> sellsline;

    @OneToMany(mappedBy = "article")
    private List<OrderLineClient> orderLineClients;

    @OneToMany(mappedBy = "article")
    private List<OrderLineProvider> orderLineProviders;

    @OneToMany(mappedBy = "article")
    private List<StockMvt> stocksMvt;
}
