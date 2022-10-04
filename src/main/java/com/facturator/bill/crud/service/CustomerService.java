package com.facturator.bill.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturator.bill.crud.entity.Customer;
import com.facturator.bill.crud.repository.ClientRepository;

@Service
public class CustomerService {

	@Autowired
	private ClientRepository cr;
	
	@Transactional
	public Customer saveCustomer(Customer cli) {
	
		Customer newCustomer = cr.save(cli);
		return newCustomer ;
		
	}
	
	public List<Customer> allCustomer(){
		
		List<Customer> allCustomer = cr.findAll();
		return allCustomer;
	}
	
	public Customer findCustomer(int id) {
		Optional<Customer> resultatId = cr.findById(id);
		
		Customer testId = null;
		
		if (resultatId.isPresent()) {
			testId = resultatId.get();
		} else {
			throw new RuntimeException("Je n'ai pas trouvé cette id : " + id);
		
		}
		
		return testId;
	}
	
	public void updateCustomer (Customer cli, int id) {
		cr.save(cli);
	}
	
	public void deleteCustomer(int id) {
		cr.deleteById(id);
	}
}
