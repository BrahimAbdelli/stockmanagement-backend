package com.brahim.stockmanagement.repository;

import java.util.List;
import java.util.Optional;

import com.brahim.stockmanagement.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderClientRepository extends JpaRepository<OrderClient, Integer> {

  Optional<OrderClient> findOrderClientByCode(String code);

  List<OrderClient> findAllByClientId(Integer id);
}
