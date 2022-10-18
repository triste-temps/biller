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

import com.facturator.bill.crud.entity.BillProduct;
import com.facturator.bill.crud.service.BillProductService;

@RestController
@RequestMapping("/billing")
public class BillProductController {

	@Autowired
	private BillProductService billProductService;
	
	@PostMapping("/billProduct")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public BillProduct saveBillProduct(@RequestBody BillProduct billProduct) {
		BillProduct newBillProduct = billProductService.saveBillProduct(billProduct);
		return newBillProduct;
	}
	
	@GetMapping("/listBillProduct")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<BillProduct> allBillProduct(){
		List<BillProduct> allBillProduct = billProductService.allBillProduct();
		return allBillProduct;
	}
	
	@GetMapping("/listBillProduct/{fcId}")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public BillProduct findBillProduct(@PathVariable int fcId) {
	BillProduct newBillProduct = billProductService.findBillProduct(fcId);
	return newBillProduct;
	}
	
	@PutMapping("/listBillProduct")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public BillProduct updateBillProduct(@RequestBody BillProduct billProduct) {
		billProductService.saveBillProduct(billProduct);
		return billProduct;
	}
	
	@DeleteMapping("/listBillProduct/{cNumero}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteBillProduct(@PathVariable("fcId") int id) {
		billProductService.deleteBillProduct(id);
	}
	
}