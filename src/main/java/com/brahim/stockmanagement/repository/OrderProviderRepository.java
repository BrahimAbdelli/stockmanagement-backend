package com.brahim.stockmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.brahim.stockmanagement.model.OrderClient;
import com.brahim.stockmanagement.model.OrderProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProviderRepository extends JpaRepository<OrderProvider, Integer> {
}
