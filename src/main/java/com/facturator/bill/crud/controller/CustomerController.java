package com.facturator.bill.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturator.bill.crud.dto.CustomerDTO;
import com.facturator.bill.crud.dto.mapper.CustomerMapper;
import com.facturator.bill.crud.entity.Customer;
import com.facturator.bill.crud.service.CustomerService;

@RestController
@RequestMapping("/billing")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	


  @PostMapping("/customer")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer) {
		return CustomerMapper.toDtoWithBill(customerService.saveCustomer(CustomerMapper.toEntity(customer)));
	}
	
	@GetMapping("/listCustomer")
  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<CustomerDTO> allCustomer(){
		return CustomerMapper.toDtoListWithBill(customerService.allCustomer());
	}
	
	@GetMapping("/listCustomer/{cNumero}")
  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public CustomerDTO findCustomer(@PathVariable int cNumero) {
		CustomerDTO newCustomer = CustomerMapper.toDtoWithBill(customerService.findCustomer(cNumero));
		return newCustomer;
	}
	

  @PutMapping("/listCustomer")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO customer) {
		if(customer.getcNumero()!=0) {
			return saveCustomer(customer);
		}
		return customer;
	}
	
	@DeleteMapping("/listCustomer/{cNumero}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteCustomer(@PathVariable("cNumero") int id) {
		customerService.deleteCustomer(id);
	 }
}