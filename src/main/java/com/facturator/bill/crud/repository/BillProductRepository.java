package com.facturator.bill.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturator.bill.crud.entity.BillProduct;

public interface BillProductRepository extends JpaRepository<BillProduct, Integer> {

}
