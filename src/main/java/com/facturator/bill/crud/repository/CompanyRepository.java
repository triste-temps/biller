package com.facturator.bill.crud.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturator.bill.crud.security.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, BigInteger> {

	Optional<Company> findByEmail(String email);

}