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

import com.facturator.bill.crud.entity.BillProduct;
import com.facturator.bill.crud.service.BillProductService;

@RestController
@RequestMapping("/facturation")
public class BillProductController {

	@Autowired
	private BillProductService fps;
	
	@PostMapping("/factureProduit")
	public BillProduct saveBillProduct(@RequestBody BillProduct fp) {
		BillProduct newBillProduct = fps.saveBillProduct(fp);
		return newBillProduct;
	}
	
	@GetMapping("/listeFactureProduit")
	public List<BillProduct> allBillProduct(){
		List<BillProduct> allBillProduct = fps.allBillProduct();
		return allBillProduct;
	}
	
	@GetMapping("/listeFactureProduit/{fcId}")
	public BillProduct findBillProduct(@PathVariable int fcId) {
	BillProduct newBillProduct = fps.findBillProduct(fcId);
	return newBillProduct;
	}
	
	@PutMapping("/listeFactureProduit")
	public BillProduct updateBillProduct(@RequestBody BillProduct fp) {
		fps.saveBillProduct(fp);
		return fp;
	}
	
	@DeleteMapping("/listeFactureProduit/{cNumero}")
	public void deleteBillProduct(@PathVariable("fcId") int id) {
		fps.deleteBillProduct(id);
	}
	
}