package com.brahim.stockmanagement.repository;

import java.util.List;

import com.brahim.stockmanagement.model.OrderLineClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineClientRepository extends JpaRepository<OrderLineClient, Integer> {

  List<OrderLineClient> findAllByOrderClientId(Integer id);

  List<OrderLineClient> findAllByArticleId(Integer id);
}
