package com.brahim.stockmanagement.repository;

import java.util.List;

import com.brahim.stockmanagement.model.OrderLineProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineProviderRepository extends JpaRepository<OrderLineProvider, Integer> {
}
