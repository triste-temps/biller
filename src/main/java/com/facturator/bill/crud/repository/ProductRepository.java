package com.facturator.bill.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturator.bill.crud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
