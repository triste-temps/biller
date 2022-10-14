package com.facturator.bill.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.facturator.bill.crud.controller", "com.facturator.bill.crud.service","com.facturator.bill.crud.entity", "com.facturator.bill.crud.repository"})
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}