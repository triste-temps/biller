package com.facturator.bill.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturator.bill.crud.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
