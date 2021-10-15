package com.brahim.stockmanagement.repository;

import com.brahim.stockmanagement.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
