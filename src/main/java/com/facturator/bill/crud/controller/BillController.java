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

import com.facturator.bill.crud.entity.Facture;
import com.facturator.bill.crud.service.BillService;

@RestController
@RequestMapping("/facturation")
public class BillController {

	@Autowired
	private BillService fs;
	
	@PostMapping("/facture")
	public Facture saveBill(@RequestBody Facture fac) {
		Facture newBill = fs.saveBill(fac);
		return newBill;
	}
	
	@GetMapping("/listeFacture")
	public List<Facture> allBill(){
	List<Facture> listAllBill = fs.allBill();
	return listAllBill;
	}
	
	@GetMapping("/listeFacture/{fNumero}")
	public Facture findBill(@PathVariable int fNumero) {
		Facture newBill = fs.findBill(fNumero);
		return newBill;
	}
	
	@PutMapping("/listefacture")
	public Facture updateBill(@RequestBody Facture fac) {
		fs.saveBill(fac);
		return fac;
	}
	
	@DeleteMapping("/listefacture/{fNumero}")
	public void deleteBill(@PathVariable("fNumero") int id) {
		fs.deleteBill(id);
	}
}
