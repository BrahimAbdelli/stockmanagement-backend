package com.brahim.stockmanagement.repository;

import com.brahim.stockmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
