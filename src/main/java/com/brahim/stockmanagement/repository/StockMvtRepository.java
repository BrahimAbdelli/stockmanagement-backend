package com.brahim.stockmanagement.repository;

import java.math.BigDecimal;
import java.util.List;

import com.brahim.stockmanagement.model.StockMvt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockMvtRepository extends JpaRepository<StockMvt, Integer> {
}
