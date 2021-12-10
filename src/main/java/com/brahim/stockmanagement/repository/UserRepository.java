package com.brahim.stockmanagement.repository;

import java.util.Optional;

import com.brahim.stockmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

  // JPQL query
  @Query(value = "select u from User u where u.email = :email")
  Optional<User> findUserByEmail(@Param("email") String email);

}
