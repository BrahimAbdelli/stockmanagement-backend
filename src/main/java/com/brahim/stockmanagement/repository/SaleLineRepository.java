package com.brahim.stockmanagement.repository;

import java.util.List;

import com.brahim.stockmanagement.model.SaleLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleLineRepository extends JpaRepository<SaleLine, Integer> {
}
