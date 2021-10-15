package com.brahim.stockmanagement.repository;


import java.util.Optional;

import com.brahim.stockmanagement.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
