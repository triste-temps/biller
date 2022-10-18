package com.facturator.bill.crud.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturator.bill.crud.security.models.Company;

public interface UserRepository extends JpaRepository<Company, Long>{

	Optional<Company> findByUsername(String username);

}
