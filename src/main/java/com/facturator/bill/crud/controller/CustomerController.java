package com.facturator.bill.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturator.bill.crud.entity.Customer;
import com.facturator.bill.crud.service.CustomerService;

@RestController
@RequestMapping("/facturation")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@PostMapping("/client")
	public Customer saveCustomer(@RequestBody Customer cli) {
		Customer newCustomer = cs.saveCustomer(cli);
		return newCustomer;
	}
	
	@GetMapping("/listeclient")
	public List<Customer> allCustomer(){
		List<Customer> listAllCustomer = cs.allCustomer();
		return listAllCustomer;
	}
	
	@GetMapping("/listeclient/{cNumero}")
	public Customer findCustomer(@PathVariable int cNumero) {
		Customer newCustomer = cs.findCustomer(cNumero);
		return newCustomer;
	}
	
	@PutMapping("/listeclient")
	public Customer updateCustomer(@RequestBody Customer cli) {
		cs.saveCustomer(cli);
		return cli;
	}
	
	 @DeleteMapping("/listecustomer/{cNumero}")
	 public void deleteCustomer(@PathVariable("cNumero") int id) {
		cs.deleteCustomer(id);
	 }

}
