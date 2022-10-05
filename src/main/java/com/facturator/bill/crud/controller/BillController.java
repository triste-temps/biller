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

import com.facturator.bill.crud.entity.Bill;
import com.facturator.bill.crud.service.BillService;

@RestController
@RequestMapping("/billing")
public class BillController {

	@Autowired
	private BillService billService;
	
	@PostMapping("/bill")
	public Bill saveBill(@RequestBody Bill bill) {
		Bill newBill = billService.saveBill(bill);
		return newBill;
	}
	
	@GetMapping("/listBill")
	public List<Bill> allBill(){
	List<Bill> listAllBill = billService.allBill();
	return listAllBill;
	}
	
	@GetMapping("/listBill/{fNumero}")
	public Bill findBill(@PathVariable int fNumero) {
		Bill newBill = billService.findBill(fNumero);
		return newBill;
	}
	
	@PutMapping("/listBill")
	public Bill updateBill(@RequestBody Bill bill) {
		billService.saveBill(bill);
		return bill;
	}
	
	@DeleteMapping("/listBill/{fNumero}")
	public void deleteBill(@PathVariable("fNumero") int id) {
		billService.deleteBill(id);
	}
}
